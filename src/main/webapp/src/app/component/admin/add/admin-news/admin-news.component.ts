import { Component, OnInit } from '@angular/core';
import {News} from "../../../../entity/news";
import {AdminService} from "../../../../service/admin.service";

@Component({
  selector: 'app-admin-news',
  templateUrl: './admin-news.component.html',
  styleUrls: ['./admin-news.component.css']
})
export class AdminNewsComponent implements OnInit {
  news: News = new News();
  constructor(private adminService: AdminService) { }
  ngOnInit() {
  }
  addNews() {
    this.adminService.addNews(this.news).subscribe(value => {
    });
  }
}
