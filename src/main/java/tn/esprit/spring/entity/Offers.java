package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Offers implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date date;
	private String title;
	private String descriptions;
	
	@OneToMany(cascade= CascadeType.ALL,mappedBy="offers")
	private Set<FeedbackOffers> feedbackOffers;

	public Offers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Offers(Long id, Date date, String title, String descriptions, Set<FeedbackOffers> feedbackOffers) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.descriptions = descriptions;
		this.feedbackOffers = feedbackOffers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public Set<FeedbackOffers> getFeedbackOffers() {
		return feedbackOffers;
	}

	public void setFeedbackOffers(Set<FeedbackOffers> feedbackOffers) {
		this.feedbackOffers = feedbackOffers;
	}

}
