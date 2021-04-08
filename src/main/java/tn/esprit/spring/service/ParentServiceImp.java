package tn.esprit.spring.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.repository.ParentRepository;

@Service
public class ParentServiceImp implements IParentService  {

	@Autowired
	ParentRepository ParentRepo;
	@Override
	public List<Parent> retrieveAllParent() {
		return (List<Parent>) ParentRepo.findAll();
	}

	@Override
	public Parent addParent(Parent PR) {
		
		return ParentRepo.save(PR);
	}

	@Override
	public Parent retrieveParent(Long id) {
		// TODO Auto-generated method stub
		return ParentRepo.findById(id).orElse(null);
	}

}
