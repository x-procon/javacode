package cc.procon.service;

import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.annotation.Query;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author YangHui
 * *
 * @version v1.0
 * *
 * @since 2022/3/28 14:54
 * *
 *  com.htf.api.client
 * *
 */

@Component
public interface SMMClientService {
    @Post(url = "https://platform.smm.cn/usercenter/auth", timeout = 50000)
    Map auth(@Query("user_name") String userName, @Query("password") String password, @Query("source") String source);

    @Get(url = "https://datapro-api.smm.cn/v4/user/quota/quota_list", timeout = 50000)
    Map quotaList(@Query("page") Integer page, @Query("page_size") Integer pageSize, @Query("token") String token);

    @Post(url = "https://datapro-api.smm.cn/v4/user/quota/quota_data", timeout = 50000)
    Map quotaData(@Query("quota_ids") String quotaIds, @Query("start_date") String startDate, @Query("end_date") String endDate, @Query("token") String token);
    /**
     * 获取最新数据
     * @param quotaIds 请求的指标id(多个逗号分割，数量<100)
     * @param requestSource 固定：API
     * @param lastTime 上次更新时间戳（秒）案例：1661475169（最小值为当前日期倒推一个月,例如当前日期2022-08-2610:00:00，则最小允许2022-07-26 10:00:00）
     * @param token 来自获取token接口
     * @return 最新指标数据
     */
    @Post(url = "https://datapro-api.smm.cn/api/data/query_latest", timeout = 50000)
    Map queryLatest(@Query("quota_ids") String quotaIds, @Query("request_source") String requestSource, @Query("last_time") String lastTime, @Query("token") String token);
}
