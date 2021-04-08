package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Parent;


@Repository
public interface ParentRepository extends CrudRepository<Parent, Long> {
	//@Query("select p from Parent p where p.id= ?1")
   // Parent	findone(Long id);

}
