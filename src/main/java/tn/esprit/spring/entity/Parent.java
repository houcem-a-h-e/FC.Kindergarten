package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
public class Parent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id ;
	private String  firstName;
	private  String lastName ;
	private String phonenumber ;
	private String email ;
	@JsonIgnore
	private String password ;
	@Enumerated(EnumType.STRING)
	private parentType patype;
	@Temporal(TemporalType.DATE)
	private Date datenais ;
	private final String role="Parent";
	@ManyToMany
	@JsonIgnore
	private List<Kindergarten> kindergarten;
	@ManyToMany(mappedBy="parent",cascade=CascadeType.PERSIST)
	@JsonIgnore
	Set<Child> child;
	
	@OneToMany(mappedBy="parent")
	@JsonIgnore
	List<TimesheetDelegate> delegates;
	
	
	public String getRole() {
		return role;
	}

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

	public List<Kindergarten> getKindergarten() {
		return kindergarten;
	}

	public void setKindergarten(List<Kindergarten> kindergarten) {
		this.kindergarten = kindergarten;
	}
	





	public Parent(long id, String firstName, String lastName, String phonenumber, String email, String password,
			parentType patype, Date datenais, List<Kindergarten> kindergarten, Set<Child> child) {
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

	public Set<Child> getChild() {
		return child;
	}

	public void setChild(Set<Child> child) {
		this.child = child;
	}

	
	
	

}
