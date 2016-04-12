package cn.weeego.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Example {
	@Autowired
	private HelloService helloService;

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Example.class, args);

	}

	@Bean(name = "/HelloService")
	public HessianServiceExporter accountService() {
		HessianServiceExporter exporter = new HessianServiceExporter();
		exporter.setService(helloService);
		exporter.setServiceInterface(HelloService.class);
		return exporter;
	}

}