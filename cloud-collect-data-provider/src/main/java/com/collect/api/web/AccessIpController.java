package com.collect.api.web;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collect.api.bean.AccessIp;
import com.collect.api.dao.AccessIpDao;
import com.collect.common.BaseController;

@RestController
@RequestMapping("/accessip")
public class AccessIpController extends BaseController<AccessIpDao, AccessIp> {
	
	@GetMapping("{ip}")
	public String getIP(@PathVariable("ip") String ip) {
		return dao.selectByIp(ip);
	}
	
	@PostMapping("insert")
	@Transactional(readOnly = false)
	public Integer insert(@RequestBody AccessIp entity) {
		return dao.insert(entity);
	}
	
	@PostMapping("update")
	@Transactional(readOnly = false)
	public void update(@RequestBody AccessIp entity) {
		dao.update(entity);
	}
}
