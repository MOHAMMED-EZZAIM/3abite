import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {ToastModule} from 'primeng/toast';
import {ToolbarModule} from 'primeng/toolbar';
import {TableModule} from 'primeng/table';
import {DropdownModule} from 'primeng/dropdown';
import {InputSwitchModule} from 'primeng/inputswitch';
import {InputTextareaModule} from 'primeng/inputtextarea';

import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { DialogModule } from 'primeng/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CalendarModule} from 'primeng/calendar';
import {PanelModule} from 'primeng/panel';
import {InputNumberModule} from 'primeng/inputnumber';
import {BadgeModule} from 'primeng/badge';
import { MultiSelectModule } from 'primeng/multiselect';
import {TranslateModule} from '@ngx-translate/core';
import {FileUploadModule} from 'primeng/fileupload';
import {FullCalendarModule} from '@fullcalendar/angular';
import {CardModule} from "primeng/card";

import { NotificationRetardTroisiemeNiveauCreateAdminComponent } from './notification-retard-troisieme-niveau/create/notification-retard-troisieme-niveau-create-admin.component';
import { NotificationRetardTroisiemeNiveauEditAdminComponent } from './notification-retard-troisieme-niveau/edit/notification-retard-troisieme-niveau-edit-admin.component';
import { NotificationRetardTroisiemeNiveauViewAdminComponent } from './notification-retard-troisieme-niveau/view/notification-retard-troisieme-niveau-view-admin.component';
import { NotificationRetardTroisiemeNiveauListAdminComponent } from './notification-retard-troisieme-niveau/list/notification-retard-troisieme-niveau-list-admin.component';

import { PasswordModule } from 'primeng/password';
import { InputTextModule } from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {TabViewModule} from 'primeng/tabview';
import { SplitButtonModule } from 'primeng/splitbutton';
import { MessageModule } from 'primeng/message';
import {MessagesModule} from 'primeng/messages';
import {PaginatorModule} from 'primeng/paginator';



@NgModule({
  declarations: [

    NotificationRetardTroisiemeNiveauCreateAdminComponent,
    NotificationRetardTroisiemeNiveauListAdminComponent,
    NotificationRetardTroisiemeNiveauViewAdminComponent,
    NotificationRetardTroisiemeNiveauEditAdminComponent,
  ],
  imports: [
    CommonModule,
    ToastModule,
    ToolbarModule,
    TableModule,
    ConfirmDialogModule,
    DialogModule,
    PasswordModule,
    InputTextModule,
    ButtonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    SplitButtonModule,
    BrowserAnimationsModule,
    DropdownModule,
    TabViewModule,
    InputSwitchModule,
    InputTextareaModule,
    CalendarModule,
    PanelModule,
    MessageModule,
    MessagesModule,
    InputNumberModule,
    BadgeModule,
    MultiSelectModule,
    PaginatorModule,
    TranslateModule,
    FileUploadModule,
    FullCalendarModule,
    CardModule,

  ],
  exports: [
  NotificationRetardTroisiemeNiveauCreateAdminComponent,
  NotificationRetardTroisiemeNiveauListAdminComponent,
  NotificationRetardTroisiemeNiveauViewAdminComponent,
  NotificationRetardTroisiemeNiveauEditAdminComponent,
  ],
})
export class NotificationRetardTroisiemeNivAdminModule { }
