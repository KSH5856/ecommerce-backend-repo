package com.Ecommerce.EcommerceApplication.service;

import com.Ecommerce.EcommerceApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String email)
					throws UsernameNotFoundException {
		
		var user = repository.findByEmail(email).orElseThrow(() ->
										new UsernameNotFoundException("User not found"));
		
		return new User(
						user.getEmail(),
						user.getPassword(),
						List.of(new SimpleGrantedAuthority(user.getRole().name()))
		);
	}
}
