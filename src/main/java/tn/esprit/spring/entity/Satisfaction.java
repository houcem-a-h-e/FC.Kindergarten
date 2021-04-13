package tn.esprit.spring.entity;

import java.io.Serializable;
//import java.util.Calendar;
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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Satisfaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date date;
	/*
	@Temporal(TemporalType.DATE)
	private Calendar date;

*/
	public Parent getParent() {
		return parent;
	}


	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="YourChild")
	Satisfactions satisfactionOfYourChild ;
	

	@Enumerated(EnumType.ORDINAL)
	@Column(name="Education")
	Satisfactions sysOfEducation;
	

	@Enumerated(EnumType.ORDINAL)
	@Column(name="Event")
	Satisfactions satisEvent;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="Offer")
	Satisfactions satisOffer;

	@Enumerated(EnumType.ORDINAL)
	@Column(name="TeamOfKindergarten")
	Satisfactions statisTeamsOfFc;
	

	@Enumerated(EnumType.ORDINAL)
	@Column(name="Ambiance")
	Satisfactions statisambiance;
	
	
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="Communication")
	Satisfactions statisCommunicationOnFc;
	

	@Enumerated(EnumType.ORDINAL)
	@Column(name="Note")
	Satisfactions noteFc;
	
	@ManyToOne
	@JsonBackReference
     private Parent parent;


	public Satisfaction() {
		super();
		// TODO Auto-generated constructor stub
	}





	public Satisfaction(int id, Date date, Satisfactions satisfactionOfYourChild, Satisfactions sysOfEducation,
			Satisfactions satisEvent, Satisfactions satisOffer, Satisfactions statisTeamsOfFc,
			Satisfactions statisambiance, Satisfactions statisCommunicationOnFc,
			Satisfactions noteFc, Parent parent) {
		super();
		this.id = id;
		this.date = date;
		this.satisfactionOfYourChild = satisfactionOfYourChild;
		this.sysOfEducation = sysOfEducation;
		this.satisEvent = satisEvent;
		this.satisOffer = satisOffer;
		this.statisTeamsOfFc = statisTeamsOfFc;
		this.statisambiance = statisambiance;
		this.statisCommunicationOnFc = statisCommunicationOnFc;
		this.noteFc = noteFc;
		this.parent = parent;
	}





	public void setParent(Parent parent) {
		this.parent = parent;
	}





	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Satisfactions getSatisfactionOfYourChild() {
		return satisfactionOfYourChild;
	}


	public void setSatisfactionOfYourChild(Satisfactions satisfactionOfYourChild) {
		this.satisfactionOfYourChild = satisfactionOfYourChild;
	}


	public Satisfactions getSysOfEducation() {
		return sysOfEducation;
	}


	public void setSysOfEducation(Satisfactions sysOfEducation) {
		this.sysOfEducation = sysOfEducation;
	}


	public Satisfactions getSatisEvent() {
		return satisEvent;
	}


	public void setSatisEvent(Satisfactions satisEvent) {
		this.satisEvent = satisEvent;
	}


	public Satisfactions getSatisOffer() {
		return satisOffer;
	}


	public void setSatisOffer(Satisfactions satisOffer) {
		this.satisOffer = satisOffer;
	}


	public Satisfactions getStatisTeamsOfFc() {
		return statisTeamsOfFc;
	}


	public void setStatisTeamsOfFc(Satisfactions statisTeamsOfFc) {
		this.statisTeamsOfFc = statisTeamsOfFc;
	}


	public Satisfactions getStatisambiance() {
		return statisambiance;
	}


	public void setStatisambiance(Satisfactions statisambiance) {
		this.statisambiance = statisambiance;
	}



	public Satisfactions getStatisCommunationOnFc() {
		return statisCommunicationOnFc;
	}


	public void setStatisCommunationOnFc(Satisfactions statisCommunationOnFc) {
		this.statisCommunicationOnFc = statisCommunationOnFc;
	}


	public Satisfactions getNoteFc() {
		return noteFc;
	}


	public void setNoteFc(Satisfactions noteFc) {
		this.noteFc = noteFc;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}