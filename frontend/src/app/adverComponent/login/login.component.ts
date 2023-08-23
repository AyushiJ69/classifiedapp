import { Component, OnInit, NgZone } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { CrudService } from './../../service/crud.service';
import { FormGroup, FormBuilder } from "@angular/forms";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  getId: any;
  loginForm: FormGroup;
  errors:any[];
  constructor(
    public formBuilder: FormBuilder,
    private router: Router,
    private ngZone: NgZone,
    private activatedRoute: ActivatedRoute,
    private crudService: CrudService

  )   { 
    this.loginForm = this.formBuilder.group({
      name: [''],
      password: [''],
     
    })
  }

  ngOnInit() {
  }
  check(): any {
    console.log(this.loginForm.value)

    this.crudService.logIn(this.loginForm.value)
    .subscribe((res) => {
        if(res.Error){
          this.errors=res.Error;

        }else

        {
        localStorage.setItem('isLoggedIn','true');
        localStorage.setItem('token', res[0].name); 
        localStorage.setItem('username', res[0].name); 
        console.log('Login successfully!')
        this.ngZone.run(() => this.router.navigateByUrl('/dashboard')).then(() => {
          window.location.reload();
        });
      }
      }, (err) => {
        console.log(err);
    });
  }


}
