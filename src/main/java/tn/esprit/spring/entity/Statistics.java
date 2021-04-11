package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Statistics implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
    private int id_statistics;
	public int getId_statistics() {
		return id_statistics;
	}
	public void setId_statistics(int id_statistics) {
		this.id_statistics = id_statistics;
	}
	
}
