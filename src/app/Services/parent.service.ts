import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Rx";

@Injectable({
  providedIn: 'root'
})
export class ParentService {

  constructor(private  http: HttpClient) { }

  getParent():Observable<any>{
    return this.http.get<any>('http://localhost:8082/api/parent/all');
  }
  createParent(parent: Object): Observable<Object> {
    return this.http.post('http://localhost:8082/api/parent/add', parent);
  }
}
