package tn.esprit.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Kindergarten;


@Repository
public interface KindergartenRepository extends  CrudRepository<Kindergarten, Long> {
	@Query("SELECT p.email FROM Parent p WHERE p.kindergarten.id=: kindergartenId"  )
	List<String> getAllemailsParentByKindergarten(@Param("kidergartenId") Integer kindergartenId );
	
}
