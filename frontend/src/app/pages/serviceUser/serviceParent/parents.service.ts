import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Parent} from '../../model/parent';

@Injectable({
  providedIn: 'root',
})
export class ParentsService {

  urlParent = 'http://localhost:8082/SpringMVC/servlet/Parent/allPar';
  constructor(private http: HttpClient) { }
  getAllParent() {
    return this.http.get<Parent[]>(this.urlParent);
  }
}
