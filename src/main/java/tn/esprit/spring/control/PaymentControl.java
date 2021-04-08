/*package tn.esprit.spring.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

import tn.esprit.spring.payment.Payment;
import tn.esprit.spring.service.PaymentServic;
import tn.esprit.spring.service.StripeServiceImpl;

@RestController
public class PaymentControl {
	@Autowired
	StripeServiceImpl ss;
	@PostMapping("/paymentintent")
	@ResponseBody
	public ResponseEntity<String> payment(@RequestBody Payment paymentintentdto) throws StripeException{
		PaymentIntent paymentintent = ps.paymentIntent(paymentintentdto);
		String paymentstr = paymentintent.toJson();
		return new ResponseEntity<String>(paymentstr, HttpStatus.OK);
		
	}
	@PostMapping("/confirm/{id}")
	@ResponseBody
	public ResponseEntity<String> confirm(@PathVariable("id") String id) throws StripeException{
		PaymentIntent paymentintent = ps.confirm(id);
		String paymentstr = paymentintent.toJson();
		return new ResponseEntity<String>(paymentstr, HttpStatus.OK);
		
	}
	@PostMapping("/cancel/{id}")
	@ResponseBody
	public ResponseEntity<String> cancel(@PathVariable("id") String id) throws StripeException{
		PaymentIntent paymentintent = ps.cancel(id);
		String paymentstr = paymentintent.toJson();
		return new ResponseEntity<String>(paymentstr, HttpStatus.OK);
		
	}
	@PostMapping("/customer/{parentId}")
	@ResponseBody
	public String createCustomer(@PathVariable("parentId") long parentid ) throws StripeException{
	 	String idcustomer = ss.createCustomer(parentid);
	 	return idcustomer;
	}
	
	
}
*/