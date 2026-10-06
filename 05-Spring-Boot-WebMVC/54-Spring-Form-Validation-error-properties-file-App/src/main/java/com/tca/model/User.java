package com.tca.model;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
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
	@NotBlank
	@Size(min=6, max=15)
	private String username;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	@Pattern(regexp="\\d{10}")
	private String mobile;
	
	@NotEmpty
	private String gender;
	
	@Past
	@NotNull
	private LocalDate bdate;
}
