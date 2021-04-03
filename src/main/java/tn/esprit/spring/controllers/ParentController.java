package tn.esprit.spring.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Child;
import tn.esprit.spring.entity.Kindergarten;
import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.mail.SendMail;
import tn.esprit.spring.service.IParentService;
import tn.esprit.spring.service.ParentService;

@RestController
@RequestMapping("/api")
public class ParentController {

	@Autowired
	IParentService iParentService;
	
	@Autowired
	SendMail sendMail;
	
    //final	IParentService iParentService;
	Logger logger=LoggerFactory.getLogger(ParentController.class);
	
	@GetMapping("/parent/{id}")
	public Optional<Parent> afficher (@PathVariable("id") String id){
		return  iParentService.retrieveParent(id);
	}
	
	@GetMapping("/parent/all")
	public List<Parent> afficherAllParent (){
		return  iParentService.retrieveAllParent();
	}
	
	@PostMapping("/parent/add")
	public String addParent(@RequestBody Parent parent){
		logger.info("test"+parent);
		List<Parent>parents=iParentService.retrieveAllParent();
		String email = parent.getEmail();
		parents.stream().filter(x->x.getEmail().equals(email)).collect(Collectors.toList());
				if(parents.isEmpty())
				{
					iParentService.addParent(parent);
				//	sendMail.send(email)
					return "succs";
				}
				    return "parent existe";
	
	}/*
	public ParentController(IParentService iParentService) {
		this.iParentService = iParentService;
	}
	*/
	@DeleteMapping("/remove-Parent/{id}")
	@ResponseBody
	public void removeParent(@PathVariable("id") String id) {
		iParentService.deleteParent(id);
	}
	@PutMapping("/modify-Parent")
	@ResponseBody
	public String modifyParent(@RequestBody Parent p) {
		List<Parent>parents=iParentService.retrieveAllParent();
		for(Parent i:parents)
			if(i.getId()==p.getId()){
	   iParentService.updateParent(p);
	   return "modify successfully from id ="+p.getId(); 
	   
	         }
		return "parent not found " ;
		}
	@PutMapping("/Parent/{idP}/{idK}")
	public void abonneParent(@PathVariable("idP") Long idP,@PathVariable("idK") Long idK) {
		iParentService.abonneKindergarten(idP, idK);
	}
	@GetMapping("/parent/findkinder")
	public List<Kindergarten> afficherkinder (){
		return  iParentService.findkinder();
	}
}
