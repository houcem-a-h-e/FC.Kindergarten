package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Adminstrator;

public interface IAdminstratorService {

	List<Adminstrator> retrieveAllAdmin();

	Adminstrator addAdmin(Adminstrator Ad);

	Adminstrator retrieveAdminById(Long id);
}
