import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
    providedIn: 'root'
})
export class DictionaryService {
    private DICTIONARY_PREFIX = '/api/dictionary/';

    constructor(private http: HttpClient) {
    }

    getCategories(): Observable<any> {
        return this.http.get(this.DICTIONARY_PREFIX + 'Category');
    }

    getCities(): Observable<any> {
        return this.http.get(this.DICTIONARY_PREFIX + 'City');
    }

    getPointType(): Observable<any> {
        return this.http.get(this.DICTIONARY_PREFIX+ 'PointType')
    }
}
