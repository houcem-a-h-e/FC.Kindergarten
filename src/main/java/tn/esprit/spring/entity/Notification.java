package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "NOTIFICATION")
public class Notification {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Notification_id")
	private Long idEvent;

	@Column(name = "Notifiction_message")
	private String message;
	////////////////////////////////
	@ManyToOne
	private Parent parents;
	@ManyToOne
	private Event events;
	
	///////////////////////
	
	
	public Long getIdEvent() {
		return idEvent;
	}
	public void setIdEvent(Long idEvent) {
		this.idEvent = idEvent;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Parent getParents() {
		return parents;
	}
	public void setParents(Parent parents) {
		this.parents = parents;
	}
	public Event getEvents() {
		return events;
	}
	public void setEvents(Event events) {
		this.events = events;
	}
	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Notification(Long idEvent, String message, Parent parents, Event events) {
		super();
		this.idEvent = idEvent;
		this.message = message;
		this.parents = parents;
		this.events = events;
	}
	@Override
	public String toString() {
		return "Notification [idEvent=" + idEvent + ", message=" + message + ", parents=" + parents + ", events="
				+ events + "]";
	}


}
