import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {NotificationRetardPremierNiveauAdminService} from 'src/app/shared/service/admin/NotificationPremierNiv/NotificationRetardPremierNiveauAdmin.service';
import {NotificationRetardPremierNiveauDto} from 'src/app/shared/model/NotificationPremierNiv/NotificationRetardPremierNiveau.model';
import {NotificationRetardPremierNiveauCriteria} from 'src/app/shared/criteria/NotificationPremierNiv/NotificationRetardPremierNiveauCriteria.model';


import {LocaleDto} from 'src/app/shared/model/commun/Locale.model';
import {LocaleAdminService} from 'src/app/shared/service/admin/commun/LocaleAdmin.service';
import {RedevableDto} from 'src/app/shared/model/commun/Redevable.model';
import {RedevableAdminService} from 'src/app/shared/service/admin/commun/RedevableAdmin.service';

@Component({
  selector: 'app-notification-retard-premier-niveau-edit-admin',
  templateUrl: './notification-retard-premier-niveau-edit-admin.component.html'
})
export class NotificationRetardPremierNiveauEditAdminComponent extends AbstractEditController<NotificationRetardPremierNiveauDto, NotificationRetardPremierNiveauCriteria, NotificationRetardPremierNiveauAdminService>   implements OnInit {


    private _validNotificationRetardPremierNiveauCode = true;

    private _validLocaleCode = true;
    private _validRedevableCin = true;



    constructor( private notificationRetardPremierNiveauService: NotificationRetardPremierNiveauAdminService , private localeService: LocaleAdminService, private redevableService: RedevableAdminService) {
        super(notificationRetardPremierNiveauService);
    }

    ngOnInit(): void {
        this.locale = new LocaleDto();
        this.localeService.findAll().subscribe((data) => this.locales = data);
        this.redevable = new RedevableDto();
        this.redevableService.findAll().subscribe((data) => this.redevables = data);
    }


    public override setValidation(value: boolean){
        this.validNotificationRetardPremierNiveauCode = value;
        }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateNotificationRetardPremierNiveauCode();
    }
    public validateNotificationRetardPremierNiveauCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validNotificationRetardPremierNiveauCode = false;
        } else {
            this.validNotificationRetardPremierNiveauCode = true;
        }
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
   get createLocaleDialog(): boolean {
       return this.localeService.createDialog;
   }
  set createLocaleDialog(value: boolean) {
       this.localeService.createDialog= value;
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
   get createRedevableDialog(): boolean {
       return this.redevableService.createDialog;
   }
  set createRedevableDialog(value: boolean) {
       this.redevableService.createDialog= value;
   }


    get validNotificationRetardPremierNiveauCode(): boolean {
        return this._validNotificationRetardPremierNiveauCode;
    }
    set validNotificationRetardPremierNiveauCode(value: boolean) {
        this._validNotificationRetardPremierNiveauCode = value;
    }

    get validLocaleCode(): boolean {
        return this._validLocaleCode;
    }
    set validLocaleCode(value: boolean) {
        this._validLocaleCode = value;
    }
    get validRedevableCin(): boolean {
        return this._validRedevableCin;
    }
    set validRedevableCin(value: boolean) {
        this._validRedevableCin = value;
    }
}
