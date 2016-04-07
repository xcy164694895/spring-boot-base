package cn.weeego.test;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;
//@Configuration//配置控制  
//@EnableAutoConfiguration//启用自动配置  
//@ComponentScan//组件扫描  
@Configuration
@ComponentScan
@EnableAutoConfiguration
//@SpringBootApplication
public class Example {
	 @Autowired
	    private HelloService helloService;
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Example.class, args);

		System.out.println("Let's inspect the beans provided by Spring Boot:");

		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}

	@Bean(name = "/HelloService")
	public HessianServiceExporter accountService() {
		HessianServiceExporter exporter = new HessianServiceExporter();
		exporter.setService(helloService);
		exporter.setServiceInterface(HelloService.class);
		return exporter;
	}

}