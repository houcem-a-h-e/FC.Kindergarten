import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {KinderService} from "../../Services/kinder.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MustMatch} from "../../_helpers/must-match.validator";

@Component({
  selector: 'ngx-kindergarten',
  templateUrl: './kindergarten.component.html',
  styleUrls: ['./kindergarten.component.scss']
})
export class KindergartenComponent implements OnInit {
  public inscriptionFormkinder: FormGroup;
  public submitted = false;
  msg : any;

  constructor(

    private fb: FormBuilder,
    private Kinder: KinderService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.inscriptionFormkinder = this.fb.group({
      Name: ['', [Validators.required]],
      phonenumber: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(10)]],
      confirmPassword: ['', [Validators.required, Validators.minLength(10)]]

    }, {
      validator: MustMatch('password', 'confirmPassword')
    });
  }
  get f() { return this.inscriptionFormkinder.controls; }


 signupkinder(){
   this.submitted = true;
   if (this.inscriptionFormkinder.invalid) {
     return;
   }

   this.Kinder.signupkindergarten(this.inscriptionFormkinder.value).subscribe(reponse => {
     this.msg=reponse;
     console.log(reponse);
     //this.router.navigate(['/pages/dashborad']);
   }, err => {
     console.log("une erreur est survenue lors de la création de votre compte");
   });



 }

}
