package tn.esprit.spring.service;

import java.util.Optional;

import tn.esprit.spring.entity.Kindergarten;
import tn.esprit.spring.entity.Parent;

public interface IKindergartenService {
	java.util.List<Kindergarten> retrieveAllKindergarten();
	Kindergarten addKindergarten(Kindergarten k);
	void deleteKindergarten(String id);
	Kindergarten updateKindergarten(Kindergarten k);
	Optional<Kindergarten> retrieveKindergarten(String id);

}
