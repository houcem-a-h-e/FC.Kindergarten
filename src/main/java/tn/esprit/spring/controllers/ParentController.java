package tn.esprit.spring.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import tn.esprit.spring.entity.JwtRequest;
import tn.esprit.spring.entity.Kindergarten;
import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.entity.UserDto;
import tn.esprit.spring.entity.parentType;
import tn.esprit.spring.mail.SendMail;
import tn.esprit.spring.service.ChildService;
import tn.esprit.spring.service.IDelegateService;
import tn.esprit.spring.service.IParentService;
import tn.esprit.spring.service.JwtUserDetailsService;
import tn.esprit.spring.service.KindergartenService;
@RestController

@RequestMapping("/api")
public class ParentController {

	@Autowired
	IParentService iParentService;
	
	@Autowired
	SendMail sendMail;
	@Autowired
	JwtAuthenticationController jwt;
	@Autowired
	KindergartenService kindergartenService;
	
	@Autowired
	private JwtUserDetailsService userDetailsService;
	@Autowired
	private PasswordEncoder bcryptEncoder;
	@Autowired
	ChildService childService;
	@Autowired
	IDelegateService iDelegateService;
	
	
    //final	IParentService iParentService;
	Logger logger=LoggerFactory.getLogger(ParentController.class);
	
	@GetMapping("/parent/{id}")
	public Parent afficher (@PathVariable("id") String id){
		return  iParentService.retrieveParent(id);
	}
	//@Secured(value="ROLE_Parent")
	@GetMapping("/parent/all")
	public List<Parent> afficherAllParent (){
		return  iParentService.retrieveAllParent();
	}
	
	@PostMapping("/parent/add")
	public String addParent(@RequestBody Parent parent) throws Exception{
		logger.info("test"+parent);
		List<Parent>parents=iParentService.retrieveAllParent();
		String email = parent.getEmail();
		String password=parent.getPassword();
		String msg;
		List<Parent> l= parents.stream().filter(x->x.getEmail().equals(email)).collect(Collectors.toList());
				if(l.isEmpty())
				{
					UserDto user=new UserDto(parent.getEmail(),parent.getPassword(),parent.getRole());
					userDetailsService.save(user);
					parent.setPassword(bcryptEncoder.encode(parent.getPassword()));
					parent.setPatype(parentType.ordinaryParent);
					iParentService.addParent(parent);
					
					sendMail.send(email);
					return "succs";
				}
				    return "parent existe";
	
	}
	
	
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
	
	@GetMapping("/parent/auth/{email}/{password}")
	public String auth(@PathVariable("email")String email,@PathVariable("password") String password) throws Exception {
		JwtRequest request=new JwtRequest(email,password);
		String j=jwt.createAuthenticationToken(request);
	
	return j;
	}
	
	@PutMapping("/parent/addChild/{idp}")
	public String addchild(@RequestBody Child c,@PathVariable("idp")Long idp){
		childService.addChild(c);
		iParentService.addChild(c, idp);
		
		return "succs";
	}
	@PostMapping("/parent/demandedelegate/{idk}/{idp}")
	public String delegate(@PathVariable("idk")Long idp,@PathVariable("idp")Long idk){
		iDelegateService.addDelegate(iParentService.demandedelegate(idk, idp));
		return "succs";
	}
	@PutMapping("/parent/vote/{idk}/{email}")
	public String votedelegate(@PathVariable("idk")Long idk,/*@PathVariable("idp")Long idp,*/@PathVariable("email")String email){
		Kindergarten k=	kindergartenService.retrieveKindergarten(idk);
		HashMap<String, Integer> vote=k.getVote();

		vote.put(email, vote.get(email)+1);

			k.setVote(vote);
		kindergartenService.updateKindergarten(k);
	
		return "vote succs";
	}
}
