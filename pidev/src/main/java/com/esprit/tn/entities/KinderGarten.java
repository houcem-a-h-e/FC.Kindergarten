package com.esprit.tn.entities;

import java.sql.Date;

//import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
@Table(name="KINDERGARTEN")
public class KinderGarten {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id ;
	private String  Name;
	private String phonenumber ;
	private String email ;
	private String password ;
    private boolean Confirmation=false;
	@Temporal(TemporalType.DATE)
	private Date datenaiss ;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isConfirmation() {
		return Confirmation;
	}
	public void setConfirmation(boolean confirmation) {
		Confirmation = confirmation;
	}
	public Date getDatenaiss() {
		return datenaiss;
	}
	public void setDatenaiss(Date datenaiss) {
		this.datenaiss = datenaiss;
	}
	public KinderGarten(long id, String name, String phonenumber, String email, String password, boolean confirmation,
			Date datenaiss) {
		super();
		this.id = id;
		Name = name;
		this.phonenumber = phonenumber;
		this.email = email;
		this.password = password;
		Confirmation = confirmation;
		this.datenaiss = datenaiss;
	}
	 
	

}
