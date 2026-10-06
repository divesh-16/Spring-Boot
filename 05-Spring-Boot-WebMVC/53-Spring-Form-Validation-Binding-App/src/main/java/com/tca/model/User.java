package com.tca.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User 
{
	@NotBlank(message="User name is blank")
	@Size(min=6, max=15, message="Username length should be between 6 to 15")
	private String username;
	
	@NotBlank(message="Email is blank")
	@Email(message="Email is invalid")
	private String email;
	
	@NotBlank(message="Mobile is blank")
	@Pattern(regexp="\\d{10}", message="Mobile should be of 10 digits")
	private String mobile;
	
	@NotEmpty(message="Gender is empty")
	private String gender;
}
