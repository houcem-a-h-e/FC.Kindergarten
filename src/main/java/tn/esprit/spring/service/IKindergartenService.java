package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Kindergarten;

public interface IKindergartenService {
	java.util.List<Kindergarten> retrieveAllKindergarten();
	Kindergarten addKindergarten(Kindergarten k);
	void deleteKindergarten(String id);
	Kindergarten updateKindergarten(Kindergarten k);
	Optional<Kindergarten> retrieveKindergarten(String id);
	//mes methodes
	List<String> getAllemailsParentByKindergarten(@Param("kidergartenId") Integer kindergartenId );
	void  affecterOfferAkindergarten(String offerId, String kinderId);
}
