package javaweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("过滤器销毁！");
	}

	@Override
	public void doFilter(ServletRequest paramServletRequest,
			ServletResponse paramServletResponse, FilterChain paramFilterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("过滤器拦截。。。");
		paramFilterChain.doFilter(paramServletRequest, paramServletResponse);
		System.out.println("回来执行doFilter方法。。。");
	}

	@Override
	public void init(FilterConfig paramFilterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("过滤器初始化！");
	}

}
