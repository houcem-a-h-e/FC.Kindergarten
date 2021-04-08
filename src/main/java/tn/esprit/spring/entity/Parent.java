package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Parent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@OneToMany(cascade= CascadeType.ALL,mappedBy="parents")
	@JsonBackReference
	private Set<Reclamation> reclamation;
	
	@OneToMany(mappedBy="parent")
	@JsonBackReference
	private Set<Satisfaction> satisfaction;

	
	public Parent() {
		super();
	}


	public Parent(Long id, String name, Set<Reclamation> reclamation, Set<Satisfaction> satisfaction) {
		super();
		this.id = id;
		this.name = name;
		this.reclamation = reclamation;
		this.satisfaction = satisfaction;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Set<Reclamation> getReclamation() {
		return reclamation;
	}


	public void setReclamation(Set<Reclamation> reclamation) {
		this.reclamation = reclamation;
	}


	public Set<Satisfaction> getSatisfaction() {
		return satisfaction;
	}


	public void setSatisfaction(Set<Satisfaction> satisfaction) {
		this.satisfaction = satisfaction;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}