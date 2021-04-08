package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entity.Events;

public interface EventsRepository extends JpaRepository<Events,Long> {

}
