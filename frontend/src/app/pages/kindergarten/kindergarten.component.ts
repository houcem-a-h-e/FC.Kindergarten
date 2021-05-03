import { Component, OnInit } from '@angular/core';
import {Kindergartens} from '../model/kindergartens';
import {KindergardenService} from '../serviceUser/serviceKindergarten/kindergarden.service';

@Component({
  selector: 'ngx-kindergarten',
  templateUrl: './kindergarten.component.html',
  styleUrls: ['./kindergarten.component.scss'],
})
export class KindergartenComponent implements OnInit {

  listKindergarten: Kindergartens[];
  constructor(private Skg: KindergardenService) { }

  ngOnInit(): void {
    this.Skg.getAllkg().subscribe(kg => {
      this.listKindergarten = kg;
    });
  }

}
