import {Component, Input} from '@angular/core';
/*import {User} from '../entity/user';
import {AuthenticationService} from '../service/authentication.service';*/
import {Router} from '@angular/router';
import {AppService} from "../../app.service";
import {AuthenticationService} from "../../service/authentication.service";
import {User} from "../../entity/user";

@Component({
  selector: 'app-authentication',
  templateUrl: './authentication.component.html',
  styleUrls: ['./authentication.component.css']
})
export class AuthenticationComponent {
  @Input() user: User = new User();
  public LoginActive = 'form-active';
  public RegisterActive = 'form-not-active';
  public RegisterSuccess = 'form-not-active';

  constructor(private authService: AuthenticationService, private app: AppService, private router: Router) {
  }

  register() {
    this.authService.register(this.user).subscribe(value => {
      this.showRegister();
      this.showRegisterSuccess();
    });
  }

  login() {
    this.app.authenticate(this.user, callback =>
      {
        this.router.navigateByUrl('/patient');}
    );
  }

  showRegister() {
    if (this.RegisterActive === 'form-not-active') {
      this.RegisterActive = 'form-active';
      this.LoginActive = 'form-not-active';
    } else {
      this.RegisterActive = 'form-not-active';
      this.LoginActive = 'form-active';
    }
    this.RegisterSuccess = 'form-not-active';
  }

  showRegisterSuccess() {
    this.RegisterSuccess = 'form-active';
  }
}

