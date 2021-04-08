package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Adminstrator;
import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.service.AdminstratorServiceImp;
import tn.esprit.spring.service.ReclamationServiceImp;

@RestController
@RequestMapping("/Admin")
public class AdminstratorController {
	@Autowired
	private ReclamationServiceImp reclamationServiceImp;
	@Autowired
	private AdminstratorServiceImp AdServImp;
	
	
	//http://localhost:8083/SpringMVC/servlet/Admin/addAdmin
	@PostMapping("/addAdmin")
	@ResponseBody
	public Adminstrator addAdmin(@RequestBody Adminstrator Ad) {
		Adminstrator AD = AdServImp.addAdmin(Ad);
		return AD;
	}
	
	//http://localhost:8083/SpringMVC/servlet/Admin/all
	@GetMapping("/all")
	@ResponseBody
	public List<Adminstrator> retrieveAdmin() {
		return AdServImp.retrieveAllAdmin();
	}
	
	//http://localhost:8083/SpringMVC/servlet/Admin/updateRec/id/admin_id
	@PutMapping("/updateRec/{id}/{admin_id}")
	@ResponseBody
	public Reclamation updateRec(@RequestBody Reclamation Rec ,@PathVariable("id")Long id,@PathVariable("admin_id")Long admin_id) {
		List<Reclamation> reclamation =reclamationServiceImp.retrieveAllReclamation();
		String answer=Rec.getAnswer();
		for(Reclamation rc:reclamation)
			if(rc.getId()== id && rc.getAnswer()==null ){
				rc.setAnswer(answer);
		reclamationServiceImp.updateReclamation(rc,id,admin_id);
		return rc;}
		
		return null;
		
	}

}
