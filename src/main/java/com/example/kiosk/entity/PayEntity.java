package com.example.kiosk.entity;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="pay")
public class PayEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="paycode", nullable=false)
	private Integer paycode;
	
	@Column(name="paydate", nullable=false)
	private Date paydate;
	
	@Column(name="paystatus")
	private Integer paystatus;
	
	@Column(name="paycontent", length = 20)
	private String paycontent;
}	
