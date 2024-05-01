import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {NotificationRetardTroisiemeNiveauAdminService} from 'src/app/shared/service/admin/NotificationRetardTroisiemeNiv/NotificationRetardTroisiemeNiveauAdmin.service';
import {NotificationRetardTroisiemeNiveauDto} from 'src/app/shared/model/NotificationRetardTroisiemeNiv/NotificationRetardTroisiemeNiveau.model';
import {NotificationRetardTroisiemeNiveauCriteria} from 'src/app/shared/criteria/NotificationRetardTroisiemeNiv/NotificationRetardTroisiemeNiveauCriteria.model';

import {LocaleDto} from 'src/app/shared/model/commun/Locale.model';
import {LocaleAdminService} from 'src/app/shared/service/admin/commun/LocaleAdmin.service';
import {TrimDto} from 'src/app/shared/model/taxe38/Trim.model';
import {TrimAdminService} from 'src/app/shared/service/admin/taxe38/TrimAdmin.service';
import {RedevableDto} from 'src/app/shared/model/commun/Redevable.model';
import {RedevableAdminService} from 'src/app/shared/service/admin/commun/RedevableAdmin.service';
@Component({
  selector: 'app-notification-retard-troisieme-niveau-view-admin',
  templateUrl: './notification-retard-troisieme-niveau-view-admin.component.html'
})
export class NotificationRetardTroisiemeNiveauViewAdminComponent extends AbstractViewController<NotificationRetardTroisiemeNiveauDto, NotificationRetardTroisiemeNiveauCriteria, NotificationRetardTroisiemeNiveauAdminService> implements OnInit {


    constructor(private notificationRetardTroisiemeNiveauService: NotificationRetardTroisiemeNiveauAdminService, private localeService: LocaleAdminService, private trimService: TrimAdminService, private redevableService: RedevableAdminService){
        super(notificationRetardTroisiemeNiveauService);
    }

    ngOnInit(): void {
    }


    get locale(): LocaleDto {
       return this.localeService.item;
    }
    set locale(value: LocaleDto) {
        this.localeService.item = value;
    }
    get locales(): Array<LocaleDto> {
       return this.localeService.items;
    }
    set locales(value: Array<LocaleDto>) {
        this.localeService.items = value;
    }
    get redevable(): RedevableDto {
       return this.redevableService.item;
    }
    set redevable(value: RedevableDto) {
        this.redevableService.item = value;
    }
    get redevables(): Array<RedevableDto> {
       return this.redevableService.items;
    }
    set redevables(value: Array<RedevableDto>) {
        this.redevableService.items = value;
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
