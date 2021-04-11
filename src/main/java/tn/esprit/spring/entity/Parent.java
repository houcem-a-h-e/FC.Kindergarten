package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
public class Parent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id ;
	private String  firstName;
	private  String lastName ;
	private String phonenumber ;
	private String email ;
	public List<TimesheetDelegate> getDelegates() {
		return delegates;
	}

	public void setDelegates(List<TimesheetDelegate> delegates) {
		this.delegates = delegates;
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

	public Set<PostRating> getPostRating() {
		return postRating;
	}

	public void setPostRating(Set<PostRating> postRating) {
		this.postRating = postRating;
	}

	public Set<LikePost> getLikePost() {
		return likePost;
	}

	public void setLikePost(Set<LikePost> likePost) {
		this.likePost = likePost;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@JsonIgnore
	private String password ;
	@Enumerated(EnumType.STRING)
	private parentType patype;
	@Temporal(TemporalType.DATE)
	private Date datenais ;
	private final String role="Parent";
	@ManyToMany
	@JsonIgnore
	private List<Kindergarten> kindergarten;
	@ManyToMany(mappedBy="parent",cascade=CascadeType.PERSIST)
	@JsonIgnore
	Set<Child> child;
	
	@OneToMany(mappedBy="parent")
	@JsonIgnore
	List<TimesheetDelegate> delegates;
	 @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "parent", orphanRemoval=true)
         private Set<Post> post= new HashSet<>();
		 @OneToMany(cascade = CascadeType.ALL,mappedBy = "post", orphanRemoval=true)
		 private Set<Comment> comment= new HashSet<>();
		 @OneToMany(cascade = CascadeType.ALL,mappedBy = "parent", orphanRemoval=true)
			private Set<PostRating> postRating= new HashSet<>();
		 
		 @OneToMany(cascade = CascadeType.ALL,mappedBy = "parent", orphanRemoval=true)
			private Set<LikePost> likePost= new HashSet<>();
		 
		 @OneToMany(cascade= CascadeType.ALL,mappedBy="parents")
		 @JsonBackReference
			private Set<Reclamation> reclamation;
			
			@OneToMany(mappedBy="parent")
			@JsonBackReference
			private Set<Satisfaction> satisfaction;
			
			@JsonIgnore
			@Transient
			@OneToMany(cascade = CascadeType.ALL, mappedBy = "parents", fetch = FetchType.LAZY)
			private Collection<Notification> notifications = new ArrayList<>();

	
	public String getRole() {
		return role;
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

	public parentType getPatype() {
		return patype;
	}

	public void setPatype(parentType patype) {
		this.patype = patype;
	}

	public Date getDatenais() {
		return datenais;
	}

	public void setDatenais(Date datenais) {
		this.datenais = datenais;
	}

	public List<Kindergarten> getKindergarten() {
		return kindergarten;
	}

	public void setKindergarten(List<Kindergarten> kindergarten) {
		this.kindergarten = kindergarten;
	}
	








	public Set<Reclamation> getReclamation() {
		return reclamation;
	}

	public void setReclamation(Set<Reclamation> reclamation) {
		this.reclamation = reclamation;
	}

	public Set<Satisfaction> getSatisfaction() {
		return satisfaction;
	}

	public void setSatisfaction(Set<Satisfaction> satisfaction) {
		this.satisfaction = satisfaction;
	}

	

	public Parent(long id, String firstName, String lastName, String phonenumber, String email, String password,
			parentType patype, Date datenais, List<Kindergarten> kindergarten, Set<Child> child,
			List<TimesheetDelegate> delegates, Set<Post> post, Set<Comment> comment, Set<PostRating> postRating,
			Set<LikePost> likePost, Set<Reclamation> reclamation, Set<Satisfaction> satisfaction,
			Collection<Notification> notifications) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phonenumber = phonenumber;
		this.email = email;
		this.password = password;
		this.patype = patype;
		this.datenais = datenais;
		this.kindergarten = kindergarten;
		this.child = child;
		this.delegates = delegates;
		this.post = post;
		this.comment = comment;
		this.postRating = postRating;
		this.likePost = likePost;
		this.reclamation = reclamation;
		this.satisfaction = satisfaction;
		this.notifications = notifications;
	}

	public Parent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Set<Child> getChild() {
		return child;
	}

	public void setChild(Set<Child> child) {
		this.child = child;
	}

	public Collection<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(Collection<Notification> notifications) {
		this.notifications = notifications;
	}

	
	
	

}
