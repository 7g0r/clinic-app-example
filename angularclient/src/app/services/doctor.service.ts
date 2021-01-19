import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AppSettings} from "../utils/app-settings";
import {Page} from "../models/page";
import {User} from "../models/user";
import {Observable} from "rxjs";
import {Doctor} from "../models/doctor";

@Injectable()
export class DoctorService {
    private readonly API_URL: string;

    constructor(private httpClient: HttpClient) {
        this.API_URL = AppSettings.API_ENDPOINT + '/doctors'
    }

    public getAll(page: Page<Doctor>, search: string = ''): Observable<Page<Doctor>> {
        return this.httpClient.get<Page<Doctor>>(this.API_URL + page.buildPageableUrl(), {withCredentials: true});
    }

    public getById(id: number): Observable<Doctor> {
        return this.httpClient.get<Doctor>(this.API_URL + '/' + id, {withCredentials: true});
    }

    public save(doctor: Doctor): Observable<Doctor> {
        return this.httpClient.post<Doctor>(this.API_URL, Doctor, {withCredentials: true});
    }

    public update(doctor: Doctor): Observable<Doctor> {
        return this.httpClient.put<Doctor>(this.API_URL + '/' + doctor.id, doctor, {withCredentials: true});
    }

    public delete(id: number): Observable<Doctor> {
        return this.httpClient.delete<Doctor>(this.API_URL + '/' + id);
    }
}
