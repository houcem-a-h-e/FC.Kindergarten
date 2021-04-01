package tn.esprit.spring.controllers;

import java.util.List;
import java.util.Optional;

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
import tn.esprit.spring.service.IChildService;

@RestController
@RequestMapping("/api")
public class ChildController {
	
	@Autowired
	IChildService childService;
	
	
	@GetMapping("/child/{id}")
	public Optional<Child> afficherChild (@PathVariable("id") String id){
		return  childService.retrieveChild(id);
	}
	
	@GetMapping("/child/all")
	public List<Child> afficherAllChild (){
		return  childService.retrieveAllChild();
	}
	
	@PostMapping("/child/add")
	public Child addChild(@RequestBody Child c){
		return childService.addChild(c);
	}/*
	public ParentController(IParentService iParentService) {
		this.iParentService = iParentService;
	}
	*/
	@DeleteMapping("/remove-child/{id}")
	@ResponseBody
	public void removeChild(@PathVariable("id") String id) {
		childService.deleteChild(id);
	}
	@PutMapping("/modify-child")
	@ResponseBody
	public String modifyChild(@RequestBody Child c) {
		List<Child>childs=childService.retrieveAllChild();
		for(Child i:childs)
			if(i.getId()==c.getId()){
				childService.updateChild(c);
	   return "modify successfully from id ="+c.getId(); 
	   
	         }
		return "child not found " ;
		}

}
