package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Offer;

public interface IofferService  {
	List<Offer> retrieveAllOffers();
	Offer addOffer(Offer o);
	void deleteOffer(String id);
	Offer updateOffer(Offer o);
	Offer retrieveOffer(String id);
	 void sendingSms(Offer offerrequest);
}
