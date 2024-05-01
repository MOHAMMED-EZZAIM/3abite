import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

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
  selector: 'app-notification-retard-troisieme-niveau-create-admin',
  templateUrl: './notification-retard-troisieme-niveau-create-admin.component.html'
})
export class NotificationRetardTroisiemeNiveauCreateAdminComponent extends AbstractCreateController<NotificationRetardTroisiemeNiveauDto, NotificationRetardTroisiemeNiveauCriteria, NotificationRetardTroisiemeNiveauAdminService>  implements OnInit {



   private _validNotificationRetardTroisiemeNiveauCode = true;
    private _validLocaleCode = true;
    private _validRedevableCin = true;
    private _validTrimLibelle = true;

    constructor( private notificationRetardTroisiemeNiveauService: NotificationRetardTroisiemeNiveauAdminService , private localeService: LocaleAdminService, private trimService: TrimAdminService, private redevableService: RedevableAdminService) {
        super(notificationRetardTroisiemeNiveauService);
    }

    ngOnInit(): void {
        this.locale = new LocaleDto();
        this.localeService.findAll().subscribe((data) => this.locales = data);
        this.redevable = new RedevableDto();
        this.redevableService.findAll().subscribe((data) => this.redevables = data);
        this.trim = new TrimDto();
        this.trimService.findAll().subscribe((data) => this.trims = data);
    }





    public override setValidation(value: boolean){
        this.validNotificationRetardTroisiemeNiveauCode = value;
    }



    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateNotificationRetardTroisiemeNiveauCode();
    }

    public validateNotificationRetardTroisiemeNiveauCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validNotificationRetardTroisiemeNiveauCode = false;
        } else {
            this.validNotificationRetardTroisiemeNiveauCode = true;
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
    get createTrimDialog(): boolean {
       return this.trimService.createDialog;
    }
    set createTrimDialog(value: boolean) {
        this.trimService.createDialog= value;
    }



    get validNotificationRetardTroisiemeNiveauCode(): boolean {
        return this._validNotificationRetardTroisiemeNiveauCode;
    }

    set validNotificationRetardTroisiemeNiveauCode(value: boolean) {
         this._validNotificationRetardTroisiemeNiveauCode = value;
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
    get validTrimLibelle(): boolean {
        return this._validTrimLibelle;
    }
    set validTrimLibelle(value: boolean) {
        this._validTrimLibelle = value;
    }


}
