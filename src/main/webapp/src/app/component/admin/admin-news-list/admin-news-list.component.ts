import {Component, OnInit} from '@angular/core';
import {AdminService} from "../../../service/admin.service";
import {ActivatedRoute, NavigationEnd, Router} from "@angular/router";
import {NewsList} from "../../../entity/news";

@Component({
    selector: 'app-admin-news-list',
    templateUrl: './admin-news-list.component.html',
    styleUrls: ['./admin-news-list.component.css']
})
export class AdminNewsListComponent implements OnInit {
    list: NewsList;
    pages: number[];

    constructor(private adminService: AdminService, private route: ActivatedRoute, private router: Router) {
    }

    ngOnInit() {
        this.router.events.subscribe((val) => {
            // see also
            if (val instanceof NavigationEnd) {
                this.getNewsList();
            }
        });
        this.getNewsList()
    }

    getNewsList() {
        this.adminService.getNewsList(this.route.snapshot.params['pageNumber']).subscribe(value => {
            this.list = value;
            console.log(this.list);
            console.log(this.list.totalPages);
            // @ts-ignore
            this.pages = Array(this.list.totalPages).fill().map((x, i) => i + 1); // [0,1,2,3,4]
            console.log(this.pages);
        });
    }
}
