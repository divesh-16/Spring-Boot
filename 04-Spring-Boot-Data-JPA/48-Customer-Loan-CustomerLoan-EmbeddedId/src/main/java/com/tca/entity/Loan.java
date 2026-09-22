package com.tca.entity;

import java.util.List;

import com.tca.constants.LoanType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Loan 
{
	@Id
	private Long loanId;
	
	@Enumerated(EnumType.STRING)
	private LoanType loanType;
	
	private Double interestRate;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "loan")
	List<CustomerLoan> customerLoans;
 	
}
