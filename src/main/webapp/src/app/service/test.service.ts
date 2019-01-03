import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
@Injectable({
  providedIn: 'root'
})
export class TestService {
  constructor(private http: HttpClient) {
  }

  testAdmin() {
    return this.http.get("/api/admin")
  }

  testCustomer() {
    return this.http.get("/api/customer")
  }
}
