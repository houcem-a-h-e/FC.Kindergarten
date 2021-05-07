import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Post } from '../../model/post';

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


  /*addc(t: Comment): Observable<any> {
    return this.http.post<Comment>('http://localhost:8090/Kindergarten/servlet/add-comment', t);
  }*/

  getPostById(id: number): Observable<Post> {
    return this.http.get<Post>('http://localhost:8090/Kindergarten/servlet/retrieve-Post/' + id);
  }
  getNumberOfLikesByIdPost(id: number): Observable<Post> {
    return this.http.get<Post>('http://localhost:8090/Kindergarten/servlet/getNumberOfLikesByPostId/' + id);
  }
  removePostbyClick(idPostToRemove: number): Observable<Post> {
    return this.http.delete<Post>('http://localhost:8090/Kindergarten/servlet/retrieve-Post/' + idPostToRemove);
  }
}
