package tn.esprit.spring.controllers;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Satisfaction;
import tn.esprit.spring.service.SatisfactionServiceImp;

@RestController
@RequestMapping("/satisfaction")
public class satisfactionController {

	@Autowired
	SatisfactionServiceImp satisServImp;
	
	
	//http://localhost:8083/SpringMVC/servlet/satisfaction/addsatis/parent_id
	@PostMapping("/addsatis/{parent_id}")
	@ResponseBody
	public String addSatis(@RequestBody Satisfaction Satis,@PathVariable("parent_id")Long parent_id) throws ParseException {
		List<Satisfaction>s=satisServImp.retrieveAllSatisfactions();
		Date d= new Date();    
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 List<Satisfaction> o=new ArrayList<>();
	    Date p;
	    Date f;
	
		int m=d.getMonth();
		int m1=d.getMonth()+1;
		
		String start= "2021-"+Integer.toString(m)+"-31";
		String end= "2021-"+Integer.toString(m1)+"-31";

		p=sdf.parse(start);
		f=sdf.parse(end);
		//int D =new Date().getYear();
		//System.out.println(D);
		/*
	    Calendar date =Calendar.getInstance();
		//date.set(2021,4,6,16,44,00);
		System.out.println(date.toInstant());
		date.add(Calendar.HOUR, 24);
		date.roll(Calendar.MONTH, 01);
		Calendar D1 = Calendar.getInstance();
		System.out.println(date.toInstant());
		
		 o=s.stream().filter(x -> (x.getDate().after(date)) && ( x.getDate().before(D1))&& x.getParent().getId()==parent_id) .collect(Collectors.toList());
		 if(o.isEmpty()){
			 satisServImp.addSatisfaction(Satis,parent_id);


	   return "succs";
		 }
		   return "deja ajouter cette mois";
		   }*/
          
		   o=s.stream().filter(x -> (x.getDate().after(p)) && ( x.getDate().before(f))&& x.getParent().getId()==parent_id) .collect(Collectors.toList());
			 if(o.isEmpty()){
				 satisServImp.addSatisfaction(Satis,parent_id);


		   return "succs";
			 }
			   return "deja ajouter cette mois";

		}
	
	
	
	//http://localhost:8083/SpringMVC/servlet/satisfaction/ret/id
	@GetMapping("/ret/{id}")
	@ResponseBody
	public Satisfaction retrieveSatis(@PathVariable("id") Long id) {
		return satisServImp.retrieveSatisfaction(id);
	}
	
	//http://localhost:8083/SpringMVC/servlet/satisfaction/allSatis
	@GetMapping("/allSatis")
	@ResponseBody
	public List<Satisfaction> retrieveAllSatis() {
		return satisServImp.retrieveAllSatisfactions();
		
	}
	
	/*@DeleteMapping("/del/{id}")
	@ResponseBody
	public String deleteSatis(@PathVariable("id") Long id) {
		List<Satisfaction> satisfactios=satisServImp.retrieveAllSatisfactions();
		for(Satisfaction s:satisfactios)
			if(s.getId()==id){
		satisServImp.deleteSatisfaction(id);
		return "Record deleted succesfully";}
		
		return "not existe";
	}*/
	/*@PutMapping("/updateSatis")
	@ResponseBody
	public Satisfaction updateSatis(@RequestBody Satisfaction Satis) {
		satisServImp.updateSatisfaction(Satis);
		return Satis;
	}*/
	
}
