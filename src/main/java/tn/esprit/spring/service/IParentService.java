package tn.esprit.spring.service;

import java.util.Optional;

import tn.esprit.spring.entity.Parent;

public interface IParentService {
	
	java.util.List<Parent> retrieveAllParent();
	Parent addParent(Parent p);
	void deleteParent(String id);
	void abonneKindergarten(Long idP,Long idK);
	Parent updateParent(Parent p);
	Optional<Parent> retrieveParent(String id);

}
