import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PostService {

  constructor(private http: HttpClient) { }
  getPost(): Observable<any> {
    return this.http.get<any>('http://localhost:8090/Kindergarten/servlet/retrieve-all-Posts');
  }
}
