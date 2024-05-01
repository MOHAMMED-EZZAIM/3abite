import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {NotificationRetardDeuxiemeNiveauAdminService} from 'src/app/shared/service/admin/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveauAdmin.service';
import {NotificationRetardDeuxiemeNiveauDto} from 'src/app/shared/model/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveau.model';
import {NotificationRetardDeuxiemeNiveauCriteria} from 'src/app/shared/criteria/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveauCriteria.model';


import {LocaleDto} from 'src/app/shared/model/commun/Locale.model';
import {LocaleAdminService} from 'src/app/shared/service/admin/commun/LocaleAdmin.service';
import {RedevableDto} from 'src/app/shared/model/commun/Redevable.model';
import {RedevableAdminService} from 'src/app/shared/service/admin/commun/RedevableAdmin.service';

@Component({
  selector: 'app-notification-retard-deuxieme-niveau-edit-admin',
  templateUrl: './notification-retard-deuxieme-niveau-edit-admin.component.html'
})
export class NotificationRetardDeuxiemeNiveauEditAdminComponent extends AbstractEditController<NotificationRetardDeuxiemeNiveauDto, NotificationRetardDeuxiemeNiveauCriteria, NotificationRetardDeuxiemeNiveauAdminService>   implements OnInit {


    private _validNotificationRetardDeuxiemeNiveauCode = true;

    private _validLocaleCode = true;
    private _validRedevableCin = true;



    constructor( private notificationRetardDeuxiemeNiveauService: NotificationRetardDeuxiemeNiveauAdminService , private localeService: LocaleAdminService, private redevableService: RedevableAdminService) {
        super(notificationRetardDeuxiemeNiveauService);
    }

    ngOnInit(): void {
        this.locale = new LocaleDto();
        this.localeService.findAll().subscribe((data) => this.locales = data);
        this.redevable = new RedevableDto();
        this.redevableService.findAll().subscribe((data) => this.redevables = data);
    }


    public override setValidation(value: boolean){
        this.validNotificationRetardDeuxiemeNiveauCode = value;
        }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateNotificationRetardDeuxiemeNiveauCode();
    }
    public validateNotificationRetardDeuxiemeNiveauCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validNotificationRetardDeuxiemeNiveauCode = false;
        } else {
            this.validNotificationRetardDeuxiemeNiveauCode = true;
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


    get validNotificationRetardDeuxiemeNiveauCode(): boolean {
        return this._validNotificationRetardDeuxiemeNiveauCode;
    }
    set validNotificationRetardDeuxiemeNiveauCode(value: boolean) {
        this._validNotificationRetardDeuxiemeNiveauCode = value;
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
