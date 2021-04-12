package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Kindergarten;
import tn.esprit.spring.entity.Offer;
import tn.esprit.spring.repository.KindergartenRepository;
import tn.esprit.spring.repository.OfferRepository;
@Service
public class KindergartenService implements IKindergartenService {

	@Autowired
	KindergartenRepository kindergartenRepository;
	@Autowired
	OfferRepository or;
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
   //Mes methodes(hassen )
	@Override
	@Transactional
	public List<String> getAllemailsParentByKindergarten(Integer kindergartenId) {
		List<String> list = kindergartenRepository.getAllemailsParentByKindergarten(kindergartenId);
		return list;
	}

	@Override
	public void affecterOfferAkindergarten(String offerId, String kinderId) {
		// TODO Auto-generated method stub
		Kindergarten k = kindergartenRepository.findById(Long.parseLong(kinderId)).get();
		Offer o = or.findById(Long.parseLong(offerId)).get();
		o.setKindergarten(k);
		or.save(o);
		
	}

}
