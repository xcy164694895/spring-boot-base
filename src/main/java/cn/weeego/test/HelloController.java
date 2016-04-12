package cn.weeego.test;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private StringRedisTemplate redis;
	@Autowired
	private RedisTemplate redisTemplate;

	@RequestMapping("/")
	public String index() {

		List<Map<String, Object>> rows = jdbcTemplate
				.queryForList("select * from pm_product limit 10");
		String re = "";
		for (Map item : rows) {
			re = re + ("====================================:" + item);
			ValueOperations<String, Map> valueopsitem = redisTemplate
					.opsForValue();
			valueopsitem.set(""+item.get("id"),item);
		}

		// re = re
		// +
		// ("\n\t=================|||||||||||"+mongoTemplate+"|| ||||||======================\n\t");
		//
		re = re + "\n\t";

		re = re + mongoTemplate;

		TestDomain _TestDomain = new TestDomain();
		_TestDomain.setName("zuaaa");
		mongoTemplate.insert(_TestDomain); 
		ValueOperations<String, TestDomain> valueops = redisTemplate
				.opsForValue();
		valueops.set(_TestDomain.getName(), _TestDomain); 
		ValueOperations<String, TestDomain> readvalueops = redisTemplate.opsForValue();
		TestDomain __TestDomain = readvalueops.get(_TestDomain.getName());
		re=re+"-----------"+__TestDomain.getName()+"-----------"+__TestDomain.getPsw();
		return re;
	}
}
