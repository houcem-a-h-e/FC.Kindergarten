package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Kindergarten;
import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.repository.KindergartenRepository;
import tn.esprit.spring.repository.ParentRepository;
@Service
public class ParentService implements IParentService {

	@Autowired
	ParentRepository parentRepository;
	@Autowired
	KindergartenRepository kindergartenRepository;
	
	public List<Parent> retrieveAllParent() {
		List<Parent> parents=(List<Parent>) parentRepository.findAll();
		return parents;
	}

	public Parent addParent(Parent p) {
		return parentRepository.save(p);
	}

	public void deleteParent(String id) {
		parentRepository.deleteById(Long.parseLong(id));
	}

	public Parent updateParent(Parent p) {
		return parentRepository.save(p);
	}

	public Optional<Parent> retrieveParent(String id) {

		//Parent p = parentRepository.findone(Long.parseLong(id));
		//return parentRepository.findById(Long.parseLong(id));
		Optional<Parent> p =parentRepository.findById(Long.parseLong(id));
		if(p.isPresent())
			return p;
		else 
			return null;

	}

	@Transactional
	public void abonneKindergarten(Long idP,Long idK) {
   		Kindergarten k = kindergartenRepository.findById(idK).get();     
		Parent p= parentRepository.findById(idP).get();
		p.setKindergarten(k);
		parentRepository.save(p);
	//	k.getParents().add(p);
	//kindergartenRepository.save(k);
	}

	@Override
	public List<Kindergarten> findkinder() {
		return (List<Kindergarten>) kindergartenRepository.findAll();
	}


}
