package com.collect.api.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collect.api.bean.CollectSort;
import com.collect.api.bean.ComContent;
import com.collect.api.feign.DataProvider;
import com.google.common.collect.Maps;

@Service
public class IndexService {
	
	@Autowired
	private DataProvider dataProvider;
	
	public Map<String, Object> selectList(Map<String, Object> params) {
		return dataProvider.contentList(params);
	}
	
	public List<CollectSort> getSort(Map<String, Object> params) {
		return null;
	}
	
	public Map<String, Object> other() {
		Map<String, Object> result = Maps.newHashMap();
		result.put("accessNum", dataProvider.getValue("accessNum"));
		result.put("views", dataProvider.increase("views"));
		return result;
	}
	
	public List<ComContent> exportList(Map<String, Object> params) {
		return dataProvider.exportList(params);
	}
	
}
