package tn.esprit.spring.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Message implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	 private int id_chat;
	 private String description_chat;
	 private LocalDateTime time_chat =java.time.LocalDateTime.now();
	 
	 private String type_chat;
	 
	    @ManyToOne(cascade = CascadeType.MERGE)
	    @JoinColumn(name="id_Parent_sender")
	    Parent sender;
	 
	 @ManyToOne(cascade = CascadeType.MERGE)
	  @JoinColumn(name="id_Parent_reciever")
	    Parent reciever;

	public LocalDateTime getTime_chat() {
		return time_chat;
	}
	public void setTime_chat(LocalDateTime time_chat) {
		this.time_chat = time_chat;
	}
	public Parent getReciever() {
		return reciever;
	}
	public void setReciever(Parent reciever) {
		this.reciever = reciever;
	}
	public Parent getSender() {
			return sender;
		}
		public void setSender(Parent sender) {
			this.sender = sender;
		}

	public int getId_chat() {
		return id_chat;
	}
	public void setId_chat(int id_chat) {
		this.id_chat = id_chat;
	}

	public String getDescription_chat() {
		return description_chat;
	}
	public void setDescription_chat(String description_chat) {
		this.description_chat = description_chat;
	}

	public String getType_chat() {
		return type_chat;
	}
	public void setType_chat(String type_chat) {
		this.type_chat = type_chat;
	}

	 
}
