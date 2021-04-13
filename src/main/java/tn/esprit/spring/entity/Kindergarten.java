package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;



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
	private String phonenumber;
	private String email;
	@JsonIgnore
	private String password;
    private boolean Confirmation=false;
	@Temporal(TemporalType.DATE)
	private Date datenaiss;
	
	private HashMap<String, Integer> forvote;
	private String delegate=null;
	
	private   final String role="Kindergarten";
	
	@OneToMany(mappedBy="kindergarten")
	@JsonIgnore
	List<TimesheetDelegate> delegates;
	@ManyToOne
	private Administrator administrator;
	@OneToMany(mappedBy="kindergarten")
	@JsonIgnore
	Set<Bus_reservation> bus_reservations;
	@ManyToMany(mappedBy="kindergarten",cascade = CascadeType.ALL)
	@JsonIgnore
	private  List<Parent> parents ;
	@OneToMany(cascade= CascadeType.ALL,mappedBy="Kindergarten")
	@JsonIgnore
	private Set<Reclamation> reclamation;
	

	@JsonIgnore
	@Transient 
	@OneToMany(cascade = CascadeType.ALL, mappedBy="kinderGarten",fetch=FetchType.LAZY)
	private Collection<Event> events = new ArrayList<>();

	public HashMap<String, Integer> getVote() {
		return forvote;
	}

	public void setVote(HashMap<String, Integer> vote) {
		this.forvote = vote;
	}

	public List<TimesheetDelegate> getDelegates() {
		return delegates;
	}

	public void setDelegates(List<TimesheetDelegate> delegates) {
		this.delegates = delegates;
	}

	public String getRole() {
		return role;
	}

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

	public List<Parent> getParents() {
		return parents;
	}

	public void setParents(List<Parent> parents) {
		this.parents = parents;
	}

	public String getDelegate() {
		return delegate;
	}

	public void setDelegate(String delegate) {
		this.delegate = delegate;
	}



	



	

	public HashMap<String, Integer> getForvote() {
		return forvote;
	}

	public void setForvote(HashMap<String, Integer> forvote) {
		this.forvote = forvote;
	}

	public Set<Reclamation> getReclamation() {
		return reclamation;
	}

	public void setReclamation(Set<Reclamation> reclamation) {
		this.reclamation = reclamation;
	}

	

	public Kindergarten(long id, String name, String phonenumber, String email, String password, boolean confirmation,
			Date datenaiss, HashMap<String, Integer> forvote, String delegate, List<TimesheetDelegate> delegates,
			Administrator administrator, Set<Bus_reservation> bus_reservations, List<Parent> parents,
			Set<Reclamation> reclamation, Collection<Event> events) {
		super();
		this.id = id;
		Name = name;
		this.phonenumber = phonenumber;
		this.email = email;
		this.password = password;
		Confirmation = confirmation;
		this.datenaiss = datenaiss;
		this.forvote = forvote;
		this.delegate = delegate;
		this.delegates = delegates;
		this.administrator = administrator;
		this.bus_reservations = bus_reservations;
		this.parents = parents;
		this.reclamation = reclamation;
		this.events = events;
	}

	
	public Collection<Event> getEvents() {
		return events;
	}

	public void setEvents(Collection<Event> events) {
		this.events = events;
	}

	public Kindergarten() {
		super();
		// TODO Auto-generated constructor stub
	}






	
	
	

}
