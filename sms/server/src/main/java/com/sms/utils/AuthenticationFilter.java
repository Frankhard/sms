package com.sms.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sms.model.UserInfo;
import com.sms.service.ServiceFactory;

/**
 * 身份验证过滤器，只有登录用户才可以访问。
 * 注意，这里拦截所有请求，要设置排除静态资源
 * @author hp
 *
 */
@WebFilter(filterName="authFilter", urlPatterns={ "/*"})
public class AuthenticationFilter implements Filter  {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("gb2312");
		response.setCharacterEncoding("gb2312");
		
		String currentPath = ((HttpServletRequest)request).getRequestURI();
		System.out.println("current path:"+currentPath);
		
		// 排除所有静态资源
		if (currentPath.endsWith("/resources/")) {
			chain.doFilter(request, response);
			return;
        }
		
		// 排除登录请求
		if (currentPath.endsWith("/stu") || currentPath.endsWith("/stu/login") ) {
			chain.doFilter(request, response);
			return;
        }
		
		HttpSession session=((HttpServletRequest)request).getSession();
		UserInfo user = (UserInfo)session.getAttribute("user");
		
		if(user==null){
			((HttpServletResponse)response).sendRedirect("/login");
		}
		else{
			ServiceFactory.loginUsername = user.getNo();
			chain.doFilter(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
