package com.tca.config;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MyApplicationSecurity 
{
	@Autowired
	private DataSource datasource;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		http.authorizeHttpRequests(authorize -> authorize
				.requestMatchers(HttpMethod.GET, "/{id}","/books").authenticated()
				.requestMatchers(HttpMethod.DELETE,"/{id}").hasAnyRole("ADMIN")
				.requestMatchers("/create").hasAnyRole("MANAGER")
			)
		.formLogin(Customizer.withDefaults());	// Authentication will be happen through Login Page(Web Page)
		
		http.csrf(csrf->csrf.disable()); // Cross-Site Request Forgery
		

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
}
