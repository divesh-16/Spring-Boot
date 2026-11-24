package com.tca.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MyApplicationSecurity 
{
	
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
		UserDetails admin = User.builder()
				.username("divesh")
				.password(getEncoder().encode("div@123"))
				.roles("ADMIN")
				.build();
				
		UserDetails manager = User.builder()
				.username("book")
				.password(getEncoder().encode("book@123"))
				.roles("MANAGER")
				.build();
		
		return new InMemoryUserDetailsManager(manager,admin);
	}
	
	
	@Bean
	public PasswordEncoder getEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
