package com.tca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tca.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {

}
