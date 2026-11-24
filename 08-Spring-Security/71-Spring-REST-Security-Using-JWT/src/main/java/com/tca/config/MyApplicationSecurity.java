package com.tca.config;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.tca.filter.JwtFilter;

@Configuration
@EnableWebSecurity
public class MyApplicationSecurity 
{


	@Autowired
	private DataSource datasource;
	
	@Autowired
	JwtFilter jwtFilter;

	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		http.authorizeHttpRequests(authorize -> authorize
				.requestMatchers(HttpMethod.POST, "/login").permitAll()
				.requestMatchers(HttpMethod.GET, "/{id}","/books").hasAnyRole("ADMIN")
				.requestMatchers(HttpMethod.DELETE,"/{id}").hasAnyRole("ADMIN")
				.requestMatchers("/create").hasAnyRole("MANAGER")
			)
		.httpBasic(customizer->customizer.disable());	// Authentication will be happen through Login Page(Web Page)
		
		http.csrf(csrf->csrf.disable()); // Cross-Site Request Forgery
		
		http.sessionManagement(config -> config.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
	
	@Bean
	public UserDetailsService getUserDetails()
	{
		return new JdbcUserDetailsManager(datasource);
	}
	
	
	@Bean
	public PasswordEncoder getEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authManager(HttpSecurity http) throws Exception
	{
		AuthenticationManagerBuilder authenticationManagerBuilder = 
				http.getSharedObject(AuthenticationManagerBuilder.class);
		
		authenticationManagerBuilder.userDetailsService(getUserDetails()).passwordEncoder(getEncoder());
		
		return authenticationManagerBuilder.build();
		
	}
}
