package com.esprit.tn.entities;

import java.io.Serializable;

import java.util.Date;
//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "EVENT")
public class Event implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Event_id")
	private Long idEvent;

	@Column(name = "Event_title")
	private String title;

	@Column(name = "Event_Photo")
	private String photo;

	@Column(name = "Event_Description")
	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name = "Event_Date")
	private Date date_event;
	@Temporal(TemporalType.DATE)
	@Column(name = "Event_start_heure")
	private java.util.Date event_start_heure;
	@Temporal(TemporalType.DATE)
	@Column(name = "Event_fin_heure")
	private java.util.Date event_fin_heure;

	@Temporal(TemporalType.DATE)
	@Column(name = "Event_Final_reservation")
	private Date date_final_reservation;

	@Column(name = "Event_Nbr_Place")
	private int nbr_places;

	@Column(name = "Event_Nbr_Participants")
	private int nbr_participants;

	@Column(name = "Event_Nbr_interessants")
	private int nbr_interssants;

	@Column(name = "Event_Nbr_places_occupes")
	private int nbr_places_occupes;

	@Column(name = "Event_Nbr_ignorer")
	private int Nbr_ignorer;

	@Column(name = "Event_invites")
	private int nbr_invites;

	@Column(name = "Event_budget")
	private Double event_budget;

	@Column(name = "Entry_price")
	private Double entry_price;

	@Enumerated(EnumType.STRING)
	private Category_event category;

	@Enumerated(EnumType.STRING)
	private Etat_event etat_event;

	@Enumerated(EnumType.STRING)
	private Type_Event type_event;

	@Enumerated(EnumType.STRING)
	private Locationevent location_event;

	@ManyToOne
	KinderGarten kinderGardenevent;

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(Long idEvent) {
		this.idEvent = idEvent;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate_event() {
		return date_event;
	}

	public void setDate_event(Date date_event) {
		this.date_event = date_event;
	}

	public java.util.Date getEvent_start_heure() {
		return event_start_heure;
	}

	public void setEvent_start_heure(java.util.Date event_start_heure) {
		this.event_start_heure = event_start_heure;
	}

	public java.util.Date getEvent_fin_heure() {
		return event_fin_heure;
	}

	public void setEvent_fin_heure(java.util.Date event_fin_heure) {
		this.event_fin_heure = event_fin_heure;
	}

	public Date getDate_final_reservation() {
		return date_final_reservation;
	}

	public void setDate_final_reservation(Date date_final_reservation) {
		this.date_final_reservation = date_final_reservation;
	}

	public int getNbr_places() {
		return nbr_places;
	}

	public void setNbr_places(int nbr_places) {
		this.nbr_places = nbr_places;
	}

	public int getNbr_participants() {
		return nbr_participants;
	}

	public void setNbr_participants(int nbr_participants) {
		this.nbr_participants = nbr_participants;
	}

	public int getNbr_interssants() {
		return nbr_interssants;
	}

	public void setNbr_interssants(int nbr_interssants) {
		this.nbr_interssants = nbr_interssants;
	}

	public int getNbr_places_occupes() {
		return nbr_places_occupes;
	}

	public void setNbr_places_occupes(int nbr_places_occupes) {
		this.nbr_places_occupes = nbr_places_occupes;
	}

	public int getNbr_ignorer() {
		return Nbr_ignorer;
	}

	public void setNbr_ignorer(int nbr_ignorer) {
		Nbr_ignorer = nbr_ignorer;
	}

	public int getNbr_invites() {
		return nbr_invites;
	}

	public void setNbr_invites(int nbr_invites) {
		this.nbr_invites = nbr_invites;
	}

	public Double getEvent_budget() {
		return event_budget;
	}

	public void setEvent_budget(Double event_budget) {
		this.event_budget = event_budget;
	}

	public Double getEntry_price() {
		return entry_price;
	}

	public void setEntry_price(Double entry_price) {
		this.entry_price = entry_price;
	}

	public Category_event getCategory() {
		return category;
	}

	public void setCategory(Category_event category) {
		this.category = category;
	}

	public Etat_event getEtat_event() {
		return etat_event;
	}

	public void setEtat_event(Etat_event etat_event) {
		this.etat_event = etat_event;
	}

	public Type_Event getType_event() {
		return type_event;
	}

	public void setType_event(Type_Event type_event) {
		this.type_event = type_event;
	}

	public Locationevent getLocation_event() {
		return location_event;
	}

	public void setLocation_event(Locationevent location_event) {
		this.location_event = location_event;
	}

	public KinderGarten getKinderGardenevent() {
		return kinderGardenevent;
	}

	public void setKinderGardenevent(KinderGarten kinderGardenevent) {
		this.kinderGardenevent = kinderGardenevent;
	}

	public Event(Long idEvent, String title, String photo, String description, Date date_event, Date event_start_heure,
			Date event_fin_heure, Date date_final_reservation, int nbr_places, int nbr_participants,
			int nbr_interssants, int nbr_places_occupes, int nbr_ignorer, int nbr_invites, Double event_budget,
			Double entry_price, Category_event category, Etat_event etat_event, Type_Event type_event,
			Locationevent location_event) {
		super();
		this.idEvent = idEvent;
		this.title = title;
		this.photo = photo;
		this.description = description;
		this.date_event = date_event;
		this.event_start_heure = event_start_heure;
		this.event_fin_heure = event_fin_heure;
		this.date_final_reservation = date_final_reservation;
		this.nbr_places = nbr_places;
		this.nbr_participants = nbr_participants;
		this.nbr_interssants = nbr_interssants;
		this.nbr_places_occupes = nbr_places_occupes;
		Nbr_ignorer = nbr_ignorer;
		this.nbr_invites = nbr_invites;
		this.event_budget = event_budget;
		this.entry_price = entry_price;
		this.category = category;
		this.etat_event = etat_event;
		this.type_event = type_event;
		this.location_event = location_event;

	}

	@Override
	public String toString() {
		return "Event [idEvent=" + idEvent + ", title=" + title + ", photo=" + photo + ", description=" + description
				+ ", date_event=" + date_event + ", event_start_heure=" + event_start_heure + ", event_fin_heure="
				+ event_fin_heure + ", date_final_reservation=" + date_final_reservation + ", nbr_places=" + nbr_places
				+ ", nbr_participants=" + nbr_participants + ", nbr_interssants=" + nbr_interssants
				+ ", nbr_places_occupes=" + nbr_places_occupes + ", Nbr_ignorer=" + Nbr_ignorer + ", nbr_invites="
				+ nbr_invites + ", event_budget=" + event_budget + ", entry_price=" + entry_price + ", category="
				+ category + ", etat_event=" + etat_event + ", type_event=" + type_event + ", location_event="
				+ location_event + "]";
	}

}
