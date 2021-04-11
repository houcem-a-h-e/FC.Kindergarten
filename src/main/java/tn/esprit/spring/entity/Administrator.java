package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Administrator implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2494829598043675360L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id ;
	private String email ;
	private String password ;
	
	@OneToMany(mappedBy="administrator")
	@JsonIgnore
	Set<Kindergarten> Kindergarten;

	@OneToMany(cascade= CascadeType.ALL,mappedBy="admin")
	@JsonIgnore
	private Set<Reclamation> reclamations;

	public Administrator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrator(long id, String email, String password, Set<tn.esprit.spring.entity.Kindergarten> kindergarten,
			Set<Reclamation> reclamations) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		Kindergarten = kindergarten;
		this.reclamations = reclamations;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Set<Kindergarten> getKindergarten() {
		return Kindergarten;
	}

	public void setKindergarten(Set<Kindergarten> kindergarten) {
		Kindergarten = kindergarten;
	}

	public Set<Reclamation> getReclamations() {
		return reclamations;
	}

	public void setReclamations(Set<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}


	
	

}
