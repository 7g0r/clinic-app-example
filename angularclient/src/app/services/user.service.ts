import { Injectable } from '@angular/core';
import {AppSettings} from "../utils/app-settings";
import {HttpClient} from "@angular/common/http";
import {Page} from "../models/page";
import {User} from "../models/user";
import {Observable} from "rxjs";


@Injectable()
export class UserService {

  private readonly API_URL: string;

  constructor(private httpClient: HttpClient) {
    this.API_URL = AppSettings.API_ENDPOINT + '/users'
  }

  public getAll(page: Page<User>, search: string = ''): Observable<Page<User>> {
    return this.httpClient.get<Page<User>>(this.API_URL + page.buildPageableUrl(), {withCredentials: true});
  }

  public getById(id: number): Observable<User> {
    return this.httpClient.get<User>(this.API_URL + '/' + id, {withCredentials: true});
  }

  public save(user: User): Observable<User> {
    return this.httpClient.post<User>(this.API_URL, user, {withCredentials: true});
  }

  public update(user: User): Observable<User> {
    return this.httpClient.put<User>(this.API_URL + '/' + user.id, user, {withCredentials: true});
  }

  public delete(id: number): Observable<User> {
    return this.httpClient.delete<User>(this.API_URL + '/' + id);
  }
}
