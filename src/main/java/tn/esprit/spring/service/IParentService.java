package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Parent;

public interface IParentService {


	List<Parent> retrieveAllParent();

	Parent addParent(Parent PR);
	Parent retrieveParent(Long id);
}
