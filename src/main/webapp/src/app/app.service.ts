import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AppService {

  authenticated = false;

  constructor(private http: HttpClient) {
  }
  authenticate(user, callback) {

    const headers = new HttpHeaders(user ? {
      authorization : 'Basic ' + btoa(user.email + ':' + user.password)
    } : {});

    this.http.get('/api/user/login', {headers: headers}).subscribe(response => {
      if (response['name']) {
        this.authenticated = true;
      } else {
        this.authenticated = false;
      }
      return callback && callback();
    });

  }
}
