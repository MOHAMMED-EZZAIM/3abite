import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {NotificationRetardDeuxiemeNiveauDetailAdminService} from 'src/app/shared/service/admin/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveauDetailAdmin.service';
import {NotificationRetardDeuxiemeNiveauDetailDto} from 'src/app/shared/model/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveauDetail.model';
import {NotificationRetardDeuxiemeNiveauDetailCriteria} from 'src/app/shared/criteria/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveauDetailCriteria.model';


import {TrimDto} from 'src/app/shared/model/taxe38/Trim.model';
import {TrimAdminService} from 'src/app/shared/service/admin/taxe38/TrimAdmin.service';

@Component({
  selector: 'app-notification-retard-deuxieme-niveau-detail-edit-admin',
  templateUrl: './notification-retard-deuxieme-niveau-detail-edit-admin.component.html'
})
export class NotificationRetardDeuxiemeNiveauDetailEditAdminComponent extends AbstractEditController<NotificationRetardDeuxiemeNiveauDetailDto, NotificationRetardDeuxiemeNiveauDetailCriteria, NotificationRetardDeuxiemeNiveauDetailAdminService>   implements OnInit {


    private _validNotificationRetardDeuxiemeNiveauDetailCode = true;

    private _validTrimLibelle = true;



    constructor( private notificationRetardDeuxiemeNiveauDetailService: NotificationRetardDeuxiemeNiveauDetailAdminService , private trimService: TrimAdminService) {
        super(notificationRetardDeuxiemeNiveauDetailService);
    }

    ngOnInit(): void {
        this.trim = new TrimDto();
        this.trimService.findAll().subscribe((data) => this.trims = data);
    }


    public override setValidation(value: boolean){
        this.validNotificationRetardDeuxiemeNiveauDetailCode = value;
        }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateNotificationRetardDeuxiemeNiveauDetailCode();
    }
    public validateNotificationRetardDeuxiemeNiveauDetailCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validNotificationRetardDeuxiemeNiveauDetailCode = false;
        } else {
            this.validNotificationRetardDeuxiemeNiveauDetailCode = true;
        }
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


    get validNotificationRetardDeuxiemeNiveauDetailCode(): boolean {
        return this._validNotificationRetardDeuxiemeNiveauDetailCode;
    }
    set validNotificationRetardDeuxiemeNiveauDetailCode(value: boolean) {
        this._validNotificationRetardDeuxiemeNiveauDetailCode = value;
    }

    get validTrimLibelle(): boolean {
        return this._validTrimLibelle;
    }
    set validTrimLibelle(value: boolean) {
        this._validTrimLibelle = value;
    }
}
