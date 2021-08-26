package com.payments.restapi.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "users-service")
public interface UserFeignClient {

	@GetMapping("/users/{id}")
	public boolean existsById(@PathVariable String id);
	
}
