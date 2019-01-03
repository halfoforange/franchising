import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AuthenticationComponent} from "./component/authentication/authentication.component";
import {AdminComponent} from "./component/admin/admin/admin.component";
import {CustomerComponent} from "./component/customer/customer/customer.component";

const routes: Routes = [
  {path: '', component: AuthenticationComponent},
  {path: 'admin', component: AdminComponent},
  {path: 'customer', component: CustomerComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class RoutingModule {
}
