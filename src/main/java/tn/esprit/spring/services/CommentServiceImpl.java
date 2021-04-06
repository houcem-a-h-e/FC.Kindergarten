package tn.esprit.spring.services;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.Post;
import tn.esprit.spring.repository.CommentRepository;
import tn.esprit.spring.repository.PostRepository;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class CommentServiceImpl implements ICommentService {
   @Autowired
   CommentRepository commentRepository;
   @Autowired
   PostRepository postRepository;
   private static final Logger l = LogManager.getLogger(CommentServiceImpl.class);
	@Override
   public List<Comment> retrieveAllComment(){
		List<Comment> comments=commentRepository.findAll();
		for (Comment comment : comments) {
			l.info("comment: " + comment);
				}
		return comments;
	}
	@Override
	public Comment addComment(Comment c) {
		commentRepository.save(c);
		return c;
	}
	@Override
	public void deleteComment(Long id_comment) {
		commentRepository.deleteById(id_comment);	
	}
	@Override
	public Comment updateComment(Comment c) {
		commentRepository.save(c);
		return c;
	}
	@Override
	public Comment retrieveCommentary(String id) {
		// TODO Auto-generated method stub
		Comment c = commentRepository.findById(Long.parseLong(id)).orElse(null);
		return c;
	}
	
	@Transactional
	public void affectcommenttopost(String idcomt, String idpost) {
		Comment cmnt=commentRepository.findById(Long.parseLong(idpost)).get();
		Post ent=postRepository.findById(Long.parseLong(idpost)).get();
		cmnt.setPost(ent);
		commentRepository.save(cmnt);
		}
	}