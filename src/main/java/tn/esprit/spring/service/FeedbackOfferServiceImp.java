package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.FeedbackOffers;
import tn.esprit.spring.entity.Offers;
import tn.esprit.spring.repository.FeedbackOffersRepository;
@Service
public class FeedbackOfferServiceImp implements IFeedbackOffersService {

	@Autowired
	FeedbackOffersRepository FeedbakEvRepo;
	@Autowired
	private OffersServiceImp OffServImp;
	
	@Override
	public List<FeedbackOffers> retieveAllFeedbackOffers() {
		
		return (List<FeedbackOffers>) FeedbakEvRepo.findAll();
	}

	@Override
	public FeedbackOffers AddFeedbackOffers(FeedbackOffers FdO,Long offers_id) {
		FdO.setDate(new Date());
		Offers Off=OffServImp.retrieveOfferById(offers_id);
		FdO.setOffers(Off);
		return FeedbakEvRepo.save(FdO);
	}

	@Override
	public FeedbackOffers retieveFeedbackOffersById(Long id) {
		return FeedbakEvRepo.findById(id).orElse(null);
	}

	@Override
	public void deleteFeedbackOffers(Long id) {
		 FeedbakEvRepo.deleteById(id);
	}
	

}
