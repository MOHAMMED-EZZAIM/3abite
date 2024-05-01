import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {TauxTaxe38AdminService} from 'src/app/shared/service/admin/taxe38/TauxTaxe38Admin.service';
import {TauxTaxe38Dto} from 'src/app/shared/model/taxe38/TauxTaxe38.model';
import {TauxTaxe38Criteria} from 'src/app/shared/criteria/taxe38/TauxTaxe38Criteria.model';

import {TypeLocale38DetailDto} from 'src/app/shared/model/taxe38/TypeLocale38Detail.model';
import {TypeLocale38DetailAdminService} from 'src/app/shared/service/admin/taxe38/TypeLocale38DetailAdmin.service';
import {CategorieLocaleDto} from 'src/app/shared/model/taxe38/CategorieLocale.model';
import {CategorieLocaleAdminService} from 'src/app/shared/service/admin/taxe38/CategorieLocaleAdmin.service';
@Component({
  selector: 'app-taux-taxe38-view-admin',
  templateUrl: './taux-taxe38-view-admin.component.html'
})
export class TauxTaxe38ViewAdminComponent extends AbstractViewController<TauxTaxe38Dto, TauxTaxe38Criteria, TauxTaxe38AdminService> implements OnInit {


    constructor(private tauxTaxe38Service: TauxTaxe38AdminService, private typeLocale38DetailService: TypeLocale38DetailAdminService, private categorieLocaleService: CategorieLocaleAdminService){
        super(tauxTaxe38Service);
    }

    ngOnInit(): void {
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


}
