import { Output } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EventEmitter } from 'events';
import { delay, timeout } from 'rxjs/operators';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
 import { CommentServiceService } from '../../services/comment-service.service';
import { PostService } from '../extra-components/services/post.service';
import { Parent, ParentType } from '../model/parent';
import { Post } from '../model/post';
import { Comment } from '../model/comment';
import { FormBuilder } from '@angular/forms';
import { id } from '@swimlane/ngx-charts';
import { LikePost } from '../model/likePost';

@Component({
  selector: 'ngx-forum',
  templateUrl: './forum.component.html',
  styleUrls: ['./forum.component.scss'],
})
export class ForumComponent implements OnInit {
  idp: number;
  warningmessage: string;
  idpostsearched: number;
  i: number;
  lp: LikePost;
  idPostToRemove: number;
  idCommentToWorkOn: number;
  idPostToUpdate: number;
  isShown: boolean = false;
  showWarningDeletePost: boolean = false;
  showUpdateFileds: boolean = false;
  hideUpdateWindow: boolean = false;
  shownOnAddPost: boolean = false;
  hideCommentUpdateWindow: boolean = true;
  hideMessageAfterTheAddPost: boolean = true;
  parent1: Parent;
  post3: Post = new Post();
  listofposts: Post[];
  taille: number;
  list: Post[];
  listofLikes: number[];
  s: string = 'added successfully';
  post: Post;
  parent: Parent = {
  id : 41  ,
  firstName: 'houcem',
  lastName : 'aouissaoui',
  phonenumber : '2222222',
  email : 'jcnscd@klsnd.com',
  password : 'jarreb',
  pType : ParentType.ordinaryParent,
  };
  display = 'none';
  c: Comment;
  c3: Comment;
  checkIfItExists: boolean;
  comments: Comment[];
  myDate: Date = new Date;
  constructor(
      private postSer: PostService,
      private commentSer: CommentServiceService,
    private modalService: NgbModal,
    private fb: FormBuilder,
    private r: Router) { }
  ngOnInit(): void {
    // this.postSer.getPost().subscribe(() => (this.listofLikes.push(this.post.idPost)));
    this.post = new Post();
    this.c = new Comment();
    // listC: Comment[];
    // this.postSer.getPost().subscribe((data: any) => this.list = data);
    // this.getAllPosts();
    this.postSer.getPost().subscribe((data: any) => {
      this.list = data;
      // this.list.map(element: Post =>)
       // console.log(data);
    });
  }
  ajoutPost() {

    this.postSer.addPost(this.parent.id, this.post).subscribe(() => {
      this.shownOnAddPost = true;
      /*this.post.object_post = ' ';
      this.post.textPost = ' ';*/
      // this.post.numberOfLikesByPost = 0;
      // this.post.reviewByPost = 0;
      let post2: Post = new Post();
      this.post = post2;
      this.post3 = this.post;
      this.post3.numberOfLikesByPost = 0;
      this.post3.reviewByPost = 0;

      setTimeout(() => this.shownOnAddPost = false, 5000);
      this.getAllPosts();
    });

  }

  retrieveListPostsOfParent() {
    this.postSer.getPostsListByParentId(this.parent.id).subscribe((data: any) => this.list = data);
  }

  getAllPosts() {
    this.postSer.getPost().subscribe((data: any) => this.list = data);
  }

  removePostByClick(idPostToRemove): void {
    this.postSer.removePostbyClick(idPostToRemove).subscribe
      (data => {
       // this.showWarningDeletePost = true;
        console.log(data);
        this.getAllPosts();
      });
    }

  removeCmtByClick(idPostToRemove): void {
    this.postSer.removeCmtbyClick(idPostToRemove).subscribe
      (data => {
        // this.showWarningDeletePost = true;
        console.log(data);
        this.getAllPosts();
      });
  }


