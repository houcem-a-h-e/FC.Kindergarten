import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { provideRoutes } from '@angular/router';
import { Observable } from 'rxjs';
import { filter } from 'rxjs/operators';
import { Post } from '../pages/model/post';

@Injectable({
  providedIn: 'root',
})
export class CommentServiceService {
  post: Post[];
  commentUrl = 'http://localhost:8090/Kindergarten/servlet/retrieve-commentary/';
constructor(private http: HttpClient) {}
  getComment(t: Comment): Observable<Comment[]> {
    return this.http.get<Comment[]>(this.commentUrl + '/' + t);
  }
  addc(t: Comment): Observable<any> {
    return this.http.post<Comment>('http://localhost:8090/Kindergarten/servlet/add-comment', t);
  }
}
