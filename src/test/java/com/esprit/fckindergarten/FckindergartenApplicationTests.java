package com.esprit.fckindergarten;


//import java.text.SimpleDateFormat;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entity.Adminstrator;
import tn.esprit.spring.entity.Kindergarten;
import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.entity.Satisfaction;
import tn.esprit.spring.service.AdminstratorServiceImp;
import tn.esprit.spring.service.KindergartenServiceImp;
import tn.esprit.spring.service.ParentServiceImp;
import tn.esprit.spring.service.ReclamationServiceImp;
import tn.esprit.spring.service.SatisfactionServiceImp;



@RunWith(SpringRunner.class)
@SpringBootTest
public class FckindergartenApplicationTests {

	@Autowired
	AdminstratorServiceImp AdServ;
	@Autowired
	ParentServiceImp ParSerImp;
	@Autowired
	ReclamationServiceImp reclamserv;
	@Autowired
	SatisfactionServiceImp satisServImp;
	@Autowired
	KindergartenServiceImp KgServImp;
	//test reclamation 
	@Test
	public void testretRieveAllReclamation() {
		reclamserv.retrieveAllReclamation();
	}
	@Test
	public void testAddReclamation(Reclamation Rec,Long kindergarten_id,Long parents_id){
		//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		reclamserv.addReclamation(Rec, kindergarten_id,parents_id);
	}
	@Test
	public void testDeleteReclamation(Long id,Long parents_id){
		reclamserv.deleteReclamation(id,parents_id);
	}
	@Test
	public void testUpdateReclamation(Reclamation Rec,Long id,Long admin_id){
		reclamserv.updateReclamation(Rec, id,admin_id);
	}
	@Test
	public void testRetrieveReclamation(Long id) {
		reclamserv.retrieveReclamation(id);
	}

	//test satisfaction
	@Test
	public void testretRieveAllSatisfaction() {
		satisServImp.retrieveAllSatisfactions();
	}
	@Test
	public void testAddSatisfaction(Satisfaction Satis,Long parents_id){
		//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		satisServImp.addSatisfaction(Satis,parents_id);
	}
	//@Test
	//public void testDeleteSatisfaction(Long id){
		//satisServImp.deleteSatisfaction(id);;
	//}
	/*@Test
	public void testUpdateSAtisfaction(Satisfaction Satis){
		satisServImp.updateSatisfaction(Satis);
	}*/
	@Test
	public void testRetrieveSatisfaction(Long id) {
		satisServImp.retrieveSatisfaction(id);
	}
	//test Admin
	@Test
	public void testAddAdmin(Adminstrator Ad){
		AdServ.addAdmin(Ad);
	}
	@Test
	public void testretRieveAllAdmin(){
		AdServ.retrieveAllAdmin();
	}
	@Test
	public void testretrieveAdminById(Long id){
		AdServ.retrieveAdminById(id);
	}
	//test Parents
	@Test
	public void testAddParent(Parent PR){
		ParSerImp.addParent(PR);
	}
	@Test
	public void testretRieveAllParents(){
		ParSerImp.retrieveAllParent();
	}
	@Test
	public void testretriveParentById(Long id){
		ParSerImp.retrieveParent(id);
	}
	//test Kindergarten
	@Test
	public void testAddKg(Kindergarten Kg){
		KgServImp.AddKg(Kg);
	}
	@Test
	public void testretrieveAllKg(){
		KgServImp.RetrieveAllKg();
	}
	@Test
	public void testretrieveKgById(Long id){
		KgServImp.RetrieveKgById(id);
	}
}
