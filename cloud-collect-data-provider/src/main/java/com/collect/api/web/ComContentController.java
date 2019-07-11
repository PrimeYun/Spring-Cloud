package com.collect.api.web;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.collect.api.bean.ComContent;
import com.collect.api.dao.ComContentDao;
import com.collect.common.BaseController;

@RestController
@RequestMapping("comcontent")
public class ComContentController extends BaseController<ComContentDao, ComContent> {
	
	@GetMapping("list")
	public Map<String, Object> contentList(@RequestParam Map<String, Object> params) {
		return this.selectPage(params);
	}
	
	@PostMapping("insert")
	@Transactional(readOnly = false)
	public Integer insert(@RequestBody ComContent entity) {
		return dao.insert(entity);
	}
	
	@PostMapping("update")
	@Transactional(readOnly = false)
	public void update(@RequestBody ComContent entity) {
		dao.update(entity);
	}
	
	@GetMapping("export-list")
	public List<ComContent> exportList(@RequestParam Map<String, Object> params) {
		return this.selectList(params);
	}
	
}
