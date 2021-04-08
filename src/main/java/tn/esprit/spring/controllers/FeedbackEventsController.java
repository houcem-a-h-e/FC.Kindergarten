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

import tn.esprit.spring.entity.FeedbackEvents;
import tn.esprit.spring.service.FeedbackEventServiceImp;

@RestController
@RequestMapping("/FeedbackEvent")
public class FeedbackEventsController {
	@Autowired
	private FeedbackEventServiceImp feedbackEvServiIpm;
	
	
	//http://localhost:8083/SpringMVC/servlet/FeedbackEvent/addFeedbackEvent
	@PostMapping("/addFeedbackEvent/{event_id}")
	@ResponseBody
	public FeedbackEvents AddFeedbackEv(@RequestBody FeedbackEvents FDE, Long event_id)  {
		FeedbackEvents fdEv =feedbackEvServiIpm.AddFeedbackEv(FDE, event_id);
		return fdEv;
	}
	
	//http://localhost:8083/SpringMVC/servlet/FeedbackEvent/id
	@GetMapping("/{id}")
	@ResponseBody
	public FeedbackEvents retrieveFeedbackEventById(@PathVariable Long id){
		return feedbackEvServiIpm.retrieveFeedbackEventById(id);
	}
	
	//http://localhost:8083/SpringMVC/servlet/FeedbackEvent/all
	@GetMapping("/all")
	@ResponseBody
	public List<FeedbackEvents> retrieveAllFeedbackEvents(){
		return feedbackEvServiIpm.retrieveAllFeedbackEvents();
	}
	
	//http://localhost:8083/SpringMVC/servlet/FeedbackEvent/delete/id
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public String deleteFdEv(@PathVariable Long id) {
		feedbackEvServiIpm.deleteFdEv(id);
		return "it is done";
	}
}
