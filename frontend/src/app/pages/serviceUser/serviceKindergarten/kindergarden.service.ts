import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Kindergartens} from '../../model/kindergartens';

@Injectable({
  providedIn: 'root',
})
export class KindergardenService {

  Urlkg = 'http://localhost:8082/SpringMVC/servlet/Kindergarten/allKg';
  constructor(private http: HttpClient) { }
  getAllkg() {
    return this.http.get<Kindergartens[]>(this.Urlkg);
  }
}
