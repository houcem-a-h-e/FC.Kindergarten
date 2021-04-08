package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Kindergarten;
import tn.esprit.spring.service.KindergartenServiceImp;

@RestController
@RequestMapping("/Kindergarten")
public class kindergartenController {

	@Autowired
	KindergartenServiceImp KgServImp;
	
	
	//http://localhost:8083/SpringMVC/servlet/Kindergarten/addKg
	@PostMapping("/addKg")
	@ResponseBody
	public Kindergarten AddKg(@RequestBody Kindergarten Kg){
		Kindergarten Kgn = KgServImp.AddKg(Kg);
		return Kgn;
	}
	
	//http://localhost:8083/SpringMVC/servlet/Kindergarten/allKg
	@GetMapping("/allKg")
	@ResponseBody
	public List<Kindergarten> retrieveAllKg(){
		return KgServImp.RetrieveAllKg();
	}
	
	//http://localhost:8083/SpringMVC/servlet/Kindergarten/id
	@GetMapping("/{id}")
	@ResponseBody
	public Kindergarten retrieveKgByid(Long id){
		return KgServImp.RetrieveKgById(id);


	}
}
