package com.collect.common.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.collect.api.bean.AccessIp;
import com.collect.api.feign.DataProvider;
import com.collect.common.utils.DateUtils;
import com.collect.common.utils.HttpContextUtils;
import com.collect.common.utils.IPUtils;

import cn.hutool.core.util.ObjectUtil;

@Aspect
@Component
public class AccessAspect {
	
	private static final Logger log = LoggerFactory.getLogger(AccessAspect.class);
	
	@Autowired
	private DataProvider dataProvider;
	
	@Pointcut("@annotation(com.collect.common.annotation.Access)")
	public void pointcut() {
		
	}
	
	@Before("pointcut()")
	public void doBefore(JoinPoint joinPoint) {
		
		HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        // 获取IP地址
        String ip = IPUtils.getIpAddr(request);
        log.info("当前访问IP：" + ip);
        String time = DateUtils.getDate("yyyy-MM-dd HH:mm:ss");
        if (ObjectUtil.isNull(dataProvider.getIP(ip))) {
        	dataProvider.increase("accessNum");
        	AccessIp item = new AccessIp();
        	item.setIp(ip);
        	item.setCreateTime(time);
        	item.setUpdateTime(time);
        	dataProvider.insert(item);
        } else {
        	AccessIp item = new AccessIp();
        	item.setIp(ip);
        	item.setUpdateTime(time);
        	dataProvider.update(item);
        }
		
	}
	
}
