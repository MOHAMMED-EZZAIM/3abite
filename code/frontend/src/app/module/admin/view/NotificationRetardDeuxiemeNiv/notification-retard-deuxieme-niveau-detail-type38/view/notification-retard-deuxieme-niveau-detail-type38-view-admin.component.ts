import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {NotificationRetardDeuxiemeNiveauDetailType38AdminService} from 'src/app/shared/service/admin/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveauDetailType38Admin.service';
import {NotificationRetardDeuxiemeNiveauDetailType38Dto} from 'src/app/shared/model/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveauDetailType38.model';
import {NotificationRetardDeuxiemeNiveauDetailType38Criteria} from 'src/app/shared/criteria/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveauDetailType38Criteria.model';

import {TypeLocale38DetailDto} from 'src/app/shared/model/taxe38/TypeLocale38Detail.model';
import {TypeLocale38DetailAdminService} from 'src/app/shared/service/admin/taxe38/TypeLocale38DetailAdmin.service';
@Component({
  selector: 'app-notification-retard-deuxieme-niveau-detail-type38-view-admin',
  templateUrl: './notification-retard-deuxieme-niveau-detail-type38-view-admin.component.html'
})
export class NotificationRetardDeuxiemeNiveauDetailType38ViewAdminComponent extends AbstractViewController<NotificationRetardDeuxiemeNiveauDetailType38Dto, NotificationRetardDeuxiemeNiveauDetailType38Criteria, NotificationRetardDeuxiemeNiveauDetailType38AdminService> implements OnInit {


    constructor(private notificationRetardDeuxiemeNiveauDetailType38Service: NotificationRetardDeuxiemeNiveauDetailType38AdminService, private typeLocale38DetailService: TypeLocale38DetailAdminService){
        super(notificationRetardDeuxiemeNiveauDetailType38Service);
    }

    ngOnInit(): void {
    }


    get typeLocale38(): TypeLocale38DetailDto {
       return this.typeLocale38DetailService.item;
    }
    set typeLocale38(value: TypeLocale38DetailDto) {
        this.typeLocale38DetailService.item = value;
    }
    get typeLocale38s(): Array<TypeLocale38DetailDto> {
       return this.typeLocale38DetailService.items;
    }
    set typeLocale38s(value: Array<TypeLocale38DetailDto>) {
        this.typeLocale38DetailService.items = value;
    }


}
