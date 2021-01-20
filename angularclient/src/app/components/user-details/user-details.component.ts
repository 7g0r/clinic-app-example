import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {User} from "../../models/user";

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {

  constructor(
      private dialogRef: MatDialogRef<UserDetailsComponent>,
      @Inject(MAT_DIALOG_DATA) public user: User
  ) { }

  closeDialog() {
    this.dialogRef.close();
  }

  ngOnInit(): void {
  }
}
