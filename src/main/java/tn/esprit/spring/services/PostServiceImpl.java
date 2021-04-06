package tn.esprit.spring.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import tn.esprit.spring.entity.Post;
import tn.esprit.spring.repository.PostRepository;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PostServiceImpl implements IPostService {
   @Autowired
   PostRepository PostRepository;
   private static final Logger l = LogManager.getLogger(PostServiceImpl.class);
	@Override
   public List<Post> retrieveAllPosts(){
		List<Post> Posts=PostRepository.findAll();
		return Posts;
	}
	@Override
	public Post addPost(Post t) {
		PostRepository.save(t);
		return t;
	}
	@Override
	public void deletePost(Long id_Post) {
		PostRepository.deleteById(id_Post);	
	}
	@Override
	public Post updatePost(Post t) {
		PostRepository.save(t);
		return t;
	}
	@Override
	public Post retrievePost(Long id_Post) {
		 Post t=PostRepository.findById(id_Post).orElse(null);
		return t;
	}
	@Override
	public List<Post> retrievePostByDescription(String description_Post) {
		List<Post> Posts=PostRepository.retrievePostByText(description_Post);
		return Posts;
	}
	

}
