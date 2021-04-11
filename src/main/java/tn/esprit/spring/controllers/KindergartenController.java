package tn.esprit.spring.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import tn.esprit.spring.entity.TimesheetDelegate;
import tn.esprit.spring.entity.Users;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.service.IDelegateService;
import tn.esprit.spring.service.KindergartenService;

@RestController
@RequestMapping("/api")

public class KindergartenController {
	
	@Autowired
	KindergartenService kindergartenService;
	@Autowired
	IDelegateService iDelegateService;
	@GetMapping("/kindergarten/{id}")
	public Kindergarten afficher (@PathVariable("id") Long id){
		return  kindergartenService.retrieveKindergarten(id);
	}
	
	@GetMapping("/kindergarten/all")
	public List<Kindergarten> afficherAllChild (){
		return  kindergartenService.retrieveAllKindergarten();
	}
	
	
	@PostMapping("/kindergarten/add")
	public String add(@RequestBody Kindergarten k){
		List<Kindergarten> kinder=kindergartenService.retrieveAllKindergarten();
		//String email = k.getEmail();

		List<Kindergarten> l= kinder.stream().filter(x->x.getEmail().equals( k.getEmail())).collect(Collectors.toList());
		if(l.isEmpty()){
		 kindergartenService.addKindergarten(k);
		 return "succs";
		}
		return "kindergarten is existe";
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
	@GetMapping("/KindergartenMyParent/{id}")
	public HashMap<Long, String> findParentfromKindergarten(@PathVariable("id")Long id) {

	 return kindergartenService.findParentfromKindergarten(id);
	}
	@PutMapping("/kindergarten/affectationdemandeParentforDelegate/{idk}/{idp}")
	public List<TimesheetDelegate> affactation (@PathVariable("idk") Long idk,@PathVariable("idp") Long idp){
		
		List<TimesheetDelegate> delegates=iDelegateService.retrieveAll();
		for(TimesheetDelegate d:delegates){
			if(d.getPk().getParentID()==idp&&d.getPk().getKinderID()==idk){
				d.setValide(true);
				iDelegateService.updateDelegate(d);
				Kindergarten k=	kindergartenService.retrieveKindergarten(idk);
				HashMap<String, Integer> v=new HashMap<>();
				v.put(k.getEmail(),0);
				k.setVote(v);
				kindergartenService.updateKindergarten(k);
		}
		}
		return  delegates;
	}


}
