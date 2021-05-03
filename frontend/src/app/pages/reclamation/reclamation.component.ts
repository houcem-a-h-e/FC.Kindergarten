import { Component, OnInit } from '@angular/core';
import {ReclamationService} from '../service/reclamation.service';
import {Reclamations} from '../model/reclamations';
import {Router} from '@angular/router';

@Component({
  selector: 'ngx-reclamation',
  templateUrl: './reclamation.component.html',
  styleUrls: ['./reclamation.component.scss'],
})
export class ReclamationComponent implements OnInit {

  reclamation: Reclamations = new Reclamations();
  listReclamation: Reclamations[];

  constructor(private service: ReclamationService, private _router: Router) {
  }

  ngOnInit(): void {
    this.service.getAllReclamation().subscribe(res => {
      this.listReclamation = res;
    });
  }

}
