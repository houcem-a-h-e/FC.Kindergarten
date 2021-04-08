package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Kindergarten;
import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.entity.Users;
import tn.esprit.spring.mail.SendMail;
import tn.esprit.spring.repository.AdministratorRepository;
import tn.esprit.spring.repository.KindergartenRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
public class AdminstratorService implements IAdminstratorService {

	@Autowired
	AdministratorRepository administratorRepository;
	@Autowired
	KindergartenRepository kindergartenRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	private PasswordEncoder bcryptEncoder;
	@Autowired
	SendMail sendMail;
	public void KindergartenRegistrationConfirmation(Long id) {	
		List<Kindergarten> kindergartens =(List<Kindergarten>) kindergartenRepository.findAll();
	

		for(Kindergarten i:kindergartens)
			if(i.getId()==id)
			{i.setConfirmation(true);
		    i.setPassword(bcryptEncoder.encode(i.getPassword()));
			Users u=new Users(i.getEmail(),i.getPassword(),i.getRole());
		    userRepository.save(u);
			kindergartenRepository.save(i);
			sendMail.send(i.getEmail());

			
			}
	}







	

}
