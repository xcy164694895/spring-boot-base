package cn.weeego.test;

import java.net.MalformedURLException;

import com.caucho.hessian.client.HessianProxyFactory;

public class Testhession {
	public static void main(String[] args) {
		HessianProxyFactory factory = new HessianProxyFactory();
		HelloService api;
		try {
			api = (HelloService) factory.create(HelloService.class,
					"http://zuaa:aaaaaaaa@127.0.0.1:8080/HelloService");
			System.out.println(api.sayHello());
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}

	}
}
