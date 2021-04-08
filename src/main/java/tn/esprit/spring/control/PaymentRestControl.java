package tn.esprit.spring.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stripe.exception.StripeException;

import tn.esprit.spring.payment.Payment;
import tn.esprit.spring.service.StripeServiceImpl;

@RestController
public class PaymentRestControl {
	@Autowired
	StripeServiceImpl ss;
	
	
	@PostMapping("/customer/{parentId}")
	@ResponseBody
	public String createCustomer(@PathVariable("parentId") long parentid ) throws StripeException{
	 	String idcustomer = ss.createCustomer(parentid);
	 	return idcustomer;
	}
	
	@PostMapping("/payment")
	public String paymentIntentControl( Payment p) throws StripeException{
		return ss.paymentIntent(p);
		
	}
	@PostMapping("/pay/{id}/{carta}/{expMonth}/{expYear}/{cvc}")
	public void pay(@PathVariable("id") long idParent ,@PathVariable("carta") String carta ,@PathVariable("expMonth")  int expMonth,
			@PathVariable("expYear")  int expYear,
			@PathVariable("cvc") String cvc ) throws StripeException{
		ss.pay(idParent, carta, expMonth, expYear, cvc);
	}

}
