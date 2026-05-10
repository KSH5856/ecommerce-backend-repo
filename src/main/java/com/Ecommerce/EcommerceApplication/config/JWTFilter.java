package com.Ecommerce.EcommerceApplication.config;

import com.Ecommerce.EcommerceApplication.service.CustomUserDetailsService;
import com.Ecommerce.EcommerceApplication.utils.EcommerceJwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JWTFilter extends OncePerRequestFilter {
	
	private final EcommerceJwtUtil jwtUtil;
	private final CustomUserDetailsService service;
	
	public JWTFilter(EcommerceJwtUtil jwtUtil,
									 CustomUserDetailsService service) {
		
		this.jwtUtil = jwtUtil;
		this.service = service;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request,
																	HttpServletResponse response,
																	FilterChain filterChain)
					throws ServletException, IOException {
		
		String authHeader = request.getHeader("Authorization");
		
		String token = null;
		String email = null;
		
		if (authHeader != null &&
						authHeader.startsWith("Bearer ")) {
			
			token = authHeader.substring(7);
			email = jwtUtil.extractEmail(token);
		}
		
		if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			
			var userDetails =
							service.loadUserByUsername(email);
			
			if (jwtUtil.validateToken(token)) {
				
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
								userDetails,
								null,
								userDetails.getAuthorities()
				);
				
				authToken.setDetails(
								new WebAuthenticationDetailsSource()
												.buildDetails(request)
				);
				
				SecurityContextHolder.getContext()
								.setAuthentication(authToken);
			}
		}
		
		filterChain.doFilter(request, response);
	}
	
}
