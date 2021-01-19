import {Component, OnInit, ViewChild} from '@angular/core';
import {UserService} from "../../services/user.service";
import {MatDialog} from "@angular/material/dialog";
import {User} from "../../models/user";
import {Page} from "../../models/page";
import {MatPaginator, PageEvent} from "@angular/material/paginator";
import {Sort, SortDirection} from "@angular/material/sort";

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

    constructor() { }

    ngOnInit() {
    }


}
