import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {Doctor} from "../../models/doctor";

@Component({
    selector: 'app-doctor-details',
    templateUrl: './doctor-details.component.html',
    styleUrls: ['./doctor-details.component.css']
})
export class DoctorDetailsComponent implements OnInit {

    constructor(
        private dialogRef: MatDialogRef<DoctorDetailsComponent>,
        @Inject(MAT_DIALOG_DATA) public doctor: Doctor
    ) {
    }

    closeDialog() {
        this.dialogRef.close();
    }

    ngOnInit(): void {
    }
}