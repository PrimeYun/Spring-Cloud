package com.collect.api.feign.fallback;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.collect.api.bean.AccessIp;
import com.collect.api.bean.ComContent;
import com.collect.api.feign.DataProvider;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import feign.hystrix.FallbackFactory;

@Component
public class DataProviderFallback implements FallbackFactory<DataProvider> {
	
	private static final Logger log = LoggerFactory.getLogger(DataProviderFallback.class);
	
	@Override
	public DataProvider create(Throwable cause) {
		return new DataProvider() {

			@Override
			public Map<String, Object> contentList(Map<String, Object> params) {
				log.info(cause.getMessage());
				Map<String, Object> result = Maps.newHashMap();
				result.put("total", 0);
				result.put("list", Lists.newArrayList());
				return result;
			}

			@Override
			public String getIP(String ip) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Integer insert(AccessIp entity) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void update(AccessIp entity) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public Long increase(String key) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getValue(String key) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public List<ComContent> exportList(Map<String, Object> params) {
				// throw new RuntimeException("exprotList异常");
				// TODO Auto-generated method stub
				return null;
			}
			
		};
	}

}
