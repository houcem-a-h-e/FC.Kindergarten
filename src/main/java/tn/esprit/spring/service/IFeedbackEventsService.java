package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.FeedbackEvents;

public interface IFeedbackEventsService {

	List<FeedbackEvents> retrieveAllFeedbackEvents();
	FeedbackEvents AddFeedbackEv(FeedbackEvents FDE,Long id);
	void deleteFdEv(Long id);
	FeedbackEvents retrieveFeedbackEventById(Long id);
	
}
