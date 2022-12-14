package com.hazer.utils;


import com.alibaba.fastjson2.JSON;
import com.hazer.vo.HttpResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * HTTP工具类
 * @author hazer
 * Created on 2021/1/21
 */
public class HttpUtils {

	private HttpUtils() {
	}

	/**
	 * 获取HttpServletRequest对象
	 * @return HttpServletRequest
	 */
	public static HttpServletRequest getHttpServletRequest() {
		if(RequestContextHolder.getRequestAttributes() != null){
			ServletRequestAttributes requestAttributes  = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			if(requestAttributes != null){
				return requestAttributes.getRequest();
			}
		}
		return null;

	}
	
	/**
	 * 输出信息到浏览器
	 * @param response 响应
	 * @param data 数据
	 * @throws IOException IOException
	 */
	public static void write(HttpServletResponse response, Object data) throws IOException {
		response.setContentType("application/json; charset=utf-8");
        HttpResult result = HttpResult.ok(data);
        String json = JSON.toJSONString(result);
        response.getWriter().print(json);
        response.getWriter().flush();
        response.getWriter().close();
	}
	
}
