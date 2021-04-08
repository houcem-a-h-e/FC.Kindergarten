package com.esprit.tn.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Parent implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id ;
	private String  firstName;
	private  String lastName ;
	private String phonenumber ;
	private String email ;
	private String password ;
	private parentType patype;
	@Temporal(TemporalType.DATE)
	private Date datenais ;

}
