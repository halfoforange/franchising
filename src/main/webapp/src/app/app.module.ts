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
import {AdminComponent} from './component/admin/admin.component';
import {CustomerComponent} from './component/customer/customer/customer.component';
import {HeaderComponent} from './component/admin/header/header.component';
import {FooterComponent} from './component/admin/footer/footer.component';
import { AdminAddComponent } from './component/admin/add/admin-add.component';
import { AdminNewsComponent } from './component/admin/add/admin-news/admin-news.component';
import { AdminInstructionComponent } from './component/admin/add/admin-instruction/admin-instruction.component';
import { AdminCalendarComponent } from './component/admin/add/admin-calendar/admin-calendar.component';
import { AdminNewsListComponent } from './component/admin/admin-news-list/admin-news-list.component';
import { AdminInstructionListComponent } from './component/admin/admin-instruction-list/admin-instruction-list.component';
import { AdminDictionaryComponent } from './component/admin/add/admin-dictionary/admin-dictionary.component';
import { AdminFileComponent } from './component/admin/add/admin-file/admin-file.component';
import { AdminUserComponent } from './component/admin/add/admin-user/admin-user.component';

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
        AdminComponent,
        CustomerComponent,
        HeaderComponent,
        FooterComponent,
        AdminAddComponent,
        AdminNewsComponent,
        AdminInstructionComponent,
        AdminCalendarComponent,
        AdminNewsListComponent,
        AdminInstructionListComponent,
        AdminDictionaryComponent,
        AuthenticationComponent,
        AdminFileComponent,
        AdminUserComponent,
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

