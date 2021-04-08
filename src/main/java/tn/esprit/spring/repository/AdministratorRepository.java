package tn.esprit.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Administrator;
import tn.esprit.spring.entity.Kindergarten;
import tn.esprit.spring.entity.Parent;

@Repository
public interface AdministratorRepository extends CrudRepository<Administrator, Long> {
	//@Query(value= "select p from Parent where p kindergarten_id=?1",nativeQuery = true)
	//List<Parent> findParentfromKindergarten(Long id);

}
