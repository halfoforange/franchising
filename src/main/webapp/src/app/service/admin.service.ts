import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {News} from "../entity/news";

@Injectable({
    providedIn: 'root'
})
export class AdminService {

    constructor(private http: HttpClient) {
    }

    addNews(news: News): Observable<any> {
        return this.http.post('/api/admin/news', news);
    }

    getNewsList(pageNumber: number): Observable<any> {
        return this.http.get("/api/admin/page/news/"+pageNumber)
    }
}
