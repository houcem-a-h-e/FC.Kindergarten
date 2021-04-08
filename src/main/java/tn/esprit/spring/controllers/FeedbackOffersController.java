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

import tn.esprit.spring.entity.FeedbackOffers;
import tn.esprit.spring.service.FeedbackOfferServiceImp;

@RestController
@RequestMapping("/FeedbackOffers")
public class FeedbackOffersController {

	@Autowired
	private FeedbackOfferServiceImp FeedbackOfferServImp;
	
	//http://localhost:8083/SpringMVC/servlet/FeedbackOffers/addFeedbackOffer/offers_id
	@PostMapping("/addFeedbackOffer/{offers_id}")
	@ResponseBody
	public FeedbackOffers AddFeedbackOffers(@RequestBody FeedbackOffers FdO,@PathVariable Long offers_id) {
		FeedbackOffers fdOffers=FeedbackOfferServImp.AddFeedbackOffers(FdO,offers_id);
		return fdOffers;
	}
	
	//http://localhost:8083/SpringMVC/servlet/FeedbackOffers/id
	@GetMapping("/{id}")
	@ResponseBody
	public FeedbackOffers retieveFeedbackOffersById(@PathVariable Long id) {
		return FeedbackOfferServImp.retieveFeedbackOffersById(id);
	}
	
	//http://localhost:8083/SpringMVC/servlet/FeedbackOffers/all
	@GetMapping("/all")
	@ResponseBody
	public List<FeedbackOffers> retieveAllFeedbackOffers() {
		return FeedbackOfferServImp.retieveAllFeedbackOffers();
	}
	
	//http://localhost:8083/SpringMVC/servlet/FeedbackOffers/delete/id
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public String deleteFeedbackOffers(@PathVariable Long id){
		FeedbackOfferServImp.deleteFeedbackOffers(id);
		return "it is done";
	}
}
