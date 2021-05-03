import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {SatisfactionsModel} from '../model/satisfactions-model';

@Injectable({
  providedIn: 'root',
})
export class SatisfactionServiceService {

  private urlsatis = 'http://localhost:8082/SpringMVC/servlet/satisfaction/allSatis';
  constructor(private http: HttpClient) { }

  getAllSatisfaction() {
    return this.http.get<SatisfactionsModel[]>(this.urlsatis);
  }
}
