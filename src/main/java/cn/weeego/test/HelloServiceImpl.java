package cn.weeego.test;

import org.springframework.stereotype.Service;

@Service("helloService")
public class HelloServiceImpl implements HelloService {

	  @Override
	    public String sayHello(){
	        return "Hello World";
	    }

}
