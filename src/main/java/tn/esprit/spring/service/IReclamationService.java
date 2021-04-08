package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.Reclamation;

public interface IReclamationService {

	List<Reclamation> retrieveAllReclamation();

	Reclamation updateReclamation(Reclamation Rec,Long id ,Long admin_id);

	Optional<Reclamation> retrieveReclamation(Long id);

	Reclamation addReclamation(Reclamation Rec, Long parents_id, Long kindergarten_id);

	void deleteReclamation(Long id, Long admin_id);

}
