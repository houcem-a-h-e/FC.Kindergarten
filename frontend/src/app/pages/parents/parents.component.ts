import { Component, OnInit } from '@angular/core';
import {Parent} from '../model/parent';
import {ParentsService} from '../serviceUser/serviceParent/parents.service';

@Component({
  selector: 'ngx-parents',
  templateUrl: './parents.component.html',
  styleUrls: ['./parents.component.scss'],
})
export class ParentsComponent implements OnInit {

  listParent: Parent[];
  constructor(private serp: ParentsService ) { }

  ngOnInit(): void {
    this.serp.getAllParent().subscribe(par => {
      this.listParent = par;
    });
  }

}
