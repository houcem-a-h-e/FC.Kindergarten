package tn.esprit.spring.sms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;

@Configuration
public class TwilioInitializer {
	private static final Logger l = LoggerFactory.getLogger(TwilioInitializer.class);
	@Autowired
	private  final TwilioConfiguration twilioConfiguration;
	@Autowired
	public TwilioInitializer(TwilioConfiguration twilioConfiguration) {
		super();
		this.twilioConfiguration = twilioConfiguration;
		Twilio.init(twilioConfiguration.getAccountSid(),
				twilioConfiguration.getAuthToken());
		l.info("Twilio intialized ....with account sid{}", twilioConfiguration.getAccountSid() );
	}
	
	
	
	
	
}
