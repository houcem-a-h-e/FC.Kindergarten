package tn.esprit.spring.service;

import tn.esprit.spring.entity.TimesheetDelegate;

public interface IDelegateService {
	java.util.List<TimesheetDelegate> retrieveAll();
	TimesheetDelegate addDelegate(TimesheetDelegate t);

	void deletedelegate(TimesheetDelegate t);
	TimesheetDelegate updateDelegate(TimesheetDelegate t);
	TimesheetDelegate retrieveDelegate(Long id);

}
