package com.collect.api.dao;

import com.collect.api.bean.AccessIp;
import com.collect.common.BaseDao;

public interface AccessIpDao extends BaseDao<AccessIp> {
	
	String selectByIp(String ip);
	
}
