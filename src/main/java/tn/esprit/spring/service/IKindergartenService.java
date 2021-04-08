package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.Kindergarten;

public interface IKindergartenService {
	java.util.List<Kindergarten> retrieveAllKindergarten();
	Kindergarten addKindergarten(Kindergarten k);
	void deleteKindergarten(String id);
	Kindergarten updateKindergarten(Kindergarten k);
	public Kindergarten retrieveKindergarten(Long id);
    public 	List<Kindergarten> findallkindergartens();


}
