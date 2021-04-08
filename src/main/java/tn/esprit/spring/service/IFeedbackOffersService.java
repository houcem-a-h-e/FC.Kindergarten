package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.FeedbackOffers;

public interface IFeedbackOffersService {

	List<FeedbackOffers> retieveAllFeedbackOffers();
	
	FeedbackOffers AddFeedbackOffers(FeedbackOffers FdO,Long id);
	FeedbackOffers retieveFeedbackOffersById(Long id);
	void deleteFeedbackOffers(Long id);
}
