package com.tca.util;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import com.tca.exceptions.TokenExpiredException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil 
{
	private static final String SECRET_KEY = "bZDVtqVuNPCT1gCIh5c/f404cE0ydFxAhyWLToDR29k=";
	
	private static final long EXPIRATION_TIME = 60000;	// 1-min in milliseconds
	
	private final SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
	
	public String generateToken(String username)
	{
		return Jwts.builder()
				.subject(username)
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
				.signWith(key, Jwts.SIG.HS256)
				.compact();
	}
	
	public boolean validateToken(String token)
	{
		try
		{
			Jwts.parser()
				.verifyWith(key)
				.build()
				.parseSignedClaims(token);
			
			return true;
		}
		catch(Exception e)
		{
			throw new TokenExpiredException("JWT Token expired");
		}
	}
	
	
	public String extractUsername(String token)
	{
		try
		{
			Claims claims = Jwts.parser()
					.verifyWith(key)
					.build()
					.parseSignedClaims(token)
					.getPayload();
			return claims.getSubject();
		}
		catch(Exception e)
		{
			throw new TokenExpiredException("JWT Token expired");
		}
	}

}
