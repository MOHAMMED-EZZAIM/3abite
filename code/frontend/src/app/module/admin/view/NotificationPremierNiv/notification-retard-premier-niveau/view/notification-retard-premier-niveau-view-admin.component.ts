import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {NotificationRetardPremierNiveauAdminService} from 'src/app/shared/service/admin/NotificationPremierNiv/NotificationRetardPremierNiveauAdmin.service';
import {NotificationRetardPremierNiveauDto} from 'src/app/shared/model/NotificationPremierNiv/NotificationRetardPremierNiveau.model';
import {NotificationRetardPremierNiveauCriteria} from 'src/app/shared/criteria/NotificationPremierNiv/NotificationRetardPremierNiveauCriteria.model';

import {LocaleDto} from 'src/app/shared/model/commun/Locale.model';
import {LocaleAdminService} from 'src/app/shared/service/admin/commun/LocaleAdmin.service';
import {RedevableDto} from 'src/app/shared/model/commun/Redevable.model';
import {RedevableAdminService} from 'src/app/shared/service/admin/commun/RedevableAdmin.service';
@Component({
  selector: 'app-notification-retard-premier-niveau-view-admin',
  templateUrl: './notification-retard-premier-niveau-view-admin.component.html'
})
export class NotificationRetardPremierNiveauViewAdminComponent extends AbstractViewController<NotificationRetardPremierNiveauDto, NotificationRetardPremierNiveauCriteria, NotificationRetardPremierNiveauAdminService> implements OnInit {


    constructor(private notificationRetardPremierNiveauService: NotificationRetardPremierNiveauAdminService, private localeService: LocaleAdminService, private redevableService: RedevableAdminService){
        super(notificationRetardPremierNiveauService);
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
