import { Component, OnInit } from '@angular/core';
import {SatisfactionsModel} from '../model/satisfactions-model';
import {SatisfactionServiceService} from '../serviceSatis/satisfaction-service.service';
import {Parent} from '../model/parent';

@Component({
  selector: 'ngx-satisfaction',
  templateUrl: './satisfaction.component.html',
  styleUrls: ['./satisfaction.component.scss'],
})
export class SatisfactionComponent implements OnInit {
  satisList: SatisfactionsModel[];
  constructor(private satisServ: SatisfactionServiceService) { }

  ngOnInit(): void {
    this.satisServ.getAllSatisfaction().subscribe(sat => {
      this.satisList = sat;
    });
  }
}
