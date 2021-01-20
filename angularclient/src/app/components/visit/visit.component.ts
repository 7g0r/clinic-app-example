import {Component, OnInit} from '@angular/core';
import {Visit} from "../../models/visit";
import {Page} from "../../models/page";
import {PageEvent} from "@angular/material/paginator";
import {Sort, SortDirection} from "@angular/material/sort";
import {MatDialog} from "@angular/material/dialog";
import {DoctorService} from "../../services/doctor.service";
import {UserService} from "../../services/user.service";
import {VisitService} from "../../services/visit.service";
import {ConfirmDialogComponent} from "../confirm-dialog/confirm-dialog.component";
import {UserDetailsComponent} from "../user-details/user-details.component";
import {DoctorDetailsComponent} from "../doctor-details/doctor-details.component";
import {ActivatedRoute} from "@angular/router";


@Component({
    selector: 'app-visit',
    templateUrl: './visit.component.html',
    styleUrls: ['./visit.component.css'],
    providers:[UserService, DoctorService, VisitService]
})
export class VisitComponent implements OnInit {
    today: number = Date.now();
    columnsToDisplay: string[] = ['id', 'doctor', 'user', 'status', 'visitDate'];
    dataSource: Visit[] = [];
    page: Page<Visit> = new Page();
    pageEvent: PageEvent;
    pageIndex: number;
    pageSize: number;
    length: number;
    sort: Sort = new class implements Sort {
        active = 'id';
        direction: SortDirection = 'asc';
    };
    searchParam: string;
    productsMap: Map<number, boolean> = new Map<number, boolean>();


    constructor(
        private route: ActivatedRoute,
        private dialog: MatDialog,
        private doctorService: DoctorService,
        private userService: UserService,
        private visitService: VisitService
    ) {
    }

    /*@ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;*/

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

        this.visitService.getAll(this.page).subscribe(response => {
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

    applyFilter(event: KeyboardEvent): void {
        if (event.key === 'Enter') {
            const filterValue = (event.target as HTMLInputElement).value;
            this.refreshData();
            this.visitService.getAll(this.page).subscribe(response => {
                    this.dataSource = response.content;
                }
            );
        }
    }

    deleteVisit(visit: Visit) {
        const dialogRef = this.dialog.open(ConfirmDialogComponent, {
                data: {
                    message: 'delete this visit'
                }
            }
        );
        dialogRef.afterClosed().subscribe(result => {
            if (result) {
                this.visitService.delete(visit.id).subscribe(
                    () => {
                        this.refreshData();
                    }
                );
            }
        });
    }


    getProductsByOrderId(visitId: number) {
        this.productsMap.clear();
        this.productsMap.set(visitId, true);
    }

    hideVisit(id: number) {
        this.productsMap.set(id, false);
    }

    openUserDetails(userId: number) {
        let user;
        this.userService.getById(userId).subscribe(
            result => {
                user = result;
                this.dialog.open(UserDetailsComponent, {
                    data: {
                        id: user.id,
                        name: user.name,
                        secondName: user.secondName,
                        pin: user.pin
                    }
                });
            }
        )

    }

    openDoctorDetails(doctorId: number) {
        let doctor;
        this.doctorService.getById(doctorId).subscribe(
            result => {
                doctor = result;
                this.dialog.open(DoctorDetailsComponent, {
                    data: {
                        id: doctor.id,
                        name: doctor.name,
                        secondName: doctor.secondName
                    }
                });
            }
        )

    }
}
