import {Component, OnInit} from '@angular/core';
import { fruits } from './fruits-list';
import {ParentService} from "../../../Services/parent.service";
import {Parent} from "../../../model/parent";

@Component({
  selector: 'ngx-list',
  templateUrl: 'list.component.html',
  styleUrls: ['list.component.scss'],
})
export class ListComponent implements  OnInit{
  fruits = fruits;
  list: any;
  users: { name: string, title: string }[] = [
    { name: 'Carla Espinosa', title: 'Nurse' },
    { name: 'Bob Kelso', title: 'Doctor of Medicine' },
    { name: 'Janitor', title: 'Janitor' },
    { name: 'Perry Cox', title: 'Doctor of Medicine' },
    { name: 'Ben Sullivan', title: 'Carpenter and photographer' },
  ];
  constructor(private Sparent:ParentService){

  }
  ngOnInit(){
    let allparent=this.Sparent.getParent();
    allparent.subscribe((data)=>this.list=data);

  }

}
