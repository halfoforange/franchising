import {Injectable} from '@angular/core';
import {HttpClient, HttpEvent, HttpHeaders, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";
import {News} from "../entity/news";
import {Instruction} from "../entity/instruction";
import {Dictionary} from "../entity/dictionary";
import "rxjs-compat/add/operator/map";
import "rxjs-compat/add/operator/catch";
import {User} from "../entity/user";
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
        return this.http.get("/api/admin/page/news/" + pageNumber)
    }

    addInstruction(instruction: Instruction): Observable<any> {
        return this.http.post('/api/admin/instruction', instruction)
    }

    getInstructionList(): Observable<any> {
        return this.http.get("/api/admin/page/instruction/")
    }

    addDictionary(entityName: string, dictionary: Dictionary): Observable<any> {
        return this.http.post("/api/admin/dictionary/" + entityName, dictionary);
    }

    pushFileToStorage(multipart: File, description: string): Observable<any> {
        let formdata: FormData = new FormData();
        formdata.append('multipartFile', multipart);
        formdata.append("description", description);

        const req = new HttpRequest('POST', '/api/admin/file', formdata);

        return this.http.request(req);
    }
    register(user: User): Observable<any> {
        return this.http.post('/api/admin/user',user);
    }

/*    getFiles(): Observable<string[]> {
        return this.http.get('/getallfiles')
    }*/

}
