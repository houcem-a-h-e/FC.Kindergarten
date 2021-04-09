package tn.esprit.spring.sms;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestSmsOffer {
	private String phoneNumber;
	private String message;
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public RequestSmsOffer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequestSmsOffer(@JsonProperty("phone") String phoneNumber,@JsonProperty("message") String message) {
		super();
		this.phoneNumber = phoneNumber;
		this.message = message;
	}
	@Override
	public String toString() {
		return "RequestSmsOffer [phoneNumber=" + phoneNumber + ", message=" + message + "]";
	}
	

}
