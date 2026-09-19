package com.tca.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order 
{
	@Id
	private Long oid;
	
	private LocalDate orderDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status", columnDefinition = "ENUM('CANCELLED','ORDERED','RECEIVED','REFUNDED', 'PROCESSED')")
	private OrderStatus status;
	
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, 
			fetch=FetchType.EAGER)
	@JoinColumn(name="cust_id")
	private Customer customer;
	
}
