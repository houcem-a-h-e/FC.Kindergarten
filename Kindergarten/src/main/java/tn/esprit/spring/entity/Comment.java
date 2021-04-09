package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Comment implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Long id_comment;
	private String textComment;
    @Temporal (TemporalType.DATE)
	private Date date_comment=new Date();
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_post")
    @JsonBackReference
    Post post;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_parent",referencedColumnName="id")
    @JsonIgnore
    Parent parent;    
	 @JsonIgnore
		@ManyToMany(cascade = CascadeType.ALL)
		private List<Parent> like;
	public Long getId_comment() {
		return id_comment;
	}
	public void setId_comment(Long id_comment) {
		this.id_comment = id_comment;
	}
	public String getTextComment() {
		return textComment;
	}
	public void setTextComment(String textComment) {
		this.textComment = textComment;
	}
	public Date getDate_comment() {
		return date_comment;
	}
	public void setDate_comment(Date date_comment) {
		this.date_comment = date_comment;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public Parent getParent() {
		return parent;
	}
	public void setParent(Parent parent) {
		this.parent = parent;
	}
	public List<Parent> getLike() {
		return like;
	}
	public void setLike(List<Parent> like) {
		this.like = like;
	}
	 
	
}
