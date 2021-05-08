import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {User} from "../../model/user";
import {MustMatch} from "../../_helpers/must-match.validator";
import {AuthService} from "../../Services/auth.service";

@Component({
  selector: 'ngx-parents',
  templateUrl: './parents.component.html',
  styleUrls: ['./parents.component.scss']
})
export class ParentsComponent implements OnInit {

  public inscriptionForm: FormGroup;
  public submitted = false;
   msg : any;
  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private router: Router
  ) { }

  ngOnInit() {

  }

  get f() { return this.inscriptionForm.controls; }




  public signup(): void {
   


  this.authService.signupCustomer(this.inscriptionForm.value).subscribe(reponse => {
  this.msg=reponse;
  console.log(reponse);
  //this.router.navigate(['/pages/dashborad']);
}, err => {
  console.log("une erreur est survenue lors de la création de votre compte");
});



  }


}
