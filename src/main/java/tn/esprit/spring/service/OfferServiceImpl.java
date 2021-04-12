package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

import tn.esprit.spring.entity.Offer;
import tn.esprit.spring.repository.OfferRepository;
import tn.esprit.spring.sms.TwilioConfiguration;
@Service
public class OfferServiceImpl implements IofferService {
	@Autowired
	private OfferRepository offerrepository;
	private static final Logger l = LogManager.getLogger(OfferServiceImpl.class);
	@Autowired
	TwilioConfiguration twilioconfig;

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
	/*@Override
	public void sendingSms(Offer offerrequest) {
		// TODO Auto-generated method stub
		MessageCreator creator = Message.creator(new PhoneNumber(offerrequest.getPhoneNumber()) ,
												  new PhoneNumber(twilioconfig.getTrialNumber()), 
												  offerrequest.getMessage());
		creator.create();
	}*/

	@Override
	public void sendingSms(Offer offerrequest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Integer> getNumberOfferByKinder(long kinderid) {
		// TODO Auto-generated method stub
		return offerrepository.getNumberOfferByKinder(kinderid);
	}

	@Override
	public List<String> getMostKinderOffer() {
		// TODO Auto-generated method stub
		return offerrepository.getMostKinderOffer();
	}

	
}
