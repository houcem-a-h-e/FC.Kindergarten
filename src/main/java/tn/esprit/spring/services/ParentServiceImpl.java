package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.entity.Post;
import tn.esprit.spring.repository.ParentRepository;
import tn.esprit.spring.repository.PostRepository;
@Service
public class ParentServiceImpl implements IParentService{

	private static final Logger l = LoggerFactory.getLogger(MessageServiceImpl.class);
	
	@Autowired
	ParentRepository parentRepository;
	@Autowired
	PostRepository postRepository;
	
	@Override
	public List<Parent> retrieveAllParents() {
		// TODO Auto-generated method stub
		List<Parent> parents =(List<Parent>) parentRepository.findAll();
		for (Parent parent : parents) {
	l.info("user: " + parent);
		}
		return parents;
	}

	@Override
	public Parent addParent(Parent p) {
		// TODO Auto-generated method stub
		return parentRepository.save(p);
	}

	@Override
	public void deleteParent(String id) {
		// TODO Auto-generated method stub
		parentRepository.deleteById(Long.parseLong(id));
	}

	@Override
	public Parent updateParent(Parent p) {
		// TODO Auto-generated method stub
		return parentRepository.save(p);
	}

	@Override
	public Parent retrieveParent(String id) {
		// TODO Auto-generated method stub
		Parent p = parentRepository.findById(Long.parseLong(id)).orElse(null);
		return p;
	}
	@Transactional
	public void affecterunpostauparent(String idpost, String idparent) {
		Parent parent = parentRepository.findById(Long.parseLong(idpost)).get();
		Post post= postRepository.findById(Long.parseLong(idparent)).get();
		post.setParent(parent);
		postRepository.save(post);
		}
	
	 public List <String> getAllPostsByParentId (String idparent){
		Parent parent= parentRepository.findById(Long.parseLong(idparent)).get();
		 List<String> result= new ArrayList<String>();
		 for (Post post:parent.getPost() ) {  
			 result.add(post.gettextPost());
		 }
		 return result;
		 
	} 
	

}
