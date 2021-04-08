package com.esprit.tn.services;

import java.util.List;

import com.esprit.tn.entities.Event;


public interface EventService    {
	 List<Event> retrieveAllEvents(); 
	 Event addEvent (Event e);
	 void deleteEvent(String id);
	 Event updateEvent(Event e);
    Event retrieveEvent(String id);

}
