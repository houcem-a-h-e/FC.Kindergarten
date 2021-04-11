package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.tool.schema.spi.DelayedDropRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Child;
import tn.esprit.spring.entity.Kindergarten;
import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.entity.TimeSheetPk;
import tn.esprit.spring.entity.TimesheetDelegate;
import tn.esprit.spring.entity.Users;
import tn.esprit.spring.repository.ChildRepository;
import tn.esprit.spring.repository.DelegateRepository;
import tn.esprit.spring.repository.KindergartenRepository;
import tn.esprit.spring.repository.ParentRepository;
import tn.esprit.spring.repository.UserRepository;
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

	public Parent retrieveParent(String id) {

		
			return parentRepository.findById(Long.parseLong(id)).orElse(null);
		

	}

	@Transactional
	public void abonneKindergarten(Long idP,Long idK) {
   		Kindergarten k = kindergartenRepository.findById(idK).get();     
		Parent p= parentRepository.findById(idP).get();
		List<Kindergarten>kinder=p.getKindergarten();
		kinder.add(k);
		p.setKindergarten(kinder);
		parentRepository.save(p);
	//	k.getParents().add(p);
	 //   kindergartenRepository.save(k);
	}
	@Transactional
	@Override
	public Parent addChild(Child c,Long idP) {
		Parent p= parentRepository.findById(idP).get();
		Set<Child> childs=p.getChild();
		
		childs.add(c);
		p.setChild(childs);
		c.setParent(p);
		parentRepository.save(p);

		return p;
	}

	@Override
	public TimesheetDelegate demandedelegate(Long idk,Long idp) {
		
		
		return null;
		
		
	}




	


}
