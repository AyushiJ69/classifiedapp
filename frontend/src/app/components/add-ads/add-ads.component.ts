import { Component, OnInit, NgZone } from '@angular/core';
import { Router } from '@angular/router';
import { CrudService } from './../../service/crud.service';
import { FormGroup, FormBuilder } from "@angular/forms";

@Component({
  selector: 'app-add-book',
  templateUrl: './add-ads.component.html',
  styleUrls: ['./add-ads.component.css']
})

export class AddAdsComponent implements OnInit {

  adsForm: FormGroup;
  tagForm: FormGroup;
  categoryForm: FormGroup;
  tags:any = [{tagName:'trending'},{tagName:'hot'},{tagName:'top'}];
  categories:any = [{categoryName:'cars'},{categoryName:'cloths'},{categoryName:'mobile'},{categoryName:'books'},{categoryName:'accessories'}];
  tagname: any;
  categoryname: any;
  constructor(
    public formBuilder: FormBuilder,
    private router: Router,
    private ngZone: NgZone,
    private crudService: CrudService
  ) {
    this.adsForm = this.formBuilder.group({
      title: [''],
      category: [''],
      text: [''],
      images: ['']
    })
    this.tagForm = this.formBuilder.group({
      tagName: ['']
    })
    this.categoryForm = this.formBuilder.group({
      categoryName: ['']
    })
  }
  ngOnInit(): void {
    this.crudService.gettags().subscribe(res => {
      console.log(res)
      this.tags = res;
    });
    this.crudService.getcategories().subscribe(res => {
      console.log(res)
      this.categories = res;
    });
  }

  onSubmit(): any {
    console.log(this.adsForm.value)
    console.log(this.tagname)
    console.log(this.categoryname)
    this.crudService.Addads(this.adsForm.value)
      .subscribe(() => {
        console.log('Data added successfully!')
        this.ngZone.run(() => this.router.navigateByUrl('/dashboard'))
      }, (err) => {
        console.log(err);
      });
  }
  addtag(): any {
    this.crudService.addTag(this.tagForm.value)
      .subscribe(() => {
        console.log('Data added successfully!')
        this.ngZone.run(() => this.router.navigateByUrl('/add-ads')).then(() => {
          window.location.reload();
        });
      }, (err) => {
        console.log(err);
      });

  }

  addcategory(): any {
    this.crudService.addCategory(this.categoryForm.value)
      .subscribe(() => {
        console.log('Data added successfully!')
        this.ngZone.run(() => this.router.navigateByUrl('/add-ads')).then(() => {
          window.location.reload();
        });
      }, (err) => {
        console.log(err);
      });

  }

  changeCategory(e) {
    this.categoryname = e.target.value;
  }
  changeTag(e) {
    this.tagname = e.target.value;
  }


}