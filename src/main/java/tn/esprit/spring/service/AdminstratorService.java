package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Kindergarten;
import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.repository.AdministratorRepository;
import tn.esprit.spring.repository.KindergartenRepository;

@Service
public class AdminstratorService implements IAdminstratorService {

	@Autowired
	AdministratorRepository administratorRepository;
	@Autowired
	KindergartenRepository kindergartenRepository;
	
	public void KindergartenRegistrationConfirmation(Long id) {	
		List<Kindergarten> kindergartens =(List<Kindergarten>) kindergartenRepository.findAll();
		for(Kindergarten i:kindergartens)
			if(i.getId()==id)
			{i.setConfirmation(true);
			kindergartenRepository.save(i);
			}
	}

	public List<Kindergarten> findallkindergartens() {
		return (List<Kindergarten>) kindergartenRepository.findAll();
	}

	public List<Parent> findParentfromKindergarten(Long id) {

		return administratorRepository.findParentfromKindergarten(id);
	}



	

}
