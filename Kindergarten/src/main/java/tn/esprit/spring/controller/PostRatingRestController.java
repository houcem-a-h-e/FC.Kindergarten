package tn.esprit.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.entity.Post;
import tn.esprit.spring.entity.PostRating;
import tn.esprit.spring.repository.ParentRepository;
import tn.esprit.spring.repository.PostRepository;
import tn.esprit.spring.repository.RatingPostRepository;
import tn.esprit.spring.services.IParentService;
import tn.esprit.spring.services.IPostService;
import tn.esprit.spring.services.IRatingPostService;

@RestController
@Validated
public class PostRatingRestController {
	@Autowired
	ParentRepository pr;
	@Autowired
	PostRepository postR;
	@Autowired
	IParentService parentService;
	@Autowired
	IRatingPostService ratingPostService;
	@Autowired
	RatingPostRepository ratingP;
	@Autowired
	IPostService postService;
	
	@PostMapping("/addpostRating")
	@ResponseBody
	public PostRating addRatingToPost(@Valid @RequestBody PostRating ratingpost,@RequestParam Long post_id,@RequestParam Long parent_id) { 
	   
		PostRating newRatingPost= new PostRating();
		Parent parent=parentService.retrieveParent(parent_id);
		Post post=postService.retrievePost(post_id);
		newRatingPost.setPost(post);
		newRatingPost.setParent(parent);
        newRatingPost.setRatingP(ratingpost.getRatingP());
		ratingPostService.addRatingPost(newRatingPost);  
		ratingP.save(newRatingPost);
		return newRatingPost;
	}
}
