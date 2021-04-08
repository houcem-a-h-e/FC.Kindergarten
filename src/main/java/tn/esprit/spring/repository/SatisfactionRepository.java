package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Satisfaction;

public interface SatisfactionRepository extends JpaRepository<Satisfaction, Long>{

	//@Query("select (s.note_fc=:null),(s.satisfaction_of_your_child=:null),(s.sys_of_education=:null) from satisfaction s where join s.parent p  where p.id=parent_id")
     //public int getSatistic(@Param("parent_id")int parent_id); 
}
