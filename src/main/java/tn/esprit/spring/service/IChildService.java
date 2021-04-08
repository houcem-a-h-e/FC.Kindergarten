package tn.esprit.spring.service;

import java.util.Optional;

import tn.esprit.spring.entity.Child;

public interface IChildService {
	
	java.util.List<Child> retrieveAllChild();
	Child addChild(Child c);
	void deleteChild(String id);
	Child updateChild(Child c);
	Optional<Child> retrieveChild(String id);

}
