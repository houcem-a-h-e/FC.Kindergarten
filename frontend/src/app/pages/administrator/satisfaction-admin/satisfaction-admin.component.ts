import { Component, OnInit } from '@angular/core';
import {SatisfactionsModel} from '../../model/satisfactions-model';
import {SatisfactionServiceService} from '../../serviceSatis/satisfaction-service.service';

@Component({
  selector: 'ngx-satisfaction-admin',
  templateUrl: './satisfaction-admin.component.html',
  styleUrls: ['./satisfaction-admin.component.scss'],
})
export class SatisfactionAdminComponent implements OnInit {

  satisList: SatisfactionsModel[];
  constructor(private satisServ: SatisfactionServiceService) { }

  ngOnInit(): void {
    this.satisServ.getAllSatisfaction().subscribe(sat => {
      this.satisList =  sat ;
    });
  }

}
