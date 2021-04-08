package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.service.ParentServiceImp;

@RestController
@RequestMapping("/Parent")
public class ParentController {

	@Autowired
	ParentServiceImp ParServImp;
	
	//http://localhost:8083/SpringMVC/servlet/Parent/addParent
	@PostMapping("/addParent")
	@ResponseBody
	public Parent addParent(@RequestBody Parent PR){
		Parent Par = ParServImp.addParent(PR);
		return Par;
	}
	
	
	//http://localhost:8083/SpringMVC/servlet/Parent/allPar
	@GetMapping("/allPar")
	@ResponseBody
	public List<Parent> retrieveParent() {
		return ParServImp.retrieveAllParent();
	}

}
