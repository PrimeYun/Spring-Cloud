package com.collect.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {
	
	@Autowired
	private StringRedisTemplate template;
	
	@GetMapping("{key}")
	public String getValue(@PathVariable("key") String key) {
		return template.opsForValue().get(key);
	}
	
	@GetMapping("inc")
	public Long increase(@RequestParam String key) {
		return template.opsForValue().increment(key);
	}
	
}
