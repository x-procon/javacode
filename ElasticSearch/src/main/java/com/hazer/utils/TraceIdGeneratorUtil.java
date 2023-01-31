package com.hazer.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

/**
 * traceId生成工具类
 *
 * @author procon
 * @since 2023-01-13
 */
@Slf4j
public class TraceIdGeneratorUtil {

    /**
     * 消费端创建TraceId,并设置到线程上下文中
     * 该方法只调用一次
     *
     * @return 创建traceId
     */
    public static String createTraceId() {
        // 创建的同时就设置到上下文中
        String traceId = getTraceId();
        ThreadTraceIdUtil.setTraceId(traceId);
        return traceId;
    }

    /**
     * 生成traceId
     *
     * @return traceId
     */
    private static String getTraceId() {
        //使用uuid作为链路追踪id
        return UUID.randomUUID().toString().replace("-","");
    }

    /**
     * TraceId默认第一个为空，如果没值则分配一个
     *
     * @param traceId traceId
     * @return 校验traceId是否存在
     */
    public static String validateTraceId(String traceId) {
        if (null == traceId) {
            traceId = createTraceId();
            if (log.isDebugEnabled()) {
                log.debug("[TraceInterceptor]首次请求未分配TraceId,生成首次TraceId={}", traceId);
            }
        }
        return traceId;
    }
}
