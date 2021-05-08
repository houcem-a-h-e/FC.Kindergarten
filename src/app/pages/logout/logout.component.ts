import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../Services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'ngx-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.scss']
})
export class LogoutComponent implements OnInit {

  public isAthentificated : boolean = false;
  constructor(private authService : AuthService,
              private router: Router) {
    this.isAthentificated = this.authService.isAthentificated();
  }

  ngOnInit(): void {
  }

  disconnect():void {
    this.authService.disconnect();
    this.isAthentificated = this.authService.isAthentificated();
    this.router.navigate(['/']);
  }
}
