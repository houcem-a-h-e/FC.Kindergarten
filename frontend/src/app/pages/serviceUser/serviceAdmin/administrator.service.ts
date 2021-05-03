import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Administrators} from '../../model/administrators';

@Injectable({
  providedIn: 'root',
})
export class AdministratorService {
  UrlAdmin = 'http://localhost:8082/SpringMVC/servlet/Admin/allAdmin';
  constructor(private http: HttpClient) { }
  getAllAdmin() {
    return this.http.get<Administrators[]>(this.UrlAdmin);
  }
}
