package tn.esprit.spring;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entity.Offer;
import tn.esprit.spring.service.OfferServiceImpl;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringProjectApplicationTests {
	@Autowired
	OfferServiceImpl os;
	@Test
	public void testRetrieveAllOffers() {
		os.retrieveAllOffers();
	}
	@Test
	public void testAddOffer() throws ParseException {

	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	@SuppressWarnings("unused")
	Date date = dateFormat.parse("2015-03-23");
	Offer o = new Offer();
	os.addOffer(o);
	}
	
}