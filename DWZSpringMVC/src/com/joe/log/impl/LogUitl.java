package com.joe.log.impl;

import javax.servlet.http.HttpServletRequest;

import com.joe.SecurityConstants;
import com.joe.log.LogMessageObject;

/** 
 * 将request放入ThreadLocal用于LOG_ARGUMENTS注入。	
 */

public abstract class LogUitl {
	// 用于存储每个线程的request请求
	private static final ThreadLocal<HttpServletRequest> LOCAL_REQUEST = new ThreadLocal<HttpServletRequest>();
	
	public static void putRequest(HttpServletRequest request) {
		LOCAL_REQUEST.set(request);
	}
	
	public static HttpServletRequest getRequest() {
		return LOCAL_REQUEST.get();
	}
	
	public static void removeRequest() {
		LOCAL_REQUEST.remove();
	}
	
	/**
	 * 将LogMessageObject放入LOG_ARGUMENTS。
	 * 描述
	 * @param logMessageObject
	 */
	public static void putArgs(LogMessageObject logMessageObject) {
		HttpServletRequest request = getRequest();
		request.setAttribute(SecurityConstants.LOG_ARGUMENTS, logMessageObject);
	}
	
	/**
	 * 得到LogMessageObject。
	 * 描述
	 * @param logMessageObject
	 */
	public static LogMessageObject getArgs() {
		HttpServletRequest request = getRequest();
		return (LogMessageObject)request.getAttribute(SecurityConstants.LOG_ARGUMENTS);
	}
}
