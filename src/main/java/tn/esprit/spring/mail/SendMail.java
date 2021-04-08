package tn.esprit.spring.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class SendMail {
	
	private String EMAIL_SUBJECT = "Mail verification";
	private String EMAIL_BODY = "http://localhost:8082/congrats";
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	
	public void send(String to){
		MimeMessage message = javaMailSender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(to);
			helper.setSubject(EMAIL_SUBJECT);
			helper.setText(EMAIL_BODY);
			javaMailSender.send(message);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
