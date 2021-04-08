package tn.esprit.spring.control;

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
import tn.esprit.spring.entity.Kindergarten;
import tn.esprit.spring.service.KindergartenService;

@RestController
@RequestMapping("/api")

public class KindergartenController {
	
	@Autowired
	KindergartenService kindergartenService;
	
	@GetMapping("/kindergarten/{id}")
	public Optional<Kindergarten> afficher (@PathVariable("id") String id){
		return  kindergartenService.retrieveKindergarten(id);
	}
	
	@GetMapping("/kindergarten/all")
	public List<Kindergarten> afficherAllChild (){
		return  kindergartenService.retrieveAllKindergarten();
	}
	@PostMapping("/kindergarten/add")
	public Kindergarten add(@RequestBody Kindergarten k){
		return kindergartenService.addKindergarten(k);
	}
	@DeleteMapping("/remove-kindergarten/{id}")
	@ResponseBody
	public void removeKindergarten(@PathVariable("id") String id) {
		kindergartenService.deleteKindergarten(id);
	}
	@PutMapping("/modify-kindergarten")
	@ResponseBody
	public String modifyKindergarten(@RequestBody Kindergarten k) {
		List<Kindergarten>kindergartens=kindergartenService.retrieveAllKindergarten();
		for(Kindergarten i:kindergartens)
			if(i.getId()==k.getId()){
			kindergartenService.updateKindergarten(k);
	   return "modify successfully from id ="+k.getId(); 
	   
	         }
		return " kindergarten not found " ;
		}

}
