package com.consumer.remote;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import feign.hystrix.FallbackFactory;

@Component
public class HelloRemoteHystrix implements FallbackFactory<HelloRemote> {

	@Override
	public HelloRemote create(Throwable throwable) {
		return new HelloRemote() {
			@Override
			public String hello(@RequestParam String name) {
				// TODO Auto-generated method stub
				return "Hello  " + name + "  this is miss message";
			}
		};
	}

}
