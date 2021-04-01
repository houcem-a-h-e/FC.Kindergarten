package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Parent implements Serializable {
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
	@ManyToOne
	private Kindergarten kindergarten;
	@OneToMany(mappedBy="parent")
	List<Child> child;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public parentType getPatype() {
		return patype;
	}

	public void setPatype(parentType patype) {
		this.patype = patype;
	}

	public Date getDatenais() {
		return datenais;
	}

	public void setDatenais(Date datenais) {
		this.datenais = datenais;
	}

	public Kindergarten getKindergarten() {
		return kindergarten;
	}

	public void setKindergarten(Kindergarten kindergarten) {
		this.kindergarten = kindergarten;
	}

	public Parent(long id, String firstName, String lastName, String phonenumber, String email, String password,
			parentType patype, Date datenais, Kindergarten kindergarten, List<Child> child) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phonenumber = phonenumber;
		this.email = email;
		this.password = password;
		this.patype = patype;
		this.datenais = datenais;
		this.kindergarten = kindergarten;
		this.child = child;
	}

	public Parent() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	

}
