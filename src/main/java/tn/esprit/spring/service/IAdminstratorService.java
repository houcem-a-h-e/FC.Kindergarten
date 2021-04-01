package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Kindergarten;
import tn.esprit.spring.entity.Parent;

public interface IAdminstratorService {
	public void KindergartenRegistrationConfirmation(Long id);
    public 	List<Kindergarten> findallkindergartens();
	public List<Parent> findParentfromKindergarten(Long id);
}
