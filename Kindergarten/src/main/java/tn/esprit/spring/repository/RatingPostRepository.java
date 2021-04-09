package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.PostRating;

@Repository
public interface RatingPostRepository extends JpaRepository<PostRating, Integer>{

}
