import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LikePost } from '../../model/likePost';
import { Message } from '../../model/message';
import { Post } from '../../model/post';
import { Comment } from '../../model/comment';


@Injectable({
  providedIn: 'root',
})
export class PostService {
  list: Post[];
  constructor(private http: HttpClient) { }
  getPost(): Observable<any> {
    return this.http.get<any>('http://localhost:8090/Kindergarten/servlet/retrieve-all-Posts');
  }
  addPost(idParent: number, p: Post): Observable<any> {
    return this.http.post<Post>('http://localhost:8090/Kindergarten/servlet/add-Post/' + idParent, p);
  }
  updatePost( idPostToRemove: number, p: Post): Observable<any> {
    return this.http.put<Post>('http://localhost:8090/Kindergarten/servlet/modify-post/' +  idPostToRemove, p);
  }
  updateCmt(idPostToRemove: number, id: number, idpost: number, p: Comment): Observable<any> {
    return this.http.put<Post>('http://localhost:8090/Kindergarten/servlet/modify-comment/'
      + idPostToRemove + '/' + id + '/' + idpost, p);
  }
  /*addc(t: Comment): Observable<any> {
    return this.http.post<Comment>('http://localhost:8090/Kindergarten/servlet/add-comment', t);
  }*/

  getPostById(id: number): Observable<Post> {
    return this.http.get<Post>('http://localhost:8090/Kindergarten/servlet/retrieve-Post/' + id);
  }
  getPostsListByParentId(idParent: number): Observable<Post> {
    return this.http.get<Post>('http://localhost:8090/Kindergarten/servlet/get-posts-byparentid/' + idParent);
  }
  getNumberOfLikesByIdPost(id: number): Observable<Post> {
    return this.http.get<Post>('http://localhost:8090/Kindergarten/servlet/getNumberOfLikesByPostId/' + id);
  }
  removePostbyClick(idPostToRemove: number): Observable<any> {
    return this.http.delete
      ('http://localhost:8090/Kindergarten/servlet/remove-Post/' + idPostToRemove);
  }
  removeCmtbyClick(idPostToRemove: number): Observable<any> {
    return this.http.delete
      ('http://localhost:8090/Kindergarten/servlet/remove-comment/' + idPostToRemove);
  }
  addlikestopsts(idPostToRemove: number, idParent: number): Observable<any> {
    return this.http.put<any>
      ('http://localhost:8090/Kindergarten/servlet/add-liketopost/' + idPostToRemove + '/' + idParent , null);
  }
  addcomment(idPostToRemove: number, idParent: number, c: Comment): Observable<any> {
    return this.http.post<any>
      ('http://localhost:8090/Kindergarten/servlet/addcomment/' + idPostToRemove + '/' + idParent, c);
  }

}
