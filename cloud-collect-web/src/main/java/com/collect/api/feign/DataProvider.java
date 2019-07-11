package com.collect.api.feign;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.collect.api.bean.AccessIp;
import com.collect.api.bean.ComContent;
import com.collect.api.feign.fallback.DataProviderFallback;
import com.collect.config.FeignLogConfig;

@FeignClient(name = "data-provider", fallbackFactory = DataProviderFallback.class, 
				configuration = FeignLogConfig.class)
public interface DataProvider {

	@GetMapping("/comcontent/list")
	public Map<String, Object> contentList(@RequestParam Map<String, Object> params);
	
	@GetMapping("/accessip/{ip}")
	public String getIP(@PathVariable("ip") String ip);
	
	@PostMapping("/accessip/insert")
	public Integer insert(@RequestBody AccessIp entity);
	
	@PostMapping("/accessip/update")
	public void update(@RequestBody AccessIp entity);
	
	@GetMapping("/redis/inc")
	public Long increase(@RequestParam String key);
	
	@RequestMapping(value = "/redis/{key}", method = RequestMethod.GET)
	public String getValue(@PathVariable("key") String key);
	
	@GetMapping("/comcontent/export-list")
	public List<ComContent> exportList(@RequestParam Map<String, Object> params);
}
