package com.spring.demo.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//turn on or off
	@Override
	public boolean shouldFilter() {
		
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		
		logger.info("request -> {} request uri {}", request, request.getRequestURI());
		
		return null;
	}
	
	//define what request would this filter executed
	@Override
	public String filterType() {
		
		return "pre";
	}

	@Override
	public int filterOrder() {
		
		return 1;
	}

}
