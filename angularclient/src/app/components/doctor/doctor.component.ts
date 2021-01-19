import { Component, OnInit } from '@angular/core';
import {Sort, SortDirection} from "@angular/material/sort";
import {PageEvent} from "@angular/material/paginator";
import {MatDialog} from "@angular/material/dialog";
import {DoctorService} from "../../services/doctor.service";
import {Doctor} from "../../models/doctor";
import {Page} from "../../models/page";

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.css']
})
export class DoctorComponent implements OnInit {
  columnsToDisplay: string[] = ['id', 'name', 'secondName'];
  dataSource: Doctor[] = [];
  page: Page<Doctor> = new Page();
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
      private doctorService: DoctorService,
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

    this.doctorService.getAll(this.page, this.searchParam).subscribe(response => {
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
