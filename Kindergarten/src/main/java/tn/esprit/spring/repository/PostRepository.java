package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Post;
@Repository
public interface PostRepository extends JpaRepository<Post,Long>{
	@Query("SELECT t FROM Post t WHERE t.textPost LIKE %:textPost%")
	List<Post> retrievePostByText(@Param("textPost") String textPost);
	@Query(value="SELECT t FROM Post t WHERE t.parent_id=:id",nativeQuery =true)
	List<Post> retrievePostByParentId(@Param("id") Long idparent);
	
}
