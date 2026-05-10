package com.Ecommerce.EcommerceApplication.controller;

import com.Ecommerce.EcommerceApplication.dto.request.LoginRequest;
import com.Ecommerce.EcommerceApplication.dto.response.AuthResponse;
import com.Ecommerce.EcommerceApplication.dto.response.SuccessResponse;
import com.Ecommerce.EcommerceApplication.entity.User;
import com.Ecommerce.EcommerceApplication.repository.UserRepository;
import com.Ecommerce.EcommerceApplication.utils.EcommerceJwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private EcommerceJwtUtil jwtUtil;
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@PostMapping("/register")
	public String register(@RequestBody User user) {
		
		user.setPassword(encoder.encode(user.getPassword()));
		
		repository.save(user);
		
		return "User Registered Successfully";
	}

	@PostMapping("/login")
	public SuccessResponse login(@RequestBody LoginRequest request) {
		
		Authentication auths = authManager.
						authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		if (auths.isAuthenticated()) {
			String token = jwtUtil.generateToken(request.getEmail());
			SuccessResponse response = new SuccessResponse();
			response.setError(false);
			response.setResponse(token);
			return response;
		}
		
		SuccessResponse response = new SuccessResponse();
		response.setError(true);
		response.setResponse("Unauthorized user");
		return response;
	}
}