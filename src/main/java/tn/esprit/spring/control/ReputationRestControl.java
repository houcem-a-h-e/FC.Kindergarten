package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.service.IKindergartenService;
import tn.esprit.spring.service.IofferService;

@RestController
public class ReputationRestControl {
	@Autowired
	IofferService os;
	@Autowired
	IKindergartenService ks;
	@GetMapping("/nbroffer/{kinderId}")
	public List<Integer> getNumberOfferByKinder(@PathVariable("kinderId") long kinderid){
		return os.getNumberOfferByKinder(kinderid);
	}
	/*@GetMapping("/reputation")
	public  List<String> getMostKinderOffer(){
		List<String> list = null ;
		List<Long> i = new ArrayList<>();
		List<Kindergarten> lista = ks.retrieveAllKindergarten();
		String kinders;
		for(Kindergarten kinder:lista){
		 i.add(kinder.getId());
			for(long j :i){
				if (os.getNumberOfferByKinder(j).size()>os.getNumberOfferByKinder(j+1).size()){
					kinders = kinder.getName();
					list.add(kinders);
					return list;
				}
				else return null ;
			}
		}
		for (String listetna : list)
			System.out.println("list............"+listetna);
		return list;
	
		
	}*/
	@GetMapping("/reputation")
	public List<String> getMostKinderOffer(){
	  return os.getMostKinderOffer();	
	}
	
}
