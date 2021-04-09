package tn.esprit.spring.services;

import java.util.List;


import tn.esprit.spring.entity.Comment;

public interface ICommentService {
	List<Comment> retrieveAllComment();
	Comment addComment(Comment c);
	void deleteComment(Long id_comment);
	Comment updateComment(Comment t);
	Comment retrieveCommentary(String id);

	
}