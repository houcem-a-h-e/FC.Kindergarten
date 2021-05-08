import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { tap } from 'rxjs/operators';

import { HttpClient, HttpParams } from '@angular/common/http';
import {JwtToken} from "../model/JwtToken";
import {User} from "../model/user";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  public baseUrl = environment.baseUrl;
  public jwtToken: BehaviorSubject<JwtToken> = new BehaviorSubject({
    isAuthenticated: null,
    token: null
  });

  constructor(private http: HttpClient) {
    this.initToken();
   }

  private initToken(): void {
    const token = localStorage.getItem('token');
    if (token) {
      this.jwtToken.next({
        isAuthenticated: true,
        token: token
      });
    } else {
      this.jwtToken.next({
        isAuthenticated: false,
        token: null
      });
    }
  }
  public signupCustomer(user: User): Observable<User> {
    return this.http.post<User>(this.baseUrl+'/api/parent/add', user,{responseType:'text' as 'json'});
  }




  public signin(credentials: { email: string, password: string}): Observable<string> {
    return this.http.get<string>(this.baseUrl+'/api/parent/auth/'+credentials.email+'/'+credentials.password).pipe(
      tap(( res: any ) => {
        this.jwtToken.next({
          isAuthenticated: true,
          token: res.token
        });
        localStorage.setItem('token', res.token);
      })
    );
  }
  isAthentificated(): boolean{
    return this.jwtToken.value.isAuthenticated;
  }

  public getToken(): string {
    return localStorage.getItem('token');
  }

  disconnect(): void{
 
  }
}
