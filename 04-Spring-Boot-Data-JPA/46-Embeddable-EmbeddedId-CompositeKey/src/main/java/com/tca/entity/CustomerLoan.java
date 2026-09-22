package com.tca.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerLoan 
{
	@EmbeddedId
	private CustomerLoanId id;
	
	private Long loanAmount;
	
	private Integer periodOfMonths;
}
