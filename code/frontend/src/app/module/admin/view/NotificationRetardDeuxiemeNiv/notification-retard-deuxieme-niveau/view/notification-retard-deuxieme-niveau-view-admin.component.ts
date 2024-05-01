import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {NotificationRetardDeuxiemeNiveauAdminService} from 'src/app/shared/service/admin/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveauAdmin.service';
import {NotificationRetardDeuxiemeNiveauDto} from 'src/app/shared/model/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveau.model';
import {NotificationRetardDeuxiemeNiveauCriteria} from 'src/app/shared/criteria/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveauCriteria.model';

import {LocaleDto} from 'src/app/shared/model/commun/Locale.model';
import {LocaleAdminService} from 'src/app/shared/service/admin/commun/LocaleAdmin.service';
import {RedevableDto} from 'src/app/shared/model/commun/Redevable.model';
import {RedevableAdminService} from 'src/app/shared/service/admin/commun/RedevableAdmin.service';
@Component({
  selector: 'app-notification-retard-deuxieme-niveau-view-admin',
  templateUrl: './notification-retard-deuxieme-niveau-view-admin.component.html'
})
export class NotificationRetardDeuxiemeNiveauViewAdminComponent extends AbstractViewController<NotificationRetardDeuxiemeNiveauDto, NotificationRetardDeuxiemeNiveauCriteria, NotificationRetardDeuxiemeNiveauAdminService> implements OnInit {


    constructor(private notificationRetardDeuxiemeNiveauService: NotificationRetardDeuxiemeNiveauAdminService, private localeService: LocaleAdminService, private redevableService: RedevableAdminService){
        super(notificationRetardDeuxiemeNiveauService);
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


}
