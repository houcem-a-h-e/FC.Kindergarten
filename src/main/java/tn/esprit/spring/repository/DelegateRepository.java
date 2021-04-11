package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entity.TimeSheetPk;
import tn.esprit.spring.entity.TimesheetDelegate;

public interface DelegateRepository extends JpaRepository<TimesheetDelegate, TimeSheetPk> {

}
