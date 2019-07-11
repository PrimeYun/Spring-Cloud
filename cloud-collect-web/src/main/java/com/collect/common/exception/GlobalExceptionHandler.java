package com.collect.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.collect.common.base.Result;

@RestControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(BindException.class)
	public Object handleBindException(BindException e) {
		StringBuilder sb = new StringBuilder();
		for (ObjectError err : e.getAllErrors()) {
			sb.append(err.getDefaultMessage()).append("<br>");
		}
		return Result.failure(sb.toString());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		StringBuilder sb = new StringBuilder();
		for (ObjectError err : e.getBindingResult().getAllErrors()) {
			sb.append(err.getDefaultMessage()).append("<br>");
		}
		return Result.failure(sb.toString());
	}

	@ExceptionHandler(Exception.class)
	public Object handleException(Exception e) {
		if (e instanceof NullPointerException) {
			return Result.failure("数据异常，请联系管理员");
		}
		log.error(e.getMessage(), e);
		return Result.error(e.getMessage());
	}

}
