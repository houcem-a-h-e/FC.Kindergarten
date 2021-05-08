import { Component, OnInit } from '@angular/core';
import {ParentService} from "../../Services/parent.service";

@Component({
  selector: 'ngx-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.scss']
})
export class ProfilComponent implements OnInit {
  list: any;
  constructor(private Sparent:ParentService) { }

  ngOnInit(): void {
    let allparent=this.Sparent.getParent();
    allparent.subscribe((data)=>this.list=data);
  }

}
