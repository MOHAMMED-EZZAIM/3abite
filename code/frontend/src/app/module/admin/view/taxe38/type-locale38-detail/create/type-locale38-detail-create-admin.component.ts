import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {TypeLocale38DetailAdminService} from 'src/app/shared/service/admin/taxe38/TypeLocale38DetailAdmin.service';
import {TypeLocale38DetailDto} from 'src/app/shared/model/taxe38/TypeLocale38Detail.model';
import {TypeLocale38DetailCriteria} from 'src/app/shared/criteria/taxe38/TypeLocale38DetailCriteria.model';
@Component({
  selector: 'app-type-locale38-detail-create-admin',
  templateUrl: './type-locale38-detail-create-admin.component.html'
})
export class TypeLocale38DetailCreateAdminComponent extends AbstractCreateController<TypeLocale38DetailDto, TypeLocale38DetailCriteria, TypeLocale38DetailAdminService>  implements OnInit {



   private _validTypeLocale38DetailCode = true;
   private _validTypeLocale38DetailLibelle = true;

    constructor( private typeLocale38DetailService: TypeLocale38DetailAdminService ) {
        super(typeLocale38DetailService);
    }

    ngOnInit(): void {
    }





    public override setValidation(value: boolean){
        this.validTypeLocale38DetailCode = value;
        this.validTypeLocale38DetailLibelle = value;
    }



    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateTypeLocale38DetailCode();
        this.validateTypeLocale38DetailLibelle();
    }

    public validateTypeLocale38DetailCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validTypeLocale38DetailCode = false;
        } else {
            this.validTypeLocale38DetailCode = true;
        }
    }
    public validateTypeLocale38DetailLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validTypeLocale38DetailLibelle = false;
        } else {
            this.validTypeLocale38DetailLibelle = true;
        }
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
