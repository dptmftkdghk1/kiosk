package com.example.kiosk.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member")
public class Member {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int membercode;
	@Column(nullable=false, length=15)
	private String Id;
	public int getMembercode() {
		return membercode;
	}
	public void setMembercode(int membercode) {
		this.membercode = membercode;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	@Column(nullable=false, length=30)
	private String email;
	@Column(nullable=false, length=5)
	private String name;
	@Column(nullable=false, length=23)
	private String password;
	@Column(nullable=false, length=8)
	private String phonenumber;

	
}
