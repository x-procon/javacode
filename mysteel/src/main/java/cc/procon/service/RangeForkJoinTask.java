package cc.procon.service;

import cc.procon.model.po.ThsApiFuturesInfo;
import cc.procon.util.SpringContextUtil;

import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * @author procon
 * @since 2022-11-22
 */
public class RangeForkJoinTask extends RecursiveAction {
    /**
     * 超过 为串行
     */
    public int threadHold = 5;

    /**
     * 传入数据列表
     */
    public List<ThsApiFuturesInfo> infoList = null;


    public ThsService thsFuturesService;


    /**
     * 分片阈值
     */
    private int start;
    private int end;


    public RangeForkJoinTask(int start, int end, List<ThsApiFuturesInfo> list) {
        this.start = start;
        this.end = end;
        this.infoList = list;
        this.thsFuturesService = SpringContextUtil.getBean(ThsService.class);

    }

    @Override
    protected void compute() {
        // 小于阈值直接执行
        if (end - start <= threadHold) {
            for (int i = start; i < end; i++) {
                thsFuturesService.thsCompensation(infoList.get(i).getIndexCode());
            }
        } else {
            // 递归拆解任务
            int middle = (start + end) / 2;
            RangeForkJoinTask leftTask = new RangeForkJoinTask(start, middle, infoList);
            RangeForkJoinTask rightTask = new RangeForkJoinTask(middle, end, infoList);
            invokeAll(leftTask, rightTask);
            // 等待计算完成并返回计算结果。
            leftTask.join();
            rightTask.join();
        }
    }
}
