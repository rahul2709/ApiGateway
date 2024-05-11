package com.example.demo;

import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import reactor.core.publisher.Mono;

@RestController
@EnableHystrix
public class FallbackController {
	
	@RequestMapping("/orderFallback")
	@HystrixCommand(fallbackMethod = "orderServiceFallback")
	public Mono<String> orderServiceFallback(){
		return Mono.just("Order Service is taking too long to responsd");
		
	}
	@RequestMapping("/paymentFallback")
	@HystrixCommand(fallbackMethod = "paymentServiceFallback")
	public Mono<String> paymentServiceFallback(){
		return Mono.just("Payment Service is taking too long to responsd");
		
	}
}
