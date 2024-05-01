import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {NotificationRetardDeuxiemeNiveauDetailAdminService} from 'src/app/shared/service/admin/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveauDetailAdmin.service';
import {NotificationRetardDeuxiemeNiveauDetailDto} from 'src/app/shared/model/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveauDetail.model';
import {NotificationRetardDeuxiemeNiveauDetailCriteria} from 'src/app/shared/criteria/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveauDetailCriteria.model';

import {TrimDto} from 'src/app/shared/model/taxe38/Trim.model';
import {TrimAdminService} from 'src/app/shared/service/admin/taxe38/TrimAdmin.service';
@Component({
  selector: 'app-notification-retard-deuxieme-niveau-detail-view-admin',
  templateUrl: './notification-retard-deuxieme-niveau-detail-view-admin.component.html'
})
export class NotificationRetardDeuxiemeNiveauDetailViewAdminComponent extends AbstractViewController<NotificationRetardDeuxiemeNiveauDetailDto, NotificationRetardDeuxiemeNiveauDetailCriteria, NotificationRetardDeuxiemeNiveauDetailAdminService> implements OnInit {


    constructor(private notificationRetardDeuxiemeNiveauDetailService: NotificationRetardDeuxiemeNiveauDetailAdminService, private trimService: TrimAdminService){
        super(notificationRetardDeuxiemeNiveauDetailService);
    }

    ngOnInit(): void {
    }


    get trim(): TrimDto {
       return this.trimService.item;
    }
    set trim(value: TrimDto) {
        this.trimService.item = value;
    }
    get trims(): Array<TrimDto> {
       return this.trimService.items;
    }
    set trims(value: Array<TrimDto>) {
        this.trimService.items = value;
    }


}
