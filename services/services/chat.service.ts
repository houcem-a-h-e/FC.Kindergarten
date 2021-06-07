import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root',
})
export class MessagesService {
  messagesUrl = 'http://localhost:8089/Kindergarten/servlet/getMessages';
  constructor(private _http: HttpClient) { }
  getUsersName(): Observable<string[]> {
    return this._http.get<string[]>(this.messagesUrl);
  }
}
