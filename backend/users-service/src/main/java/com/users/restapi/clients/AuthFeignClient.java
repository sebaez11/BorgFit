package com.users.restapi.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.users.restapi.dto.UserLoginDto;


@FeignClient(name = "oauth-service")
public interface AuthFeignClient {
	
	@PostMapping("/oauth/token/")
	public String getJwtToken(@RequestBody UserLoginDto userDto);

}
