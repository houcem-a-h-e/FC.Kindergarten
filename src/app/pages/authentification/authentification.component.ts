import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../../Services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'ngx-authentification',
  templateUrl: './authentification.component.html',
  styleUrls: ['./authentification.component.scss']
})
export class AuthentificationComponent implements OnInit {

  public signinForm: FormGroup;
  public submitted = false;

  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private router: Router
  ) {

  }

  ngOnInit() {
  
  }

  get f() { return this.signinForm.controls; }

  public signin() {
    this.submitted = true;
    if (this.signinForm.invalid) {
      return;
    }
    this.authService.signin(this.signinForm.value).subscribe( {next:(res) => {
      this.router.navigate(['/pages/profil']);
    },error : err => {
      this.router.navigate(['/pages/login']);
    }
    });
  }

}
