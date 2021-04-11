package tn.esprit.spring.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Reclamation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="Subject")
	private String subject;
	@Enumerated(EnumType.STRING)
	@Column(name="Complain")
	ToComplain toComplain;
	@Enumerated(EnumType.ORDINAL)
	@Column(name="Ranking")
	Rankings ranking;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date date;
	@Column(name="Description")
	private String description;
	
	@Column(name="Ansewer")
	private String answer;
	
	private int NbRec;
	
	@ManyToOne
	@JsonIgnore
	Parent parents;
	@ManyToOne
	@JsonIgnore
	Administrator admin;
	@ManyToOne
	@JsonIgnore
	Kindergarten Kindergarten;

	public Reclamation(Long id, String subject, ToComplain toComplain, Rankings ranking, Date date, String description,
			String answer, int nbRec, Parent parents, Administrator admin,
			tn.esprit.spring.entity.Kindergarten kindergarten) {
		super();
		this.id = id;
		this.subject = subject;
		this.toComplain = toComplain;
		this.ranking = ranking;
		this.date = date;
		this.description = description;
		this.answer = answer;
		NbRec = nbRec;
		this.parents = parents;
		this.admin = admin;
		Kindergarten = kindergarten;
	}
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
	public int getNbRec() {
		return NbRec;
	}
	public void setNbRec(int nbRec) {
		NbRec = nbRec;
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
	public Administrator getAdmin() {
		return admin;
	}
	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}

	public Kindergarten getKindergarten() {
		return Kindergarten;
	}
	public void setKindergarten(Kindergarten kindergarten) {
		this.Kindergarten = kindergarten;
	}
}
