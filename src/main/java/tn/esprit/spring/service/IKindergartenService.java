package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Kindergarten;

public interface IKindergartenService {

	
	List<Kindergarten> RetrieveAllKg();
	
	Kindergarten RetrieveKgById(Long id);

	Kindergarten AddKg(Kindergarten Kg);
	

}
