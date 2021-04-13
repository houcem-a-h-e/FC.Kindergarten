package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class PostRating implements Serializable{
	private static final long serialVersionUID = 1L; 
	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private int id_rating;
	    @ManyToOne
	    @JoinColumn(name = "parent_id",referencedColumnName="id")
	    @JsonIgnore
	    private Parent parent;
	    @ManyToOne
	    @JoinColumn(name = "post_id",referencedColumnName="idPost")
	    @JsonIgnore
	    private Post post;
	 
	    @Min(1)
	    @Max(5)
	    private Integer ratingP;

		public int getId_rating() {
			return id_rating;
		}

		public void setId_rating(int id_rating) {
			this.id_rating = id_rating;
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

		public int getRatingP() {
			return ratingP;
		}

		public void setRatingP(int rating) {
			
			this.ratingP = rating;
		}

}
