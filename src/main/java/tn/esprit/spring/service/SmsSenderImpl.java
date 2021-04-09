package tn.esprit.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

import tn.esprit.spring.entity.Offer;
import tn.esprit.spring.sms.RequestSmsOffer;
import tn.esprit.spring.sms.TwilioConfiguration;
@Service
public class SmsSenderImpl implements SmsSender {
	@Autowired
	TwilioConfiguration twilioconfig;
	
	@Override
	@Transactional
	public void sendSms(RequestSmsOffer smsRequest){
		MessageCreator creator = Message.creator( new PhoneNumber(smsRequest.getPhoneNumber()) ,
												  new PhoneNumber(twilioconfig.getTrialNumber()), 
												  smsRequest.getMessage());
		 
		creator.create();
	}

	@Override
	@Transactional
	public void sendingSms(Offer offerrequest) {
		// TODO Auto-generated method stub
		MessageCreator creator = Message.creator(new PhoneNumber(offerrequest.getPhoneNumber()) ,
												  new PhoneNumber(twilioconfig.getTrialNumber()), 
												  offerrequest.getMessage());
		creator.create();
	}
	
}
