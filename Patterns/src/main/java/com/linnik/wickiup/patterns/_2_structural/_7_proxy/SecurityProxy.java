package com.linnik.wickiup.patterns._2_structural._7_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author LinnykOleh
 */
public class SecurityProxy implements InvocationHandler{

	private Object obj;

	private SecurityProxy(Object obj) {
		this.obj = obj;
	}

	public static Object newInstance(Object obj){
		return java.lang.reflect.Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new SecurityProxy(obj));
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result;
		try{
			if(method.getName().contains("POST")){
				throw new IllegalAccessException("Post are currently not allowed");
			}else {
				result = method.invoke(obj, args);
			}
		}catch (Exception e){
			throw new RuntimeException("unexpected invocation exception");
		}
		return result;
	}
}
