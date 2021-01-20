import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatDialogModule} from "@angular/material/dialog";
import {MatIconModule} from "@angular/material/icon";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {ReactiveFormsModule} from "@angular/forms";
import {MatGridListModule} from "@angular/material/grid-list";
import {MatSnackBarModule} from "@angular/material/snack-bar";
import {MatCardModule} from "@angular/material/card";
import {MatSelectModule} from "@angular/material/select";
import {MatSortModule} from "@angular/material/sort";
import {HttpClientModule} from "@angular/common/http";
import {MatTableModule} from "@angular/material";
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatButtonModule} from "@angular/material/button";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatMenuModule} from "@angular/material/menu";
import {AppComponent} from "./app.component";
import {HomeComponent} from './components/home/home.component';
import {RouterModule} from "@angular/router";
import {UserService} from "./services/user.service";
import {DoctorService} from "./services/doctor.service";
import {DoctorComponent} from './components/doctor/doctor.component';
import {NavbarComponent} from './components/navbar/navbar.component';
import {UserComponent} from './components/user/user.component';
import {VisitComponent} from './components/visit/visit.component';
import {ConfirmDialogComponent} from './components/confirm-dialog/confirm-dialog.component';
import {UserDetailsComponent} from './components/user-details/user-details.component';
import {DoctorDetailsComponent} from './components/doctor-details/doctor-details.component';
import {VisitService} from "./services/visit.service";
import {AppDateAdapter} from "./utils/AppDateAdapter";
import {VisitCreateComponent} from './components/visit-create/visit-create.component';


@NgModule({
    declarations: [
        AppComponent,
        HomeComponent,
        DoctorComponent,
        NavbarComponent,
        UserComponent,
        VisitComponent,
        ConfirmDialogComponent,
        UserDetailsComponent,
        DoctorDetailsComponent,
        VisitCreateComponent,

    ],
    imports: [
        /*FormsModule,
        ReactiveFormsModule,
        MatDatepickerModule,
        MatInputModule,
        NgxMatDatetimePickerModule,
        NgxMatTimepickerModule,
        NgxMatNativeDateModule,*/
        BrowserModule,
        BrowserAnimationsModule,
        MatIconModule,
        MatDialogModule,
        MatMenuModule,
        MatToolbarModule,
        MatButtonModule,
        MatIconModule,
        MatPaginatorModule,
        MatFormFieldModule,
        MatTableModule,
        HttpClientModule,
        MatSortModule,
        MatInputModule,
        MatSelectModule,
        ReactiveFormsModule,
        MatCardModule,
        MatGridListModule,
        MatSnackBarModule,
        RouterModule.forRoot([
            {path: 'home', component: HomeComponent},
            {path: '', redirectTo: 'home', pathMatch: 'full'},
            {path: 'users', component: UserComponent},
            {path: 'doctors', component: DoctorComponent},
            {path: 'visits', component: VisitComponent},
            {path: 'visits/create', component: VisitCreateComponent}
        ])
    ],
    entryComponents: [
        UserDetailsComponent,
        DoctorDetailsComponent
    ],
    providers:
        [UserService,
            DoctorService,
            VisitService,
            AppDateAdapter,
            VisitCreateComponent,
            HttpClientModule
        ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
