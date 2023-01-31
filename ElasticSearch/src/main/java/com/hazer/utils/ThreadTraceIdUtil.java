package com.hazer.utils;

/**
 * 线程传递工具类
 *
 * @author procon
 * @since 2023-01-14
 */
public class ThreadTraceIdUtil {
    /**使用InheritableThreadLocal便于在主子线程间传递参数*/
    private static final ThreadLocal<String> TRACE_ID = new InheritableThreadLocal<>();
    /**
     * 从当前线程局部变量获取TraceId
     * 首次调用该方法会生成traceId，后续每次都从线程上下文获取
     * @return traceId
     */
    public static String getTraceId() {
        return TRACE_ID.get();
    }

    public static void setTraceId(String traceId) {
        TRACE_ID.set(traceId);
    }

    public static void removeTraceId() {
        TRACE_ID.remove();
    }
}
