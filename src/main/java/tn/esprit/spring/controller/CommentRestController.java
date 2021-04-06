package tn.esprit.spring.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.Post;
import tn.esprit.spring.repository.ParentRepository;
import tn.esprit.spring.repository.CommentRepository;
import tn.esprit.spring.repository.PostRepository;
import tn.esprit.spring.services.ICommentService;

@RestController
public class CommentRestController {
	@Autowired
	ICommentService commentService;
	@Autowired
	PostRepository postRepository;
	@Autowired
	CommentRepository commentRepository;
	@Autowired
	ParentRepository ParentRepository;
	
	//http://localhost:8080/Kindergarten/servlet/retrieve-all-comments
	@GetMapping("/retrieve-all-comments")
	@ResponseBody
	public List<Comment> getCommentaries() {
		List<Comment> list= commentService.retrieveAllComment();
		return list;
		
	}
	
	//http://localhost:8080/Kindergarten/servlet/add-comment
	@PostMapping("/addcomment")
	@ResponseBody
	public Comment addComment(@RequestBody Comment c) {
		List vocabcommentaire= new ArrayList<String>();
		Comment commentary=new Comment();
		vocabcommentaire.add("klem");
		vocabcommentaire.add("5ayeb");
		/*int i;
		String a=c.getTextComment();
		
		String[] arraylist ={"klem","5ayeb"};
		int len=arraylist.length;
		for(i=0;i<len;i++)
		{
		if(a.contains(arraylist[i])){
			c.setTextComment(c.getTextComment().replaceAll(a, "e7cheeeem"));
		}}*/
		for (int i=0;i<vocabcommentaire.size();i++) {
			String str=vocabcommentaire.get(i).toString();
			while (c.getTextComment().contains(str)) {
				c.setTextComment(c.getTextComment().replaceAll(str, "******"));
			}
			commentary= commentService.addComment(c);
			
	        
	         commentRepository.save(c);}
	return c;
	}

	
	/*public Comment addComment(@RequestBody Comment c) {
		List vocabcommentaire= new ArrayList<String>();
		Comment comment=new Comment();
		vocabcommentaire.add("klem");
		vocabcommentaire.add("5ayeb");
		for (int i=0;i<vocabcommentaire.size();i++) {
		String str=vocabcommentaire.get(i).toString();
		boolean textentry=c.getTextComment().contains(str);
		while (textentry) {
			c.setTextComment(c.getTextComment().replaceAll(str, "e7cheeeem"));
		}
		Optional<Post> optionalpost = postRepository.findById(c.getPost().getId_post());
        c.setPost(optionalpost.get());
        Optional<Parent> optionalParent = ParentRepository.findById(c.getParent().getId());
        c.setParent(optionalParent.get());
        
         commentRepository.save(c);

		comment= commentService.addComment(c);
		}
		return comment;}*/
	
	
	
	
	//http://localhost:8080/Kindergarten/servlet/remove-comment/{comment-id}
	@DeleteMapping("/remove-comment/{commentary-id}")
	@ResponseBody
	public void removeComment(@PathVariable("commentary-id") Long id_comment) {
		commentService.deleteComment(id_comment);
	}
	//http://localhost:8080/Kindergarten/servlet/modify-comment
	@PutMapping("/modify-comment")
	@ResponseBody
	public Comment modifyComment(@RequestBody Comment c) {
		
			List vocabcommentaire= new ArrayList<String>();
			Comment commentary=new Comment();
			vocabcommentaire.add("klem");
			vocabcommentaire.add("5ayeb");
			/*int i;
			String a=c.getTextComment();
			
			String[] arraylist ={"klem","5ayeb"};
			int len=arraylist.length;
			for(i=0;i<len;i++)
			{
			if(a.contains(arraylist[i])){
				c.setTextComment(c.getTextComment().replaceAll(a, "e7cheeeem"));
			}}*/
			for (int i=0;i<vocabcommentaire.size();i++) {
				String str=vocabcommentaire.get(i).toString();
				while (c.getTextComment().contains(str)) {
					c.setTextComment(c.getTextComment().replaceAll(str, "******"));
				}
				commentary= commentService.addComment(c);
				
		        
		         commentRepository.save(c);}
		return c;
	}
	
	@GetMapping("/retrieve-commentary/{commentary-id}")
	@ResponseBody
	public Comment retrieveCommentary(@PathVariable("commentary-id") String commentaryId) {
	return commentService.retrieveCommentary(commentaryId);
	}
	
	
	//http://localhost:8080/Kindergarten/servlet/addlike/{Parent-id}/{post-id}
	@PatchMapping("/addlike/{Parent-id}/{comment-id}")
	@ResponseBody
	public Comment addlike(@PathVariable("Parent-id") Long id_Parent,@PathVariable("comment-id") Long id_comment)
	{
		Comment commentLike= commentRepository.findById(id_comment).get();
		Parent c=ParentRepository.findById(id_Parent).get();
		List<Parent> pLikes= new ArrayList<Parent>();
		 pLikes = commentLike.getLike();
		if(c !=null && commentLike !=null	&& !pLikes.contains(c)){
			pLikes.add(c);
		 commentLike.setLike(pLikes);
		 commentRepository.save(commentLike);
		}
		
		
		return commentLike;
		
	}
	@PatchMapping("/dislike/{Parent-id}/{comment-id}")
	@ResponseBody
	public Comment dislike(@PathVariable("Parent-id") Long id_Parent,@PathVariable("comment-id") Long id_comment)
	{
		Comment commentDislike= commentRepository.findById(id_comment).get();
		Parent parentLiker=ParentRepository.findById(id_Parent).get();
		List<Parent> pLikes= new ArrayList<Parent>();
		 pLikes = commentDislike.getLike();
		if(parentLiker !=null && commentDislike !=null	&& pLikes.contains(parentLiker)){
		 pLikes.remove(pLikes.indexOf(parentLiker));
		 commentDislike.setLike(pLikes);
		 commentRepository.save(commentDislike);
		 
		}
		
		
		return commentDislike;
		
	}

}
