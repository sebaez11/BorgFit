package com.oauth.server.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.commons.entities.service.entities.User;


@FeignClient(name = "users-service")
public interface CustomerFeignClient {
	
	@GetMapping("/customers/{email}")
	public User findByEmail(@PathVariable String email);
	
}
