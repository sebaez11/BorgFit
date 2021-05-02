package com.oauth.server.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.commons.users.service.entities.Customer;

@FeignClient(name = "users-service")
public interface CustomerFeignClient {
	
	@GetMapping("/customers/{email}")
	public Customer findByEmail(@PathVariable String email);
	
}
