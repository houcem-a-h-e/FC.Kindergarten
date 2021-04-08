package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entity.Offers;

public interface OffersRepository extends JpaRepository<Offers,Long> {

}
