package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Post implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	 private Long idPost;
	 private String object_post;
	 private String textPost;
	 private Integer numberOfLikesByPost;

	// @ElementCollection(targetClass=Longeger.class)
	 //private Collection<Longeger> like= new ArrayList<Longeger>();
	 
	
	public Long getIdPost() {
		return idPost;
	}
	public void setIdPost(Long idPost) {
		this.idPost = idPost;
	}
	public Integer getNumberOfLikesByPost() {
		return numberOfLikesByPost;
	}
	public void setNumberOfLikesByPost(Integer numberOfLikesByPost) {
		this.numberOfLikesByPost = numberOfLikesByPost;
	}

	@Temporal (TemporalType.DATE)
	 private Date date_post=new Date();
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "post", orphanRemoval=true)
	private Set<PostRating> postRating= new HashSet<>();
	
	 public Set<PostRating> getPostRating() {
		return postRating;
	}
	public void setPostRating(Set<PostRating> postRating) {
		this.postRating = postRating;
	}
	/*@JsonIgnore
		@ManyToMany(cascade = CascadeType.ALL)
		private List<Parent> like;*/
		
	 @OneToMany(cascade = CascadeType.ALL,mappedBy = "post", orphanRemoval=true)
	 private Set<Comment> comment= new HashSet<>();
	 
	 @OneToMany(cascade = CascadeType.ALL,mappedBy = "post", orphanRemoval=true)
		private Set<LikePost> likePost= new HashSet<>();
	 
	    public Set<LikePost> getLikePost() {
		return likePost;
	}
	public void setLikePost(Set<LikePost> likePost) {
		this.likePost = likePost;
	}

		@ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name="parent_id",nullable = false,referencedColumnName="id")
	    @NotFound(action = NotFoundAction.IGNORE)
	    @JsonBackReference
	    Parent parent;
	    

	/*public List<Parent> getLike() { 
			return like;
		}
		public void setLike(List<Parent> like) {
			this.like = like;
		}*/
	public Set<Comment> getComment() {
		return comment;
	}
	public Parent getParent() {
		return parent;
	}
	public void setParent(Parent Parent) {
		this.parent = Parent;
	}
	public void setComment(Set<Comment> comment) {
		this.comment = comment;
	}
	public Long getidPost() {
		return idPost;
	}
	public void setidPost(Long idPost) {
		this.idPost = idPost;
	}
	public String getObject_post() {
		return object_post;
	}
	public void setObject_post(String object_post) {
		this.object_post = object_post;
	}
	public String gettextPost() {
		return textPost;
	}
	public void settextPost(String textPost) {
		this.textPost = textPost;
	}
	public Date getDate_post() {
		return date_post;
	}
	public void setDate_post(Date date_post) {
		this.date_post = date_post;
	}

	 
}

