package com.Ecommerce.EcommerceApplication.utils;

import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

@Component
public class EcommerceJwtUtil {

	private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	private final long EXPIRATION = 1000 * 60 * 60 *24; // 1 day

	public String generateToken(String username) {
		return Jwts.builder()
						.setSubject(username)
						.setIssuedAt(new Date())
						.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
						.signWith(key)
						.compact();
	}

	public String extractUsername(String token) {
		return getClaims(token).getSubject();
	}

	public boolean validateToken(String token) {
		try {
			getClaims(token);
			return true;
		} catch (JwtException e) {
			return false;
		}
	}
	
	public String extractEmail(String token) {
		
		return Jwts.parserBuilder()
						.setSigningKey(key)
						.build()
						.parseClaimsJws(token)
						.getBody()
						.getSubject();
	}

	private Claims getClaims(String token) {
		return Jwts.parserBuilder()
						.setSigningKey(key)
						.build()
						.parseClaimsJws(token)
						.getBody();
	}

}
