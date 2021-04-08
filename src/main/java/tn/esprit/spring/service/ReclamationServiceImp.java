package tn.esprit.spring.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

//import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Adminstrator;
import tn.esprit.spring.entity.Kindergarten;
import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.repository.ReclamationRepository;

@Service
public class ReclamationServiceImp implements IReclamationService {

	@Autowired
	private ReclamationRepository reclamRepository;
	@Autowired
	private ParentServiceImp parentserviceimp;
	@Autowired
	private AdminstratorServiceImp AdminServImp;
	@Autowired
	private KindergartenServiceImp KgservImp;
	//private static final org.apache.logging.log4j.Logger l = LogManager.getLogger(ReclamationServiceImp.class);

	@Override
	public List<Reclamation> retrieveAllReclamation() {
		
		return (List<Reclamation>) reclamRepository.findAll();
	}

	@Override
	public Reclamation addReclamation(Reclamation Rec ,Long parents_id,Long kindergarten_id) {
		 Rec.setDate(new Date());
		 Parent p=parentserviceimp.retrieveParent(parents_id);
			Rec.setParents(p);
		Kindergarten Kg=KgservImp.RetrieveKgById(kindergarten_id);
		    Rec.setKindergarten(Kg);
		return reclamRepository.save(Rec);
	}

	@Override
	public void deleteReclamation(Long id,Long admin_id) {
		Reclamation Rec = new Reclamation();
		Adminstrator AD=AdminServImp.retrieveAdminById(admin_id);
	    Rec.setAdmin(AD);
		reclamRepository.deleteById(id);

	}

	
	@Override
	public Reclamation updateReclamation(Reclamation Rec,Long id,Long admin_id) {
		Adminstrator AD = AdminServImp.retrieveAdminById(admin_id);
		Rec.setAdmin(AD);
		reclamRepository.save(Rec);
		return Rec;
	}

	
	@Override
	public Optional<Reclamation> retrieveReclamation(Long id) {
		return reclamRepository.findById(id);
	}

	
}

