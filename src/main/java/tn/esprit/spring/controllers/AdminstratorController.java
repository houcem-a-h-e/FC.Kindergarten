package tn.esprit.spring.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.JwtRequest;
import tn.esprit.spring.entity.Kindergarten;
import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.entity.UserDto;
import tn.esprit.spring.mail.SendMail;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.service.IAdminstratorService;
import tn.esprit.spring.service.JwtUserDetailsService;
import tn.esprit.spring.service.KindergartenService;

@RestController
@RequestMapping("/api")
public class AdminstratorController {
	
	@Autowired
	IAdminstratorService adminstratorService;
	

	@Autowired
	KindergartenService kindergartenService;
	
	@PutMapping("/adminstrator/Confirmation/{id}")
	public String Confirmationkindergarten( @PathVariable("id") Long id ) throws Exception{
		List<Kindergarten> k=kindergartenService.findallkindergartens();
		for(Kindergarten i:k)
		{
			if(i.getId()==id)
			{

		    adminstratorService.KindergartenRegistrationConfirmation(id);
		    
		return "kindergarten from id = "+id+" Confirmation"	;
			}
		}
		return "not found";


	}
	
	@GetMapping("/adminstrator/allkinder")
	public List<Kindergarten> GetAllkindergarten (){
		return  kindergartenService.findallkindergartens();
	}
	@GetMapping("/adminstrator/kinderparent/{id}")
	public HashMap<Long, String> findParentfromKindergarten(@PathVariable("id")Long id) {

	 return kindergartenService.findParentfromKindergarten(id);
	}
	
	@GetMapping("/adminstrator/rangkinder")
	public  HashMap<String, Long> GetRangKindergartens (){
		List<Kindergarten> k=kindergartenService.findallkindergartens();
	    HashMap<String, Long> rangKnder = new HashMap<String, Long>();
	

		return  rangKnder;
	}
	
	
	

}
