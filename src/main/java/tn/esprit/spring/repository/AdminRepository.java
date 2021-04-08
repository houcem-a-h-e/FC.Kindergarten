package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entity.Adminstrator;

public interface AdminRepository extends JpaRepository<Adminstrator, Long>{

}
