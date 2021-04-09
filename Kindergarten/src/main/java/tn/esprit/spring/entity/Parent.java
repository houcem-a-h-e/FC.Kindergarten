package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import tn.esprit.spring.entity.ParentType;

@Entity
public class Parent implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id ;
	private String  firstName;
	private  String lastName ;
	private String phonenumber ;
	private String email ;
	private String password ;
	@Enumerated(EnumType.STRING)
	ParentType pType;
	@Temporal(TemporalType.DATE)
	private Date datenais ;
	/*@ManyToOne
	private Kindergarten kindergarten;*/
	//@OneToMany(mappedBy="parent")
	/*List<Child> child;*/
	//@JsonIgnore
		@ManyToMany(mappedBy="like", cascade = CascadeType.ALL)
		private List<Post> parentLikePost;	
		

		

			//@JsonIgnore
			@ManyToMany(mappedBy="like", cascade = CascadeType.ALL)
			private List<Comment> parentLikeComment;	
		 @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "parent", orphanRemoval=true)
		 private Set<Post> post= new HashSet<>();
		 @OneToMany(cascade = CascadeType.ALL,mappedBy = "post", orphanRemoval=true)
		 private Set<Comment> comment= new HashSet<>();
		 @OneToMany(cascade = CascadeType.ALL,mappedBy = "parent", orphanRemoval=true)
			private Set<PostRating> postRating= new HashSet<>();
		 
	public Set<PostRating> getPostRating() {
			return postRating;
		}

		public void setPostRating(Set<PostRating> postRating) {
			this.postRating = postRating;
		}

	public List<Post> getParentlikePost() {
			return parentLikePost;
		}

		public void setParentlikePost(List<Post> parentLikePost) {
			this.parentLikePost = parentLikePost;
		}

	public List<Comment> getParentlikecomment() {
			return parentLikeComment;
		}

		public void setParentLikeComment(List<Comment> parentLikeComment) {
			this.parentLikeComment = parentLikeComment;
		}

		public Set<Post> getPost() {
			return post;
		}

		public void setPost(Set<Post> post) {
			this.post = post;
		}

		public Set<Comment> getComment() {
			return comment;
		}

		public void setComment(Set<Comment> comment) {
			this.comment = comment;
		}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ParentType getPatype() {
		return pType;
	}

	public void setPatype(ParentType patype) {
		this.pType = patype;
	}

	public Date getDatenais() {
		return datenais;
	}

	public void setDatenais(Date datenais) {
		this.datenais = datenais;
	}

	/*public Kindergarten getKindergarten() {
		return kindergarten;
	}

	public void setKindergarten(Kindergarten kindergarten) {
		this.kindergarten = kindergarten;
	}*/

	public Parent(long id, String firstName, String lastName, String phonenumber, String email, String password,
			ParentType patype, Date datenais) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phonenumber = phonenumber;
		this.email = email;
		this.password = password;
		this.pType = patype;
		this.datenais = datenais;
		/*this.kindergarten = kindergarten;
		this.child = child;*/
	}

	public Parent() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	

}