    // let j = this.list.indexOf(this.post);
  /*const index = this.list.findIndex(() => this.post.idPost === this.idPostToRemove);*/
    /*if (idp !== this.parent.id) {
      this.warningmessage = 'you are not the owner of this post';
      this.getAllPosts();
    } if (idp === this.parent.id) {
      this.postSer.removePostbyClick(idPostToRemove, this.parent.id).subscribe
        (data => {
          // console.log(data);
          this.warningmessage = ' the post has been deleted';
          this.getAllPosts();
        });
    }
    this.showWarningMessage = true;
    setTimeout(() => this.showWarningMessage = false, 5000);*/


  getSepecificPost(idpostsearched) {
    this.postSer.getPostById(this.idpostsearched).subscribe((data: Post) => {
      this.post = data;
      console.log(data);
    });
    // this.isShown = true;
  }

  openModal(event: any) {
    // this.idpostsearched = this.idPostToRemove;
    this.display = 'block';
   this.postSer.getPostById(this.idpostsearched).subscribe((data: Post) => this.post = data);
    // console.log(idpostsearched);
  }

  onCloseHandled() {
    this.display = 'none';
  }
  showMessage() {
    console.log('it works');
  }

  updatePostAfterClk(idPostToRemove) {
    console.log(idPostToRemove);
    this.post3 = this.post;
    this.postSer.updatePost(idPostToRemove, this.post3).subscribe((data: Post) => this.post = data);
    // this.post = this.post2;
    this.showUpdateFileds = true;
    // this.post.textPost = ' ';
    this.getAllPosts();
    this.hideUpdateWindow = true;
    let post1: Post = new Post();
     this.post = post1;

  }

  showUpdateWindow(idPostToRemove) {
    this.hideUpdateWindow = false;
    console.log(idPostToRemove);
    let post4: Post = new Post();

    this.idPostToRemove = idPostToRemove;
    this.postSer.getPostById(idPostToRemove).subscribe((data: Post) => {
      this.post = data;
      console.log(data);
    });
    this.showUpdateFileds = true;
  }

  showCommentUpdateWindow(idCommentToWorkOn) {
    this.hideCommentUpdateWindow = false;
    console.log(idCommentToWorkOn);
    let comment1: Comment = new Comment();

    this.idCommentToWorkOn = idCommentToWorkOn;
    /*this.postSer.getPostById(idPostToRemove).subscribe((data: Post) => {
      this.post = data;
      console.log(data);
    });*/
    this.showUpdateFileds = true;
  }


  addliketopost(idPostToRemove) {
    this.postSer.addlikestopsts(idPostToRemove, this.parent.id).subscribe(() => {
      this.getAllPosts();
    });
      /*if (this.lp.likesatatus === true) {
        this.post.numberOfLikesByPost += 1;
        this.post3 = this.post;
        this.postSer.updatePost(idPostToRemove, this.post3).subscribe((data: Post) => this.post = data);
        this.getAllPosts();*/
  }

  test( idd: number) {
    return idd === this.idPostToRemove;
  }
  cancelupdate() {
    this.hideUpdateWindow = true;
  }

  trial(idd: number) {
    return idd === this.idCommentToWorkOn;
  }

  ajoutComment(idPostToRemove) {
    console.log(idPostToRemove);
    this.postSer.addcomment(idPostToRemove, this.parent.id, this.c).subscribe(() => {
     // this.postSer.updatePost(idPostToRemove, this.post).subscribe((data: Post) => this.post = data);
      //this.c2: Comment = new Comment();
      // this.c = c2;
      this.c = new Comment();
      this.getAllPosts();
    });
  }
  updateCmtAfterClk(cc: Comment, p: Post) {
    console.log(cc.id_comment);
    //this.post3 = this.post;
    this.postSer.updateCmt(cc.id_comment, this.parent.id, p.idPost,  cc).subscribe((data: Comment) => cc = data);
    // this.post = this.post2;
    //this.showUpdateFileds = true;
    // this.post.textPost = ' ';
    this.c = new Comment();
    this.getAllPosts();
    this.hideCommentUpdateWindow = true;
    //this.hideUpdateWindow = true;
    //this.post = post1;

  }

}
