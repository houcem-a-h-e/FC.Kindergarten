import { Component, OnInit } from '@angular/core';
import {Administrators} from '../model/administrators';
import {AdministratorService} from '../serviceUser/serviceAdmin/administrator.service';
import {Router} from '@angular/router';
import {MENU_ITEMS} from '../pages-menu';

@Component({
  selector: 'ngx-administrator',
  templateUrl: './administrator.component.html',
  styleUrls: ['./administrator.component.scss'],
})
export class AdministratorComponent implements OnInit {
  listAdministrator: Administrators[];
  constructor(private serv: AdministratorService, private _router: Router) { }

  ngOnInit(): void {
    this.serv.getAllAdmin().subscribe(ad => {
      this.listAdministrator =  ad ;
    });
  }

}
