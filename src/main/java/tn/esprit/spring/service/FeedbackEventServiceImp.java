package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Events;
import tn.esprit.spring.entity.FeedbackEvents;
import tn.esprit.spring.repository.FeedbackEventsRepository;

@Service
public class FeedbackEventServiceImp implements IFeedbackEventsService {

	@Autowired
	FeedbackEventsRepository FeedbackEvRepo;
	@Autowired
	private EventsServiceImp evServImp;
	
	@Override
	public List<FeedbackEvents> retrieveAllFeedbackEvents() {
		
		return (List<FeedbackEvents>) FeedbackEvRepo.findAll();
	}

	@Override
	public FeedbackEvents AddFeedbackEv(FeedbackEvents FDE, Long event_id) {
		FDE.setDate(new Date());
		Events eve=evServImp.retrieveEventById(event_id);
		FDE.setEvent(eve);
		return FeedbackEvRepo.save(FDE);
	}

	@Override
	public void deleteFdEv(Long id) {
		FeedbackEvRepo.deleteById(id);
	}

	@Override
	public FeedbackEvents retrieveFeedbackEventById(Long id) {
	
		return FeedbackEvRepo.findById(id).orElse(null);
	}
	

}
