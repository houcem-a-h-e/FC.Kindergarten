package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entity.Reclamation;

public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {

}
