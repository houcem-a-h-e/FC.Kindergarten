package tn.esprit.spring.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.service.SmsSenderImpl;
import tn.esprit.spring.sms.RequestSmsOffer;

@RestController
public class SmsRestControl {
	@Autowired
	private SmsSenderImpl ss;
	@PostMapping("/testsms")
	public void sendSms(@RequestBody RequestSmsOffer smsRequest){
		ss.sendSms(smsRequest);
	}

}
