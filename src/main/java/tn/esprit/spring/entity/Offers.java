package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class Offers implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	@OneToMany(cascade= CascadeType.ALL,mappedBy="offers")
	@JsonBackReference
	private Set<FeedbackOffers> feedbackOffers;

	public Offers() {
		super();
	}


	public Offers(Long id, Set<FeedbackOffers> feedbackOffers) {
		super();
		this.id = id;
		this.feedbackOffers = feedbackOffers;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Set<FeedbackOffers> getFeedbackOffers() {
		return feedbackOffers;
	}

	public void setFeedbackOffers(Set<FeedbackOffers> feedbackOffers) {
		this.feedbackOffers = feedbackOffers;
	}

}
