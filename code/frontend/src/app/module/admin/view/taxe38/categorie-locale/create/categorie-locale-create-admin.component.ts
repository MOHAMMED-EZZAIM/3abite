import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {CategorieLocaleAdminService} from 'src/app/shared/service/admin/taxe38/CategorieLocaleAdmin.service';
import {CategorieLocaleDto} from 'src/app/shared/model/taxe38/CategorieLocale.model';
import {CategorieLocaleCriteria} from 'src/app/shared/criteria/taxe38/CategorieLocaleCriteria.model';
@Component({
  selector: 'app-categorie-locale-create-admin',
  templateUrl: './categorie-locale-create-admin.component.html'
})
export class CategorieLocaleCreateAdminComponent extends AbstractCreateController<CategorieLocaleDto, CategorieLocaleCriteria, CategorieLocaleAdminService>  implements OnInit {



   private _validCategorieLocaleCode = true;
   private _validCategorieLocaleLibelle = true;

    constructor( private categorieLocaleService: CategorieLocaleAdminService ) {
        super(categorieLocaleService);
    }

    ngOnInit(): void {
    }





    public override setValidation(value: boolean){
        this.validCategorieLocaleCode = value;
        this.validCategorieLocaleLibelle = value;
    }



    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateCategorieLocaleCode();
        this.validateCategorieLocaleLibelle();
    }

    public validateCategorieLocaleCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validCategorieLocaleCode = false;
        } else {
            this.validCategorieLocaleCode = true;
        }
    }
    public validateCategorieLocaleLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validCategorieLocaleLibelle = false;
        } else {
            this.validCategorieLocaleLibelle = true;
        }
    }






    get validCategorieLocaleCode(): boolean {
        return this._validCategorieLocaleCode;
    }

    set validCategorieLocaleCode(value: boolean) {
         this._validCategorieLocaleCode = value;
    }
    get validCategorieLocaleLibelle(): boolean {
        return this._validCategorieLocaleLibelle;
    }

    set validCategorieLocaleLibelle(value: boolean) {
         this._validCategorieLocaleLibelle = value;
    }



}
