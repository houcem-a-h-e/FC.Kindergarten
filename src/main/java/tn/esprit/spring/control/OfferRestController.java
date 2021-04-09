package tn.esprit.spring.control;

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

import tn.esprit.spring.entity.Offer;
import tn.esprit.spring.mail.SendMail;
import tn.esprit.spring.service.IKindergartenService;
import tn.esprit.spring.service.IofferService;
import tn.esprit.spring.service.SmsSenderImpl;

@RestController
public class OfferRestController {
	@Autowired
	IofferService os;
	@Autowired
	SendMail sendmail;
	@Autowired
	IKindergartenService ks;
	
	@Autowired
	SmsSenderImpl ss;
	
	@GetMapping("/retrieve")
	public List<Offer> getOffer(){
		//List<Offer> list= os.retrieveAllOffers();
		return os.retrieveAllOffers();
		
	}
	@GetMapping("/hello")
	public String getHello(){
		return "hello";
	}
	@PostMapping("/addoffer")
	public Offer addOffer(@RequestBody Offer o  ){
		Offer offer= os.addOffer(o);
		/*int kindergartenId =(int) offer.getKindergarten().getId();
		List<String> mail = ks.getAllemailsParentByKindergarten( kindergartenId);
		for(String to : mail)
			sendmail.send(to);*/
		//sendmail.send("hassen.aloui@esprit.tn");
		os.sendingSms(o);
		
		return offer;
	}
	@GetMapping("/retrieve-offer/{offerId}")
	@ResponseBody
	public Offer retrieveOffers(@PathVariable("offerId") String offerid){
		return os.retrieveOffer(offerid);
	}
	@DeleteMapping("/delete-offer/{offerId}")
	@ResponseBody
	public void deleteOffer(@PathVariable("offerId") String offerid){
		os.deleteOffer(offerid);
		
	}
	@PutMapping("/update")
	@ResponseBody 
	public Offer upDate(@RequestBody Offer offer){
		return os.updateOffer(offer);
	}
}
