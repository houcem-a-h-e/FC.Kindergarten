package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.services.IParentService;

@RestController
public class ParentRestController {
	
	@Autowired
	IParentService parentService;
	
	@GetMapping("/retrieve-all-parents")
	@ResponseBody
	public List<Parent> getParents() {
	List<Parent> list= parentService.retrieveAllParents();
	return list;
	}
	
	@GetMapping("/retrieve-parent/{parent-id}")
	@ResponseBody
	public Parent retrieveParent(@PathVariable("parent-id") String parentId) {
	return parentService.retrieveParent(parentId);
	}

	
	@PostMapping("/add-parent")
	@ResponseBody
	public Parent addParent(@RequestBody Parent p) {
		
		Parent parent= parentService.addParent(p);
	return parent;
	}
	
	@DeleteMapping("/remove-parent/{parent-id}")
	@ResponseBody
	public void removeParent(@PathVariable("parent-id") String parentId) {
		parentService.deleteParent(parentId);
	}
	
	@PutMapping("/modify-parent")
	@ResponseBody
	public Parent modifyParent(@RequestBody Parent p) {
	return parentService.updateParent(p);
	}
	@PutMapping("/affecterunpostauparent/{parent-id}/{post-id}")
	@ResponseBody
	public void affecterunpostauparent(@PathVariable("parent-id")String idparent,@PathVariable("post-id")String idpost ) {
		}
	
	@GetMapping("/retrieve-all-parent-post-subjects/{parent-id}")
	@ResponseBody
	public List<String> getAllPostsByParentId(@PathVariable("parent-id") String parentId) {
	return parentService.getAllPostsByParentId(parentId);
	}
}
