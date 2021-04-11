package tn.esprit.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;

import tn.esprit.spring.entity.Kindergarten;

public interface IKindergartenService {
	java.util.List<Kindergarten> retrieveAllKindergarten();
	Kindergarten addKindergarten(Kindergarten k);
	void deleteKindergarten(String id);
	Kindergarten updateKindergarten(Kindergarten k);
	public Kindergarten retrieveKindergarten(Long id);
    public 	List<Kindergarten> findallkindergartens();
	public HashMap<Long, String> findParentfromKindergarten(Long id) ;



}
