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
public class Bus_reservation implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_res;
	private String companye_name;
	private boolean disponibilite;
	@Temporal(TemporalType.DATE)
	private Date date_res;
	@ManyToOne
	Kindergarten kindergarten;
	public long getId_res() {
		return id_res;
	}

	public void setId_res(long id_res) {
		this.id_res = id_res;
	}

	public String getCompanye_name() {
		return companye_name;
	}

	public void setCompanye_name(String companye_name) {
		this.companye_name = companye_name;
	}

	public boolean isDisponibilite() {
		return disponibilite;
	}

	public void setDisponibilite(boolean disponibilite) {
		this.disponibilite = disponibilite;
	}

	public Date getDate_res() {
		return date_res;
	}

	public void setDate_res(Date date_res) {
		this.date_res = date_res;
	}

	public Kindergarten getKindergarten() {
		return kindergarten;
	}

	public void setKindergarten(Kindergarten kindergarten) {
		this.kindergarten = kindergarten;
	}


	
}
