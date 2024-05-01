import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {Locale38DetailAdminService} from 'src/app/shared/service/admin/taxe38/Locale38DetailAdmin.service';
import {Locale38DetailDto} from 'src/app/shared/model/taxe38/Locale38Detail.model';
import {Locale38DetailCriteria} from 'src/app/shared/criteria/taxe38/Locale38DetailCriteria.model';


import {TypeLocale38DetailDto} from 'src/app/shared/model/taxe38/TypeLocale38Detail.model';
import {TypeLocale38DetailAdminService} from 'src/app/shared/service/admin/taxe38/TypeLocale38DetailAdmin.service';

@Component({
  selector: 'app-locale38-detail-edit-admin',
  templateUrl: './locale38-detail-edit-admin.component.html'
})
export class Locale38DetailEditAdminComponent extends AbstractEditController<Locale38DetailDto, Locale38DetailCriteria, Locale38DetailAdminService>   implements OnInit {


    private _validLocale38DetailCode = true;

    private _validTypeLocale38DetailCode = true;
    private _validTypeLocale38DetailLibelle = true;



    constructor( private locale38DetailService: Locale38DetailAdminService , private typeLocale38DetailService: TypeLocale38DetailAdminService) {
        super(locale38DetailService);
    }

    ngOnInit(): void {
        this.typeLocale38Detail = new TypeLocale38DetailDto();
        this.typeLocale38DetailService.findAll().subscribe((data) => this.typeLocale38Details = data);
    }


    public override setValidation(value: boolean){
        this.validLocale38DetailCode = value;
        }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateLocale38DetailCode();
    }
    public validateLocale38DetailCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validLocale38DetailCode = false;
        } else {
            this.validLocale38DetailCode = true;
        }
    }



   public async openCreateTypeLocale38Detail(typeLocale38Detail: string) {
        const isPermistted = await this.roleService.isPermitted('TypeLocale38Detail', 'edit');
        if (isPermistted) {
             this.typeLocale38Detail = new TypeLocale38DetailDto();
             this.createTypeLocale38DetailDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

   get typeLocale38Detail(): TypeLocale38DetailDto {
       return this.typeLocale38DetailService.item;
   }
  set typeLocale38Detail(value: TypeLocale38DetailDto) {
        this.typeLocale38DetailService.item = value;
   }
   get typeLocale38Details(): Array<TypeLocale38DetailDto> {
        return this.typeLocale38DetailService.items;
   }
   set typeLocale38Details(value: Array<TypeLocale38DetailDto>) {
        this.typeLocale38DetailService.items = value;
   }
   get createTypeLocale38DetailDialog(): boolean {
       return this.typeLocale38DetailService.createDialog;
   }
  set createTypeLocale38DetailDialog(value: boolean) {
       this.typeLocale38DetailService.createDialog= value;
   }


    get validLocale38DetailCode(): boolean {
        return this._validLocale38DetailCode;
    }
    set validLocale38DetailCode(value: boolean) {
        this._validLocale38DetailCode = value;
    }

    get validTypeLocale38DetailCode(): boolean {
        return this._validTypeLocale38DetailCode;
    }
    set validTypeLocale38DetailCode(value: boolean) {
        this._validTypeLocale38DetailCode = value;
    }
    get validTypeLocale38DetailLibelle(): boolean {
        return this._validTypeLocale38DetailLibelle;
    }
    set validTypeLocale38DetailLibelle(value: boolean) {
        this._validTypeLocale38DetailLibelle = value;
    }
}
