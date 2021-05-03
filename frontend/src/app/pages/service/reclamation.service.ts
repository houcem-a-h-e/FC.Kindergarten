import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {Reclamations} from '../model/reclamations';

@Injectable({
  providedIn: 'root',
})
export class ReclamationService {
  private allReclamationUrl = 'http://localhost:8082/SpringMVC/servlet/reclamation/all';
  private urlrec = 'http://localhost:8082/SpringMVC/servlet/Admin/allRec';
  constructor(private http: HttpClient) {
  }

  getAllReclamation() {
    return this.http.get<Reclamations[]>(this.allReclamationUrl);
  }
  getAllReclamationForAdmin() {
    return this.http.get<Reclamations[]>(this.urlrec);
  }
  addReclamation(rec: Reclamations): Observable<Reclamations> {
    return this.http.post<Reclamations>(`http://localhost:8082/SpringMVC/servlet/reclamation/addrec/parents_id/kindergarten_id`, rec, {responseType: 'text' as 'json'});
  }

  deleteReclamation(id: number) {
    return this.http.delete<string>('http://localhost:8082/SpringMVC/servlet/reclamation/delete' + id, {responseType: 'text' as 'json'});
  }
  searchReclamationById(rec: Reclamations): Observable<Reclamations> {
    return this.http.get<Reclamations>(`http://localhost:8082/SpringMVC/servlet/reclamation/id/admin_id`);
  }
  updateReclamation(rec: Reclamations): Observable<Reclamations[]> {
    return this.http.put<Reclamations[]>('http://localhost:8082/SpringMVC/servlet/Admin/updateRec/id/admin_id', rec);
  }
}
