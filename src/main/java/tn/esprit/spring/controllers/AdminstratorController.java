package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Kindergarten;
import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.mail.SendMail;
import tn.esprit.spring.service.IAdminstratorService;

@RestController
@RequestMapping("/api")
public class AdminstratorController {
	
	@Autowired
	IAdminstratorService adminstratorService;
	@Autowired
	SendMail sendMail
	;
	@PutMapping("/adminstrator/Confirmation/{id}")
	public String Confirmationkindergarten( @PathVariable("id") Long id ){
		List<Kindergarten> k=adminstratorService.findallkindergartens();
		for(Kindergarten i:k){
			if(i.getId()==id){
		    adminstratorService.KindergartenRegistrationConfirmation(id);
			//sendMail.send(i.getEmail());
		return "kindergarten from id = "+id+" Confirmation"	;
		}}
		return "not found";

	}
	@GetMapping("/adminstrator/allkinder")
	public List<Kindergarten> GetAllkindergarten (){
		return  adminstratorService.findallkindergartens();
	}
	@GetMapping("/adminstrator/allkinder/{id}")
	public List<Parent> GetAllParentsfromKindergarten ( @PathVariable("id") Long id){
		return  adminstratorService.findParentfromKindergarten(id);
	}
	
	
	

}
