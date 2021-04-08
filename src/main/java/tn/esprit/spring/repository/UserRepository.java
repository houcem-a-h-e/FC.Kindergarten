package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Users;
@Repository
public interface UserRepository extends CrudRepository<Users, String> {
	Users findByEmail(String email );
}
