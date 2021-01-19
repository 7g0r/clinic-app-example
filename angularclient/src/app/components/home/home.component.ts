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
    columnsToDisplay: string[] = ['id', 'name', 'secondName', 'pin'];
    dataSource: User[] = [];
    page: Page<User> = new Page();
    pageEvent: PageEvent;
    pageIndex: number;
    pageSize: number;
    length: number;
    sort: Sort = new class implements Sort {
        active = 'id';
        direction: SortDirection = 'asc';
    };
    searchParam: string;

    constructor(
        private userService: UserService,
        private dialog: MatDialog
    ) {
    }

   /* @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;*/

    ngOnInit(): void {
        this.page.size = 10;
        this.page.number = 0;
        this.refreshData();
    }

    refreshData(event?: PageEvent): PageEvent {
        if (event) {
            this.page.number = event.pageIndex;
            this.page.size = event.pageSize;
        }

        if (this.sort.direction === '') {
            this.page.isSorted = false;
        } else {
            this.page.isSorted = true;
        }
        this.page.sortedBy = this.sort.active;
        this.page.dir = this.sort.direction;

        this.userService.getAll(this.page, this.searchParam).subscribe(response => {
                this.page.fromResponse(response);
                this.dataSource = response.content;
                this.pageIndex = response.number;
                this.pageSize = response.size;
                this.length = response.totalElements;
            }
        );
        return event;
    }

    sortData(sort: Sort): void {
        this.sort = sort;
        this.refreshData();
    }

}
