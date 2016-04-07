package cn.weeego.test;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityMapper {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public String selectCityById(long id) {
		return "--";
	}

}
