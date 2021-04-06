package tn.esprit.spring.controller;

import java.util.ArrayList;
import java.util.List;

import tn.esprit.spring.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.entity.Post;
import tn.esprit.spring.repository.ParentRepository;
import tn.esprit.spring.repository.PostRepository;

@RestController
public class PostRestController {
@Autowired
IPostService ps;
@Autowired
ParentRepository pr;
@Autowired

PostRepository postRepo;
//http://localhost:8080/Kindergarten/servlet/search-Posts/{textPost}
@GetMapping("/search-Posts/{textPost}")
@ResponseBody
public List<Post> searchPosts(@PathVariable("textPost") String textPost) {
List<Post> list = ps.retrievePostByDescription(textPost);
return list;
}
//http://localhost:8080/Kindergarten/servlet/retrieve-all-Posts
@GetMapping("/retrieve-all-Posts")
@ResponseBody
public List<Post> getPosts() {
List<Post> list = ps.retrieveAllPosts();
return list;
}
//http://localhost:8080/Kindergarten/servlet/add-Post
@PostMapping("/add-Post")
@ResponseBody
public Post add_Post(@RequestBody Post po) {
Post post= ps.addPost(po);
return post;
}

//http://localhost:8080/Kindergarten/servlet/remove-Post/{Post-id}
@DeleteMapping("/remove-Post/{Post-id}")
@ResponseBody
public void remove_Pose(@PathVariable("Post-id") Long id_Post) {
ps.deletePost(id_Post);
}
//http://localhost:8080/Kindergarten/servlet/modify-Post
@PutMapping("/modify-Post")
@ResponseBody
public Post modify_Post(@RequestBody Post t) {
return ps.updatePost(t);
}
//http://localhost:8080/Kindergarten/servlet/retrieve-Post/{Post-id}
@GetMapping("/retrieve-Post/{Post-id}")
@ResponseBody
public Post retrieve_Post(@PathVariable("Post-id") Long id_Post) {
Post Post = ps.retrievePost(id_Post);
return Post;
}
//http://localhost:8080/Kindergarten/servlet/addlikes/{Parent-id}/{Post-id}
@PatchMapping("/addlikes/{parent-id}/{Post-id}")
@ResponseBody
public List<Parent> addlike(@PathVariable("parent-id") Long parentId,@PathVariable("Post-id") Long postId)
{
	Parent parent=pr.findById(parentId).get();
	Post post= postRepo.findById(postId).get();
	List<Parent> result= new ArrayList<Parent>();
	 result = post.getLike();
	while(parent !=null && post !=null	&& !result.contains(parent)){
	 result.add(parent);
	 post.setLike(result);
	postRepo.save(post);}
	return result;
	/*}
	return "non";*/
}
@PatchMapping("/dislikemethodpost/{Parent-id}/{Post-id}")
@ResponseBody
public Parent dislike_method(@PathVariable("Parent-id") Long id_Parent,@PathVariable("Post-id") Long id_Post)
{
	Post post= postRepo.findById(id_Post).get();
	Parent parent=pr.findById(id_Parent).get();
	List<Parent> result= new ArrayList<Parent>();
	 result = post.getLike();
	while(parent !=null && post !=null	&& result.contains(parent)){
	 result.remove(result.indexOf(parent));
	 post.setLike(result);
	 postRepo.save(post);
	}
	return parent;
	
}
}
