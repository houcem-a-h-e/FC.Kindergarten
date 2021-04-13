package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class LikePost implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long idLikePost;
	@ManyToOne
	@JsonIgnore
	private Parent parent;
	@ManyToOne
	@JsonIgnore
	private Post post;
	Boolean likesatatus;
	public Long getIdLikePost() {
		return idLikePost;
	}
	public void setIdLikePost(Long idLikePost) {
		this.idLikePost = idLikePost;
	}
	public Parent getParent() {
		return parent;
	}
	public void setParent(Parent parent) {
		this.parent = parent;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public Boolean getLikesatatus() {
		return likesatatus;
	}
	public void setLikesatatus(Boolean likesatatus) {
		this.likesatatus = likesatatus;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
