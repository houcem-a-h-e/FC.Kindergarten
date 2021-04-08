package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Events;
import tn.esprit.spring.repository.EventsRepository;

@Service
public class EventsServiceImp implements IEventsService{

	@Autowired
	EventsRepository EvRepo;
	@Override
	public List<Events> retrieveAllEvents() {
		return (List<Events>) EvRepo.findAll();
	}

	@Override
	public Events AddEvents(Events Ev, Long id) {
		Ev.setDate(new Date());
        Events ev=EvRepo.save(Ev);
		return ev;
	}

	@Override
	public void deleteEv(Long id) {
		EvRepo.deleteById(id);
		
	}

	@Override
	public Events retrieveEventById(Long id) {
		return EvRepo.findById(id).orElse(null);
	}
	

}
