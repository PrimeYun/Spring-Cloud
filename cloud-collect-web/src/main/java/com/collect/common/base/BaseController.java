package com.collect.common.base;

public abstract class BaseController {
	
	protected Object success() {
		return Result.success();
	}
	
	protected Object success(Object data) {
		Result result = Result.success();
		result.setData(data);
		return result;
	}
	
	protected Object failure(String message) {
		return Result.failure(message);
	}

}
