package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.Parent;



public interface IParentService {

	List<Parent> retrieveAllParents();
	Parent addParent(Parent p);
	void deleteParent(String id);
	Parent updateParent(Parent p);
	Parent retrieveParent(String id);
	List<String> getAllPostsByParentId(String idparent);
}
