import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {TauxTaxe38AdminService} from 'src/app/shared/service/admin/taxe38/TauxTaxe38Admin.service';
import {TauxTaxe38Dto} from 'src/app/shared/model/taxe38/TauxTaxe38.model';
import {TauxTaxe38Criteria} from 'src/app/shared/criteria/taxe38/TauxTaxe38Criteria.model';


import {TypeLocale38DetailDto} from 'src/app/shared/model/taxe38/TypeLocale38Detail.model';
import {TypeLocale38DetailAdminService} from 'src/app/shared/service/admin/taxe38/TypeLocale38DetailAdmin.service';
import {CategorieLocaleDto} from 'src/app/shared/model/taxe38/CategorieLocale.model';
import {CategorieLocaleAdminService} from 'src/app/shared/service/admin/taxe38/CategorieLocaleAdmin.service';

@Component({
  selector: 'app-taux-taxe38-edit-admin',
  templateUrl: './taux-taxe38-edit-admin.component.html'
})
export class TauxTaxe38EditAdminComponent extends AbstractEditController<TauxTaxe38Dto, TauxTaxe38Criteria, TauxTaxe38AdminService>   implements OnInit {


    private _validTauxTaxe38Code = true;

    private _validTypeLocale38DetailCode = true;
    private _validTypeLocale38DetailLibelle = true;
    private _validCategorieLocaleCode = true;
    private _validCategorieLocaleLibelle = true;



    constructor( private tauxTaxe38Service: TauxTaxe38AdminService , private typeLocale38DetailService: TypeLocale38DetailAdminService, private categorieLocaleService: CategorieLocaleAdminService) {
        super(tauxTaxe38Service);
    }

    ngOnInit(): void {
        this.typeLocale38Detail = new TypeLocale38DetailDto();
        this.typeLocale38DetailService.findAll().subscribe((data) => this.typeLocale38Details = data);
        this.categorieLocale = new CategorieLocaleDto();
        this.categorieLocaleService.findAll().subscribe((data) => this.categorieLocales = data);
    }
    public override prepareEdit() {
        this.item.dateMin = this.tauxTaxe38Service.format(this.item.dateMin);
        this.item.dateMax = this.tauxTaxe38Service.format(this.item.dateMax);
    }



    public override setValidation(value: boolean){
        this.validTauxTaxe38Code = value;
        }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateTauxTaxe38Code();
    }
    public validateTauxTaxe38Code(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validTauxTaxe38Code = false;
        } else {
            this.validTauxTaxe38Code = true;
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
   public async openCreateCategorieLocale(categorieLocale: string) {
        const isPermistted = await this.roleService.isPermitted('CategorieLocale', 'edit');
        if (isPermistted) {
             this.categorieLocale = new CategorieLocaleDto();
             this.createCategorieLocaleDialog = true;
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
   get categorieLocale(): CategorieLocaleDto {
       return this.categorieLocaleService.item;
   }
  set categorieLocale(value: CategorieLocaleDto) {
        this.categorieLocaleService.item = value;
   }
   get categorieLocales(): Array<CategorieLocaleDto> {
        return this.categorieLocaleService.items;
   }
   set categorieLocales(value: Array<CategorieLocaleDto>) {
        this.categorieLocaleService.items = value;
   }
   get createCategorieLocaleDialog(): boolean {
       return this.categorieLocaleService.createDialog;
   }
  set createCategorieLocaleDialog(value: boolean) {
       this.categorieLocaleService.createDialog= value;
   }


    get validTauxTaxe38Code(): boolean {
        return this._validTauxTaxe38Code;
    }
    set validTauxTaxe38Code(value: boolean) {
        this._validTauxTaxe38Code = value;
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
