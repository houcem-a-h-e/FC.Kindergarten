package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Offer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String subject;
	@Temporal(TemporalType.DATE)
	private Date date;
	private String availability;
	
	@ManyToOne
	private Kindergarten kindergarten;
	
	public Kindergarten getKindergarten() {
		return kindergarten;
	}
	public void setKindergarten(Kindergarten kindergarten) {
		this.kindergarten = kindergarten;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public Offer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Offer(long id, String subject, Date date, String availability) {
		super();
		this.id = id;
		this.subject = subject;
		this.date = date;
		this.availability = availability;
	}
	@Override
	public String toString() {
		return "Offer [id=" + id + ", subject=" + subject + ", date=" + date + ", availability=" + availability + "]";
	}
	
	
	
	
}
