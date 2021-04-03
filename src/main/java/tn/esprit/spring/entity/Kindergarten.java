package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Set;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Kindergarten implements Serializable {
	/**
	 * 
	 */
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

	@ManyToOne
	private Administrator administrator;
	
	@OneToMany(mappedBy="kindergarten")
	Set<Bus_reservation> bus_reservations;
	
	@OneToMany(mappedBy="kindergarten",cascade=CascadeType.PERSIST)
	private  List<Parent> parents ;
	
	
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

	public boolean isConfirmation() {
		return Confirmation;
	}

	public void setConfirmation(boolean confirmation) {
		Confirmation = confirmation;
	}

	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	public Set<Bus_reservation> getBus_reservations() {
		return bus_reservations;
	}

	public void setBus_reservations(Set<Bus_reservation> bus_reservations) {
		this.bus_reservations = bus_reservations;
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

	public Date getDatenaiss() {
		return datenaiss;
	}

	public void setDatenaiss(Date datenaiss) {
		this.datenaiss = datenaiss;
	}

	public java.util.List<Parent> getParents() {
		return parents;
	}

	public void setParents(java.util.List<Parent> parents) {
		this.parents = parents;
	}

	public Kindergarten(long id, String name, String phonenumber, String email, String password, boolean confirmation,
			Date datenaiss, Administrator administrator, Set<Bus_reservation> bus_reservations,
			java.util.List<Parent> parents) {
		super();
		this.id = id;
		Name = name;
		this.phonenumber = phonenumber;
		this.email = email;
		this.password = password;
		Confirmation = confirmation;
		this.datenaiss = datenaiss;
		this.administrator = administrator;
		this.bus_reservations = bus_reservations;
		this.parents = parents;
	}

	public Kindergarten() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	
	

}
