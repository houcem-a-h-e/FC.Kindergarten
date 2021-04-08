package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Offers;

public interface IOffersService {

	List<Offers> retrieveAllOffer();
	Offers AddOffers(Offers offer,Long id);
	void deleteOffers(Long id);
	Offers retrieveOfferById(Long id);
}
