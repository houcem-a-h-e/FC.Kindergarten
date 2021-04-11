package tn.esprit.spring.entity;

import java.io.Serializable;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import net.minidev.json.annotate.JsonIgnore;

@Entity
public class TimesheetDelegate implements Serializable{
	@EmbeddedId
	TimeSheetPk pk;
	@ManyToOne
	@com.fasterxml.jackson.annotation.JsonIgnore
	@JoinColumn(name="kinderID" ,referencedColumnName="id",updatable=false,insertable=false)

	Kindergarten kindergarten;
	@ManyToOne
	@com.fasterxml.jackson.annotation.JsonIgnore

	@JoinColumn(name="ParentID" ,referencedColumnName="id",updatable=false,insertable=false)
	Parent parent;
	private boolean isValide=false;
	
	public boolean isValide() {
		return isValide;
	}
	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}
	public TimeSheetPk getPk() {
		return pk;
	}
	public void setPk(TimeSheetPk pk) {
		this.pk = pk;
	}
	public Kindergarten getKindergarten() {
		return kindergarten;
	}
	public void setKindergarten(Kindergarten kindergarten) {
		this.kindergarten = kindergarten;
	}
	public Parent getParent() {
		return parent;
	}
	public void setParent(Parent parent) {
		this.parent = parent;
	}
	public TimesheetDelegate(TimeSheetPk pk, Kindergarten kindergarten, Parent parent) {
		super();
		this.pk = pk;
		this.kindergarten = kindergarten;
		this.parent = parent;
	}
	public TimesheetDelegate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
