package tn.esprit.spring.entity;
import java.io.Serializable;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Reclamation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String subject;
	@Enumerated(EnumType.STRING)
	ToComplain toComplain;
	@Enumerated(EnumType.ORDINAL)
	Rankings ranking;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date date;
	private String description;
	
	private String answer;
	
	@ManyToOne
	@JsonBackReference
	Parent parents;
	@ManyToOne
	@JsonBackReference
	Adminstrator admin;
	@ManyToOne
	@JsonBackReference
	Kindergarten Kindergarten;

	public Reclamation(){
		
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public ToComplain getToComplain() {
		return toComplain;
	}
	public void setToComplain(ToComplain toComplain) {
		this.toComplain = toComplain;
	}
	public Reclamation(Long id, String subject, ToComplain toComplain, Rankings ranking, Date date,
			String description) {
		super();
		this.id = id;
		this.subject = subject;
		this.toComplain = toComplain;
		this.ranking = ranking;
		this.date = date;
		this.description = description;
	}
	public Rankings getRanking() {
		return ranking;
	}
	public void setRanking(Rankings ranking) {
		this.ranking = ranking;
	}
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		
		this.answer = answer;
		
	}
	public Parent getParents() {
		return parents;
	}
	public void setParents(Parent parents) {
		this.parents = parents;
	}
	public Adminstrator getAdmin() {
		return admin;
	}
	public void setAdmin(Adminstrator admin) {
		this.admin = admin;
	}

	public Kindergarten getKindergarten() {
		return Kindergarten;
	}
	public void setKindergarten(Kindergarten kindergarten) {
		this.Kindergarten = kindergarten;
	}
}
