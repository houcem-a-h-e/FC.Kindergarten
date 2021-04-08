package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Adminstrator;
import tn.esprit.spring.repository.AdminRepository;

@Service
public class AdminstratorServiceImp implements IAdminstratorService {

	@Autowired
	AdminRepository AdRepo;
	@Override
	public List<Adminstrator> retrieveAllAdmin() {
	
		return (List<Adminstrator>) AdRepo.findAll();
	}

	@Override
	public Adminstrator addAdmin(Adminstrator Ad) {
		
		return AdRepo.save(Ad);
	}

	@Override
	public Adminstrator retrieveAdminById(Long id) {
		
		return AdRepo.findById(id).orElse(null);
	}

	
	

}
