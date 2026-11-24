package com.tca.filter;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.tca.util.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter 
{
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException 
	{
		
		
		try
		{
			String authorizationHeader = request.getHeader("Authorization");
			
			String username = null;
			String token =null;
			
			if(authorizationHeader != null && authorizationHeader.startsWith("Bearer"))
			{
				token = authorizationHeader.substring(7);
				username = jwtUtil.extractUsername(token);
			}
			
			if(username != null && SecurityContextHolder.getContext().getAuthentication() == null)
			{
				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				
				if(jwtUtil.validateToken(token))
				{
					SecurityContextHolder.getContext().setAuthentication(
							new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities()));
				}
			}
			
			chain.doFilter(request, response);
		}
		catch(Exception e)
		{
			PrintWriter out = response.getWriter();
			out.println("JWT Token expired"+e.getMessage());
			out.close();
		}
		
		
	}

}
