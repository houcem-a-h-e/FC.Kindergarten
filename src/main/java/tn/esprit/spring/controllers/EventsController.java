package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Events;
import tn.esprit.spring.service.EventsServiceImp;

@RestController
@RequestMapping("/Events")
public class EventsController {

	@Autowired
	private EventsServiceImp eventsServImp;
	
	
	
	//http://localhost:8083/SpringMVC/servlet/Events/all
	@GetMapping("/all")
	@ResponseBody
	public List<Events> retrieveAllEvents() {
		return (List<Events>) eventsServImp.retrieveAllEvents();
	}
	
	
	
	//http://localhost:8083/SpringMVC/servlet/Events/addEvents
	@PostMapping("/addEvents")
	@ResponseBody
	public Events AddEvents(@RequestBody Events Ev,@PathVariable Long id) {
		Events ev=eventsServImp.AddEvents(Ev, id);
		return ev;
	}
	
	
	
	//http://localhost:8083/SpringMVC/servlet/Events/id
	@GetMapping("/{id}")
	@ResponseBody
	public Events retrieveEventById(@PathVariable Long id) {
		return eventsServImp.retrieveEventById(id);
	}
	
	
	
	//http://localhost:8083/SpringMVC/servlet/Events/delete/id
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public String deleteEv(@PathVariable Long id) {
		eventsServImp.deleteEv(id);
		return "it is done";
	}
}
