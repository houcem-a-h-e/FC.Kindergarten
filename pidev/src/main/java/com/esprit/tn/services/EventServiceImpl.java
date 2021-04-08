package com.esprit.tn.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.esprit.tn.entities.Event;

import com.esprit.tn.repository.EventReposiory;

@Service
public class EventServiceImpl implements EventService {
	@Autowired
	EventReposiory eventrepository;
	private static final Logger l = LogManager.getLogger(EventServiceImpl.class);

	@Override
	public List<Event> retrieveAllEvents() {

		List<Event> events = (List<Event>) eventrepository.findAll();
		for (Event event : events) {
			l.info("Event" + event);
		}
		return events;

	}

	@Override
	public Event addEvent(Event e) {
		return eventrepository.save(e);
		
	}

	@Override
	public void deleteEvent(String id) {
		eventrepository.deleteById(Long.parseLong(id));
	}

	@Override
	public Event updateEvent(Event e) {
		return eventrepository.save(e);
	}

	@Override
	public Event retrieveEvent(String idEvent) {

		return eventrepository.findById(Long.parseLong(idEvent)).orElse(new Event());
	}

}