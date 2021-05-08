import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Rx";
import {kindergarten} from "../model/kindergarten";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class KinderService {
  public baseUrl = environment.baseUrl;

  constructor(private  http: HttpClient) { }
  public signupkindergarten(kinde: kindergarten): Observable<kindergarten> {
    return this.http.post<kindergarten>(this.baseUrl+'/api/kindergarten/add', kinde);
  }
  }

