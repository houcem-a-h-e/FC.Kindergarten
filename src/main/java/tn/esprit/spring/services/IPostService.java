package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.Post;

public interface IPostService {
	List<Post> retrieveAllPosts();
	Post addPost(Post t);
	void deletePost(Long id_Post);
	Post updatePost(Post t);
	Post retrievePost(Long id_Post);
	List<Post> retrievePostByDescription(String description_Post);
}
