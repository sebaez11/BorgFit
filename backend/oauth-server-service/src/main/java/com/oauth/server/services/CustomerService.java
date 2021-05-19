package com.oauth.server.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.oauth.server.clients.CustomerFeignClient;


@Service
public class CustomerService implements UserDetailsService {
	
	private Logger log = LoggerFactory.getLogger(CustomerService.class);
	
	@Autowired
	private CustomerFeignClient customerFeignClient;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		log.info("entró");
		
		com.commons.entities.service.entities.User user = customerFeignClient.findByEmail(email);
		
		if(user == null) {
			throw new UsernameNotFoundException("Credenciales inválidas. Intente de nuevo.");
		}
		
		log.info("Usuario encontrado");
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROL_CUSTOMER"));
		
		log.info("Usuario autenticado");
		
		return new User(user.getEmail() , user.getPassword() , user.isActive() , 
						true , true, true, authorities);
	}

}
