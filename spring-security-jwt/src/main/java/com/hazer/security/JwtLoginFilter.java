package com.hazer.security;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.hazer.utils.HttpUtils;
import com.hazer.utils.JwtTokenUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


/**
 * 启动登录认证流程过滤器
 * @author hazer
 * Created on 2021/1/21
 */
public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {
	private static final Logger log = LoggerFactory.getLogger(JwtLoginFilter.class);
	public JwtLoginFilter(AuthenticationManager authManager) {
        setAuthenticationManager(authManager);
    }
	
	@Override
	@SuppressWarnings("squid:S1185")
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// POST 请求 /login 登录时拦截， 由此方法触发执行登录认证流程，可以在此覆写整个登录认证逻辑
		super.doFilter(req, res, chain); 
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		// 可以在此覆写尝试进行登录认证的逻辑，登录成功之后等操作不再此方法内
		// 如果使用此过滤器来触发登录认证流程，注意登录请求数据格式的问题
		// 此过滤器的用户名密码默认从request.getParameter()获取，但是这种
		// 读取方式不能读取到如 application/json 等 post 请求数据，需要把
		// 用户名密码的读取逻辑修改为到流中读取request.getInputStream()

		String body = getBody(request);
		JSONObject jsonObject = JSON.parseObject(body);
		String username = jsonObject.getString("username");
		String password = jsonObject.getString("password");

		if (username == null) {
			username = "";
		}

		if (password == null) {
			password = "";
		}

		username = username.trim();

		JwtAuthenticatioToken authRequest = new JwtAuthenticatioToken(username, password);

		// Allow subclasses to set the "details" property
		setDetails(request, authRequest);

		return this.getAuthenticationManager().authenticate(authRequest);
	
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException {
		// 存储登录认证信息到上下文
		SecurityContextHolder.getContext().setAuthentication(authResult);
		// 记住我服务
		getRememberMeServices().loginSuccess(request, response, authResult);
		// 触发事件监听器
		if (this.eventPublisher != null) {
			eventPublisher.publishEvent(new InteractiveAuthenticationSuccessEvent(authResult, this.getClass()));
		}
		// 生成并返回token给客户端，后续访问携带此token
		JwtAuthenticatioToken token = new JwtAuthenticatioToken(null, null, JwtTokenUtils.generateToken(authResult));
		HttpUtils.write(response, token);
	}
	
	/**
	 * 获取请求Body
	 * @param request 请求
	 * @return 请求体
	 */
	public String getBody(HttpServletRequest request) {

		StringBuilder sb = new StringBuilder();
		try(InputStream inputStream = request.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			log.error(e.getMessage(),e);
		}return sb.toString();
	}
}
