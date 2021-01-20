import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AppSettings} from "../utils/app-settings";
import {Page} from "../models/page";
import {User} from "../models/user";
import {Observable} from "rxjs";
import {Visit} from "../models/visit";

@Injectable()
export class VisitService {
  private readonly API_URL: string;

  constructor(private httpClient: HttpClient) {
    this.API_URL = AppSettings.API_ENDPOINT + '/visits'
  }

  public getAll(page: Page<Visit>, search: string = ''): Observable<Page<Visit>> {
    return this.httpClient.get<Page<Visit>>(this.API_URL + page.buildPageableUrl(), {withCredentials: true});
  }

  public getById(id: number): Observable<Visit> {
    return this.httpClient.get<Visit>(this.API_URL + '/' + id, {withCredentials: true});
  }

  public save(visit: Visit): Observable<Visit> {
    return this.httpClient.post<Visit>(this.API_URL, visit, {withCredentials: true});
  }

  public update(visit: Visit): Observable<User> {
    return this.httpClient.put<User>(this.API_URL + '/' + visit.id, visit, {withCredentials: true});
  }

  public delete(id: number): Observable<Visit> {
    return this.httpClient.delete<Visit>(this.API_URL + '/' + id);
  }
  formatDate(date:Date):string{
    const day = date.getDate();
    const month = date.getMonth()+1;
    const year = date.getFullYear();

    return '${year}-${month}-${day}';
  }
}
