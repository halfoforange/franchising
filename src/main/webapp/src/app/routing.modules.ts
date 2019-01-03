import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AuthenticationComponent} from "./component/authentication/authentication.component";
import {AdminComponent} from "./component/admin/admin.component";
import {CustomerComponent} from "./component/customer/customer/customer.component";
import {AdminAddComponent} from "./component/admin/add/admin-add.component";
import {AdminNewsComponent} from "./component/admin/add/admin-news/admin-news.component";
import {AdminNewsListComponent} from "./component/admin/admin-news-list/admin-news-list.component";
import {AdminInstructionListComponent} from "./component/admin/admin-instruction-list/admin-instruction-list.component";
import {AdminInstructionComponent} from "./component/admin/add/admin-instruction/admin-instruction.component";
import {AdminCalendarComponent} from "./component/admin/add/admin-calendar/admin-calendar.component";

const routes: Routes = [
    {path: '', component: AuthenticationComponent},
    {
        path: 'admin', component: AdminComponent, children: [
            {path: '', redirectTo: 'news', pathMatch: 'full'},
            {path: "news", redirectTo: "news/1", pathMatch: 'full'},
            {path: "news/:pageNumber", component: AdminNewsListComponent},
            {path: "instruction", component: AdminInstructionListComponent},
            {
                path: "add", component: AdminAddComponent, children: [
                    {path: '', redirectTo: 'news', pathMatch: 'full'},
                    {path: "news", component: AdminNewsComponent},
                    {path: "instruction", component: AdminInstructionComponent},
                    {path: "calendar", component: AdminCalendarComponent}
                ]
            }
        ]
    },
    {path: 'customer', component: CustomerComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class RoutingModule {
}
