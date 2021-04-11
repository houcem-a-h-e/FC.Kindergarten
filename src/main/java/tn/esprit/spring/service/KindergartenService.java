package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Kindergarten;
import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.repository.KindergartenRepository;
@Service
public class KindergartenService implements IKindergartenService {

	@Autowired
	KindergartenRepository kindergartenRepository;
	public List<Kindergarten> retrieveAllKindergarten() {
		List<Kindergarten> k=(List<Kindergarten>) kindergartenRepository.findAll();
		return k ;
	}

	public Kindergarten addKindergarten(Kindergarten k) {
		return kindergartenRepository.save(k);
	}

	public void deleteKindergarten(String id) {
           kindergartenRepository.deleteById(Long.parseLong(id));		
	}

	public Kindergarten updateKindergarten(Kindergarten k) {
		return kindergartenRepository.save(k);
	}

	public Optional<Kindergarten> retrieveKindergarten(String id) {
		
		 Optional<Kindergarten> k =kindergartenRepository.findById(Long.parseLong(id));
		if(k.isPresent())
			return k;
		else 
			return null;
	}

}
