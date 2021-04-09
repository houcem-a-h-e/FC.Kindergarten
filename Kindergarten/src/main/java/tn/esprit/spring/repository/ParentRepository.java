package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Parent;

@Repository
public interface ParentRepository extends JpaRepository<Parent,Long>{

}
