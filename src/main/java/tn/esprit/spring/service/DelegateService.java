package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.TimesheetDelegate;
import tn.esprit.spring.repository.DelegateRepository;

@Service
public class DelegateService implements IDelegateService {
	@Autowired
	DelegateRepository delegaterepository;

	@Override
	public List<TimesheetDelegate> retrieveAll() {
		// TODO Auto-generated method stub
		return delegaterepository.findAll();
	}

	@Override
	public TimesheetDelegate addDelegate(TimesheetDelegate t) {
		// TODO Auto-generated method stub
		return delegaterepository.save(t);
	}



	@Override
	public TimesheetDelegate updateDelegate(TimesheetDelegate t) {
		return delegaterepository.save(t);
	}

	@Override
	public TimesheetDelegate retrieveDelegate(Long id) {
		return null;
	}

	@Override
	public void deletedelegate(TimesheetDelegate t) {
		delegaterepository.deleteById(t.getPk());
		
	}



}
