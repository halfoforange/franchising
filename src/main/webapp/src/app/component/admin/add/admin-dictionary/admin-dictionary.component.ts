import {Component, OnInit} from '@angular/core';
import {AdminService} from "../../../../service/admin.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Dictionary} from "../../../../entity/dictionary";

@Component({
    selector: 'app-admin-dictionary',
    templateUrl: './admin-dictionary.component.html',
    styleUrls: ['./admin-dictionary.component.css']
})
export class AdminDictionaryComponent implements OnInit {
    entityName: string;
    dictionary: Dictionary = new Dictionary();

    constructor(private adminService: AdminService, private route: ActivatedRoute, private router: Router) {
    }

    ngOnInit() {
    }

    addDictionary() {
        this.adminService.addDictionary(this.route.snapshot.params['entityName'], this.dictionary).subscribe(value => {

        });
    }
}
