package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Offer;
import tn.esprit.spring.repository.OfferRepository;
@Service
public class OfferServiceImpl implements IofferService {
	@Autowired
	private OfferRepository offerrepository;
	private static final Logger l = LogManager.getLogger(OfferServiceImpl.class);

	@Override
	public List<Offer> retrieveAllOffers() {
		List<Offer> offers =(List<Offer>) offerrepository.findAll();
		for(Offer offer:offers)
			l.info("liste des offres:::"+offer);
		return offers;
	}

	@Override
	public Offer addOffer(Offer o) {
		
		return offerrepository.save(o);
	}

	@Override
	public void deleteOffer(String id) {
		offerrepository.deleteById(Long.parseLong(id));
	}

	@Override
	public Offer updateOffer(Offer o) {
		
		return offerrepository.save(o);
	}

	@Override
	public Offer retrieveOffer(String id) {
		Offer o = offerrepository.findById(Long.parseLong(id)).orElse(null);
		return o;
	}
}
