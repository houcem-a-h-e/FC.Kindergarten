import { Component, OnInit } from '@angular/core';
import {Reclamations} from '../../model/reclamations';
import {ReclamationService} from '../../service/reclamation.service';
import {Router} from '@angular/router';

@Component({
  selector: 'ngx-reclamation-admin',
  templateUrl: './reclamation-admin.component.html',
  styleUrls: ['./reclamation-admin.component.scss'],
})
export class ReclamationAdminComponent implements OnInit {

  reclamation: Reclamations = new Reclamations();
  listReclamations: Reclamations[];

  constructor(private serRec: ReclamationService, private _router: Router) {
  }

  ngOnInit(): void {
    this.serRec.getAllReclamationForAdmin().subscribe(data => {
      this.listReclamations = data;
    });
  }

}
