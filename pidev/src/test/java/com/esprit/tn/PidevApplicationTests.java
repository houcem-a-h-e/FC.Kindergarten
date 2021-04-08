package com.esprit.tn;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.tn.services.EventService;
@RunWith(SpringRunner.class)
@SpringBootTest
class PidevApplicationTests {
	@Autowired 
	EventService e;
   @Test
   public void testRetrieveAllEvents(){
     e.retrieveAllEvents(); }
	 @Test
	void contextLoads() {
	}
	//@Test
	//public void testaddEvents throw exception (){
		
	

}
