import { User } from './user';
import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EnrollmentService {


  url ='http://localhost:8080/add'
  constructor(private _http : HttpClient) { }


  enroll(user : User )
  {
    return this._http.post<any>(this.url , user) ;

  }
}
