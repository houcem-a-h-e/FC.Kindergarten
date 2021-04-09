package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.PostRating;
import tn.esprit.spring.repository.ParentRepository;
import tn.esprit.spring.repository.PostRepository;
import tn.esprit.spring.repository.RatingPostRepository;

@Service
public class RatingPostServiceImp implements IRatingPostService{

	@Autowired
	ParentRepository pr;
	@Autowired
	PostRepository postR;
	@Autowired
	RatingPostRepository ratingP;
	
	@Override
	public PostRating addRatingPost(PostRating ratingpost) {
		// TODO Auto-generated method stub
	ratingP.save(ratingpost);
		return ratingpost;
	}

}
