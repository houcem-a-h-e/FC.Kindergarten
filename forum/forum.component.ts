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
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'ngx-forum',
  templateUrl: './forum.component.html',
  styleUrls: ['./forum.component.scss'],
})
export class ForumComponent implements OnInit {
  idp: number;
  idpostsearched: number;
  idPostToRemove: number;
  idPostToUpdate: number;
  isShown: boolean = false;
  shownOnAddPost: boolean = false;
  hideMessageAfterTheAddPost: boolean = true;
  list: Post[];
  listofLikes: number[];
  s: string = 'added successfully';
  post: Post;
  parent: Parent = {
  id : 2  ,
  firstName: 'houcem',
  lastName : 'aouissaoui',
  phonenumber : '2222222',
  email : 'jcnscd@klsnd.com',
  password : 'jarreb',
  pType : ParentType.ordinaryParent,
  };
  display = 'none';
  c: Comment;
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
    // this.postSer.getPost().subscribe((data: any) => this.list = data);
    this.getAllPosts();
  }
  ajoutPost() {
    this.postSer.addPost(this.parent.id, this.post).subscribe(() => {
      this.shownOnAddPost = true;
      this.post.object_post = ' ';
      this.post.textPost = ' ';
      setTimeout(() => this.shownOnAddPost = false, 5000);
      this.getAllPosts();
    });
  }

  getAllPosts() {
   this.postSer.getPost().subscribe((data: any) => this.list = data);
  }
  updatePostByClick() {

  }

  removePostByClick(idPostToRemove): void {
    // let j = this.list.indexOf(this.post);
    /*const index = this.list.findIndex(() => this.post.idPost === this.idPostToRemove);*/
    this.postSer.removePostbyClick
      (idPostToRemove).subscribe
      (data => {
        console.log(data);
        this.getAllPosts();
      });
        // this.list.filter(post => post.idPost !== idPostToRemove));
  }

  getSepecificPost(idpostsearched) {
    this.postSer.getPostById(this.idpostsearched).subscribe((data: Post) => this.post = data);
    this.isShown = true;
  }

  openModal(event: any) {
    // this.idpostsearched = this.idPostToRemove;
    this.display = 'block';
    // this.postSer.getPostById(idpostsearched).subscribe((data: Post) => this.post = data);
    // console.log(idpostsearched);
  }

  onCloseHandled() {
    this.display = 'none';
  }

}
