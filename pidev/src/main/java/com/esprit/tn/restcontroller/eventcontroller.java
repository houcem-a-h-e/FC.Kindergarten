package com.esprit.tn.restcontroller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.tn.entities.Event;
import com.esprit.tn.services.EventService;
import com.esprit.tn.services.EventServiceImpl;

@RestController
public class eventcontroller {

@Autowired
EventService CEvent;
////http://localhost:8550/SpringMVC/servlet/retriveallevent
@GetMapping("/retriveallevent")
@ResponseBody
public List<Event> getEvent() {
	List<Event> list= CEvent.retrieveAllEvents();
	return list;}

//// http://localhost:8550/SpringMVC/servlet/add-event
@PostMapping("/add-event")
@ResponseBody
public Event addEvent(@RequestBody Event e) {
	return CEvent.addEvent(e);
 }

//Modifier Event : http://localhost:8550/update-event
@PutMapping("/update-event")
@ResponseBody
public Event ModifierEvent(@RequestBody Event e
){
	return CEvent.updateEvent(e);
} 

//http://localhost:8550/SpringMVC/servlet/remove-event/{event-id}
@DeleteMapping("/remove-event/{event-id}")
@ResponseBody
public void removeUser(@PathVariable(name="event-id")
String idEvent) {
	CEvent.deleteEvent(idEvent);
}

//http://localhost:8550/SpringMVC/servlet/retrieve-event/{idEvent}
@GetMapping("/retrieve-event/{idEvent}")
@ResponseBody
public Event retrieveEvent(@PathVariable("idEvent") String idEvent) {
return CEvent.retrieveEvent(idEvent);
} 




}
