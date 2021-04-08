package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Satisfaction;

public interface ISatisfactionService {
	
	List<Satisfaction> retrieveAllSatisfactions();

	//Satisfaction updateSatisfaction(Satisfaction Satis);

	Satisfaction retrieveSatisfaction(Long id);


	Satisfaction addSatisfaction(Satisfaction Satis, Long parents_id);
}
