package com.collect.api.web;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.collect.api.bean.CollectSort;
import com.collect.api.dao.CollectSortDao;
import com.collect.common.BaseController;

@RestController
@RequestMapping("/collectsort")
public class CollectSortController extends BaseController<CollectSortDao, CollectSort> {
	
	@GetMapping("list")
	public List<CollectSort> sortList(@RequestParam Map<String, Object> params) {
		return dao.selectList(params);
	}
	
}
