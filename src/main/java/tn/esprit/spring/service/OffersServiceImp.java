package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Offers;
import tn.esprit.spring.repository.OffersRepository;

@Service
public class OffersServiceImp implements IOffersService{
	
	@Autowired
	OffersRepository OffRepo;

	@Override
	public List<Offers> retrieveAllOffer() {
		return (List<Offers>) OffRepo.findAll() ;
	}

	@Override
	public Offers AddOffers(Offers offer, Long id) {
		offer.setDate(new Date());
		Offers Off =OffRepo.save(offer);
		return Off;
	}

	@Override
	public void deleteOffers(Long id) {
		OffRepo.deleteById(id);
		
	}

	@Override
	public Offers retrieveOfferById(Long id) {
		
		return OffRepo.findById(id).orElse(null);
	}
	

}
