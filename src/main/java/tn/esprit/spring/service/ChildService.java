package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Child;
import tn.esprit.spring.repository.ChildRepository;

@Service
public class ChildService implements IChildService{
	@Autowired
	ChildRepository childRepository;

	public List<Child> retrieveAllChild() {
		return (List<Child>) childRepository.findAll();
	}

	public Child addChild(Child c) {
		return childRepository.save(c);
	}

	public void deleteChild(String id) {
		childRepository.deleteById(Long.parseLong(id));;
		
	}

	public Child updateChild(Child c) {
		return childRepository.save(c);
	}

	public Optional<Child> retrieveChild(String id) {
		return childRepository.findById(Long.parseLong(id));
	}

}
