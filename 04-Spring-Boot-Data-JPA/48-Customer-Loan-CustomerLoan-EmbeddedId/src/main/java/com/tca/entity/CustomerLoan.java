package com.tca.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
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
	
	@ManyToOne(cascade = {
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REFRESH,
			CascadeType.DETACH
	})
	@JoinColumn(name="cust_id")
	@MapsId("customerId")
	Customer customer;
	
	@ManyToOne(cascade = {
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REFRESH,
			CascadeType.DETACH
	})
	@JoinColumn(name="loan_id")
	@MapsId("loanId")
	Loan loan;
}
