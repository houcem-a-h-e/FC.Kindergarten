package tn.esprit.spring.sms;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("twilio")
public class TwilioConfiguration {
	private String accountSid = "ACde359ec5865ae17b01424413a9584e08";
	private String authToken = "2a45ba536596e21fac48815d2910749f";
	private String trialNumber =" +17632519466";
	public String getAccountSid() {
		return accountSid;
	}
	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
	}
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	public String getTrialNumber() {
		return trialNumber;
	}
	public void setTrialNumber(String trialNumber) {
		this.trialNumber = trialNumber;
	}
	public TwilioConfiguration() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
