package cn.weeego.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@IntegrationTest
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Example.class, TestConfig.class })
public class ApplicationTest {
	@Autowired
	private HelloService helloClient;

	@Test
	public void shouldSayHello() {

		// when
		String message= helloClient.sayHello();

		System.out.println(message);
	}

}
