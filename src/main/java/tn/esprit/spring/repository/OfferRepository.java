package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Offer;
@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
	@Query("SELECT COUNT(o) FROM Offer o WHERE o.kindergarten.id= :kinderId")
	List<Integer> getNumberOfferByKinder(@Param("kinderId") long kinderid);
	
	@Query(value="SELECT COUNT(*) as c , k.Name FROM Offer o JOIN Kindergarten k on o.kindergarten_id=k.id GROUP BY k.Name  ORDER BY c DESC ", nativeQuery = true)
	List<String> getMostKinderOffer();
	
	
	
	
	
	
}
