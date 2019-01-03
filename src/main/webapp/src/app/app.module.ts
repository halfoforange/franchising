import {BrowserModule} from '@angular/platform-browser';
import {Injectable, NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {RoutingModule} from "./routing.modules";
import {AuthenticationComponent} from "./component/authentication/authentication.component";
import {
  HTTP_INTERCEPTORS,
  HttpClient,
  HttpClientModule, HttpErrorResponse, HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest
} from "@angular/common/http";
import 'rxjs/add/operator/do';
import {AppService} from "./app.service";
import {FormsModule} from "@angular/forms";
import {TestService} from "./service/test.service";
import {Router} from "@angular/router";

//TODO глобальную обработку exceptions на фронте
@Injectable()
export class XhrInterceptor implements HttpInterceptor {
  constructor(private router: Router) {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    const xhr = req.clone({
      headers: req.headers.set('X-Requested-With', 'XMLHttpRequest')
    });
    return next.handle(xhr).do((event: HttpEvent<any>) => {
    }, (err: any) => {
      if (err instanceof HttpErrorResponse) {
        if (err.status === 401) this.router.navigateByUrl('/')
      }
    });
  }
}

@NgModule({
  declarations: [
    AppComponent,
    AuthenticationComponent,
  ],
  imports: [
    BrowserModule,
    RoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [AppService, {provide: HTTP_INTERCEPTORS, useClass: XhrInterceptor, multi: true}, TestService],
  bootstrap: [AppComponent]
})
export class AppModule {
}

