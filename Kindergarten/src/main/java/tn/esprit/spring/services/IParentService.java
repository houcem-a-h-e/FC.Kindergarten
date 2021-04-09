package tn.esprit.spring.services;

import java.util.List;
import java.util.Set;

import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.entity.Post;



public interface IParentService {

	List<Parent> retrieveAllParents();
	Parent addParent(Parent p);
	void deleteParent(Long id);
	Parent updateParent(Parent p);
	Parent retrieveParent(Long id);
	List<String> getAllPostsByParentId(String idparent);
	Set <Post> getPostsByParentId (String parentId);
}
