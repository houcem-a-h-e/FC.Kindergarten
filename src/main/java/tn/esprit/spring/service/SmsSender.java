package tn.esprit.spring.service;

import tn.esprit.spring.entity.Offer;
import tn.esprit.spring.sms.RequestSmsOffer;

public interface SmsSender {
	void sendSms(RequestSmsOffer smsRequest);
	void sendingSms(Offer offerrequest);
	void send(String phoneNmber, String mssage);
}
