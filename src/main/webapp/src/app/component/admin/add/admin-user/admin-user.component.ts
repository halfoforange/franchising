import {Component, OnInit} from '@angular/core';
import {User} from "../../../../entity/user";
import {Dictionary} from "../../../../entity/dictionary";
import {DictionaryService} from "../../../../service/dictionary.service";
import {AdminService} from "../../../../service/admin.service";

@Component({
    selector: 'app-admin-user',
    templateUrl: './admin-user.component.html',
    styleUrls: ['./admin-user.component.css']
})
export class AdminUserComponent implements OnInit {
    user: User = new User();
    pointTypes: Dictionary[] = [];
    cities: Dictionary[] = [];

    constructor(private dictionaryService: DictionaryService, private adminService: AdminService) {
    }

    ngOnInit() {

        this.dictionaryService.getPointType().subscribe(value => this.pointTypes = value);
        this.dictionaryService.getCities().subscribe(value => this.cities = value);
    }

    registerUser() {
        this.adminService.register(this.user).subscribe(value => console.log(value));
    }
}
