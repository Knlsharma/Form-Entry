import { Component } from '@angular/core';
import { User } from './user';
import { Address } from './address';
import { EnrollmentService} from './enrollment.service'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'forms';

//   userMode = new User (21 , "kunal " , "xyz@gmail.com" , "D-45" ,"near chowki" , "GHZ" , 201011 , "UP")

   // constructor(private _enrollmentService :  EnrollmentService){}

 
   addressModel = new Address(null,'','','',null,'');
   userMode = new User(null,'','',[]);

   constructor(private _enrollmentService: EnrollmentService){}

onsubmit()
{

  this.userMode.address.push(this.addressModel);

//  console.log(this.userMode);
var comp = this;
this._enrollmentService.enroll(this.userMode)
.subscribe (
  (data) =>  
    {
      console.log('success' , data) ;
      comp.addressModel = new Address(null,'','','',null,'');
      comp.userMode = new User(null,'','',[]);
    } ,
  error => console.error('fail' , error)

   
   
 
   )



}


}
