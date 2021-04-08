package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Events;

public interface IEventsService {
	List<Events> retrieveAllEvents();
	Events AddEvents(Events Ev,Long id);
	void deleteEv(Long id);
	Events retrieveEventById(Long id);

}
