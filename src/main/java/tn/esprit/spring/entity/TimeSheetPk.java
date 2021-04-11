package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class TimeSheetPk implements Serializable {
	
	private Long kinderID;
	private Long ParentID;
	@Temporal(TemporalType.DATE)
	private Date date;
	public Long getKinderID() {
		return kinderID;
	}
	public void setKinderID(Long kinderID) {
		this.kinderID = kinderID;
	}
	public Long getParentID() {
		return ParentID;
	}
	public void setParentID(Long parentID) {
		ParentID = parentID;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public TimeSheetPk(Long kinderID, Long parentID, Date date) {
		super();
		this.kinderID = kinderID;
		ParentID = parentID;
		this.date = date;
	}
	public TimeSheetPk() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
