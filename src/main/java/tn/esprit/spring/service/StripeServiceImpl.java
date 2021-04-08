package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.PaymentIntent;
import com.stripe.model.Token;


import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.payment.Payment;
import tn.esprit.spring.repository.ParentRepository;

@Service
public class StripeServiceImpl {
	@Value("$stripe.secret.key")
	String secretkey;
	@Autowired
	ParentRepository pr;
	
	//test de creation d'un client
		public String createCustomer(long parentId) throws StripeException{
			Stripe.apiKey="sk_test_51IbUHICJg3bNCVAd3lKPf11Vn3s0sZ11ykgcupcHYr2xiupDLhStHRersE6hmqCxshqhTML3RI4UNkxkwrZID4zq001X0qb1Fm";
			/*Parent p = pr.findById(parentId).get();
			Map<String, Object> params = new HashMap<>();
			params.put("description","my first test to create custumer Mr ");
			params.put("email", p.getEmail());
			Customer customer = Customer.create(params);*/
			Customer customer = Customer.retrieve("cus_JGWP3q01D2b6xt");
			Map<String, Object> cardParams = new HashMap<>();
			cardParams.put("number", "4242424242424242");
			cardParams.put("exp_month", "11");
			cardParams.put("exp_year", "2024");
			cardParams.put("cvc", "123");
			
			Map<String, Object> tokenParam = new HashMap<>();
			tokenParam.put("card", cardParams);
			Token token = Token.create(tokenParam);
			
			Map<String, Object> source = new HashMap<>();
			source.put("source", token.getId());
			
			customer.getSources().create(source);
			
			Map<String, Object> param = new HashMap<>();
			List<String> paymentMethodTypes = new ArrayList<>();
			paymentMethodTypes.add("card");
			param.put("amount", "90000");
			param.put("description", "test of payment ");
			param.put("currency", "usd");
			param.put("payment_method_types", paymentMethodTypes);
			
			
			PaymentIntent paymentintent = PaymentIntent.create(param);
			
			Map<String, Object> params = new HashMap<>();
			params.put("payment_method", "pm_card_visa");
			paymentintent.confirm(params);
			
			
			
				return token.getId();
				
		}
		
		public String paymentIntent(Payment p) throws StripeException{
			Stripe.apiKey="sk_test_51IbUHICJg3bNCVAd3lKPf11Vn3s0sZ11ykgcupcHYr2xiupDLhStHRersE6hmqCxshqhTML3RI4UNkxkwrZID4zq001X0qb1Fm";
			Map<String, Object> param = new HashMap<>();
			List<String> paymentMethodTypes = new ArrayList<>();
			paymentMethodTypes.add("card");
			param.put("amount", "100000000");
			param.put("description", p.getDescription());
			param.put("currency", "usd");
			param.put("payment_method_types", paymentMethodTypes);
			
			PaymentIntent paymentintent = PaymentIntent.create(param);
			
			return paymentintent.getId();
			
			
		}
		
		@Transactional
		public void pay(long idParent , String carta , int expMonth, int expYear,String cvc ) throws StripeException{
			Stripe.apiKey="sk_test_51IbUHICJg3bNCVAd3lKPf11Vn3s0sZ11ykgcupcHYr2xiupDLhStHRersE6hmqCxshqhTML3RI4UNkxkwrZID4zq001X0qb1Fm";
			
			Parent p = pr.findById(idParent).get();
			Map<String, Object> params = new HashMap<>();
			params.put("description","phase1 : Spring ");
			params.put("email", p.getEmail());
			Customer customer = Customer.create(params);
			Map<String, Object> cardParams = new HashMap<>();
			cardParams.put("number", carta);
			cardParams.put("exp_month", expMonth);
			cardParams.put("exp_year", expYear);
			cardParams.put("cvc", cvc);
			
			Map<String, Object> tokenParam = new HashMap<>();
			tokenParam.put("card", cardParams);
			Token token = Token.create(tokenParam);
			
			Map<String, Object> source = new HashMap<>();
			source.put("source", token.getId());
			
			customer.getSources().create(source);
			
			Map<String, Object> param = new HashMap<>();
			List<String> paymentMethodTypes = new ArrayList<>();
			paymentMethodTypes.add("card");
			param.put("amount", "90000");
			param.put("description", "test of payment ");
			param.put("currency", "usd");
			param.put("payment_method_types", paymentMethodTypes);
			
			
			PaymentIntent paymentintent = PaymentIntent.create(param);
			
			Map<String, Object> methodParam = new HashMap<>();
			methodParam.put("payment_method", "pm_card_visa");
			paymentintent.confirm(methodParam);
			
			
		}
		
		
		
}
