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

import tn.esprit.spring.entity.Offers;
import tn.esprit.spring.service.OffersServiceImp;

@RestController
@RequestMapping("/Offers")
public class OffersController {
	@Autowired
	private OffersServiceImp offerServImp;
	
	
	//http://localhost:8083/SpringMVC/servlet/Offers/all
	@GetMapping("/all")
	@ResponseBody
	public List<Offers> retrieveAllOffer() {
		return offerServImp.retrieveAllOffer();
	}
	
	//http://localhost:8083/SpringMVC/servlet/Offers/addOffers
	@PostMapping("/addOffers")
	@ResponseBody
	public Offers AddOffers(@RequestBody Offers offer,@PathVariable Long id) {
		Offers off =offerServImp.AddOffers(offer, id);
		return off;
	}
	
	//http://localhost:8083/SpringMVC/servlet/Offers/id
	@GetMapping("/{id}")
	@ResponseBody
	public Offers retrieveOfferById(@PathVariable Long id){
		return offerServImp.retrieveOfferById(id);
	}
	
	//http://localhost:8083/SpringMVC/servlet/Offers/delete/id
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public String deleteOffers(@PathVariable Long id) {
		offerServImp.deleteOffers(id);
	  return "it is done";
	}
}
