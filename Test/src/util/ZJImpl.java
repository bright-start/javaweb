package util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ZJImpl implements ZJ{
	
	private ZJENUM impl;
	
	public ZJImpl(String impl) {
		super();
		if("SYSOUT".equals(impl)) {
			this.impl = ZJENUM.SYSOUT;
			sysout();
		}
	}
	
	public ZJImpl(String impl,Object object) {
		super();
		if("PROXY".equals(impl)) {
			this.impl = ZJENUM.PROXY; 
			proxy(object);
		}
	}
	

	@Override
	public void proxy(Object object) {
		Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("======begin========");
				Object obj = method.invoke(object, args);
				System.out.println("=======end=======");
				return obj;
				
			}
		});
	}

	@Override
	public void sysout() {
		System.out.println("----×¢½âÊµÏÖ------");
	}
}
