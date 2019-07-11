package com.collect.api.oss;

public class OSSFactory {
	
//	private static SysConfigService configService;
//	
//	static {
//		OSSFactory.configService = SpringContextHolder.getBean(SysConfigService.class);
//	}
//	
//	public static CloudStorageService buile() {
//		
//		CloudStorageConfig config = configService.getConfigObject("oss.config", CloudStorageConfig.class);
//		if (null != config) {
//			if (config.getType() == Constant.CloudService.LOCAL.getValue()) {
//				return new LocalCloudStorageService(config);
//			}
//			if (config.getType() == Constant.CloudService.ALIYUN.getValue()) {
//				return new AliCloudStorageService(config);
//			}
//		}
//		return null;
//	}
}
