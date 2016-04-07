package cn.weeego.test;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class MyRestController {
	@RequestMapping(value = "/{user}", method = RequestMethod.GET)
	@ResponseBody
	public String getUser(@PathVariable Long user) {
		
		return "zuaa"; 
	} 
}
