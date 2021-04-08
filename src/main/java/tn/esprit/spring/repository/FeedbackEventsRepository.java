package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entity.FeedbackEvents;

public interface FeedbackEventsRepository extends JpaRepository<FeedbackEvents,Long> {

}
