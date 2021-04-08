package tn.esprit.spring.controllers;
//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.service.ReclamationServiceImp;

@RestController
@RequestMapping("/reclamation")
public class ReclamationController {

	@Autowired
	private ReclamationServiceImp reclamationServiceImp;
	
	
	
	
    //http://localhost:8083/SpringMVC/servlet/reclamation/addrec/parents_id/kindergarten_id
	@PostMapping("/addrec/{parents_id}/{kindergarten_id}")
	@ResponseBody
	public String addRec(@RequestBody Reclamation Rec,@PathVariable("parents_id")Long parents_id,@PathVariable("kindergarten_id")Long kindergarten_id) {
		Rec.setAnswer(null);
		List<Reclamation>re=reclamationServiceImp.retrieveAllReclamation();
	    List<Reclamation>r=re.stream().filter(x->x.getAnswer()==null&&x.getParents().getId()==parents_id).collect(Collectors.toList());
				if(r.isEmpty())
				{
						reclamationServiceImp.addReclamation(Rec,parents_id,kindergarten_id);	
						return "succs";
				}
		
		return "non";
	
	}
	
	
	
	//http://localhost:8083/SpringMVC/servlet/reclamation/delete/id/admin_id
	@DeleteMapping("/delete/{id}/{admin_id}")
	@ResponseBody
	public String deleteRec(@PathVariable("id") Long id,@PathVariable("admin_id")Long admin_id) {
		List<Reclamation>reclamations=reclamationServiceImp.retrieveAllReclamation();
		for(Reclamation r:reclamations)
			if(r.getId()==id){
		reclamationServiceImp.deleteReclamation(id,admin_id);
		return "Record deleted succesfully";}
		
		return "not existe";
	}


	//http://localhost:8083/SpringMVC/servlet/reclamation/id
	@GetMapping("/{id}")
	@ResponseBody
	public Optional<Reclamation> retrieveRec(@PathVariable Long id) {
		return reclamationServiceImp.retrieveReclamation(id);
	}

	
	
	//http://localhost:8083/SpringMVC/servlet/reclamation/all
	@GetMapping("/all")
	@ResponseBody
	public List<Reclamation> retrieveRec() {
		return reclamationServiceImp.retrieveAllReclamation();
	}

	
}