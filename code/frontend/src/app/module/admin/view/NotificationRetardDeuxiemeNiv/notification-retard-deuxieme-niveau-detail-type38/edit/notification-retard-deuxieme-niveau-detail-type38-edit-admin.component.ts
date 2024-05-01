import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {NotificationRetardDeuxiemeNiveauDetailType38AdminService} from 'src/app/shared/service/admin/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveauDetailType38Admin.service';
import {NotificationRetardDeuxiemeNiveauDetailType38Dto} from 'src/app/shared/model/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveauDetailType38.model';
import {NotificationRetardDeuxiemeNiveauDetailType38Criteria} from 'src/app/shared/criteria/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveauDetailType38Criteria.model';


import {TypeLocale38DetailDto} from 'src/app/shared/model/taxe38/TypeLocale38Detail.model';
import {TypeLocale38DetailAdminService} from 'src/app/shared/service/admin/taxe38/TypeLocale38DetailAdmin.service';

@Component({
  selector: 'app-notification-retard-deuxieme-niveau-detail-type38-edit-admin',
  templateUrl: './notification-retard-deuxieme-niveau-detail-type38-edit-admin.component.html'
})
export class NotificationRetardDeuxiemeNiveauDetailType38EditAdminComponent extends AbstractEditController<NotificationRetardDeuxiemeNiveauDetailType38Dto, NotificationRetardDeuxiemeNiveauDetailType38Criteria, NotificationRetardDeuxiemeNiveauDetailType38AdminService>   implements OnInit {


    private _validNotificationRetardDeuxiemeNiveauDetailType38Code = true;

    private _validTypeLocale38Code = true;
    private _validTypeLocale38Libelle = true;



    constructor( private notificationRetardDeuxiemeNiveauDetailType38Service: NotificationRetardDeuxiemeNiveauDetailType38AdminService , private typeLocale38DetailService: TypeLocale38DetailAdminService) {
        super(notificationRetardDeuxiemeNiveauDetailType38Service);
    }

    ngOnInit(): void {
        this.typeLocale38 = new TypeLocale38DetailDto();
        this.typeLocale38DetailService.findAll().subscribe((data) => this.typeLocale38s = data);
    }


    public override setValidation(value: boolean){
        this.validNotificationRetardDeuxiemeNiveauDetailType38Code = value;
        }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateNotificationRetardDeuxiemeNiveauDetailType38Code();
    }
    public validateNotificationRetardDeuxiemeNiveauDetailType38Code(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validNotificationRetardDeuxiemeNiveauDetailType38Code = false;
        } else {
            this.validNotificationRetardDeuxiemeNiveauDetailType38Code = true;
        }
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
   get createTypeLocale38Dialog(): boolean {
       return this.typeLocale38DetailService.createDialog;
   }
  set createTypeLocale38Dialog(value: boolean) {
       this.typeLocale38DetailService.createDialog= value;
   }


    get validNotificationRetardDeuxiemeNiveauDetailType38Code(): boolean {
        return this._validNotificationRetardDeuxiemeNiveauDetailType38Code;
    }
    set validNotificationRetardDeuxiemeNiveauDetailType38Code(value: boolean) {
        this._validNotificationRetardDeuxiemeNiveauDetailType38Code = value;
    }

    get validTypeLocale38Code(): boolean {
        return this._validTypeLocale38Code;
    }
    set validTypeLocale38Code(value: boolean) {
        this._validTypeLocale38Code = value;
    }
    get validTypeLocale38Libelle(): boolean {
        return this._validTypeLocale38Libelle;
    }
    set validTypeLocale38Libelle(value: boolean) {
        this._validTypeLocale38Libelle = value;
    }
}
