import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {Taxe38DetailAdminService} from 'src/app/shared/service/admin/taxe38/Taxe38DetailAdmin.service';
import {Taxe38DetailDto} from 'src/app/shared/model/taxe38/Taxe38Detail.model';
import {Taxe38DetailCriteria} from 'src/app/shared/criteria/taxe38/Taxe38DetailCriteria.model';

import {Taxe38Dto} from 'src/app/shared/model/taxe38/Taxe38.model';
import {Taxe38AdminService} from 'src/app/shared/service/admin/taxe38/Taxe38Admin.service';
import {Locale38DetailDto} from 'src/app/shared/model/taxe38/Locale38Detail.model';
import {Locale38DetailAdminService} from 'src/app/shared/service/admin/taxe38/Locale38DetailAdmin.service';
import {TauxTaxe38Dto} from 'src/app/shared/model/taxe38/TauxTaxe38.model';
import {TauxTaxe38AdminService} from 'src/app/shared/service/admin/taxe38/TauxTaxe38Admin.service';
@Component({
  selector: 'app-taxe38-detail-view-admin',
  templateUrl: './taxe38-detail-view-admin.component.html'
})
export class Taxe38DetailViewAdminComponent extends AbstractViewController<Taxe38DetailDto, Taxe38DetailCriteria, Taxe38DetailAdminService> implements OnInit {


    constructor(private taxe38DetailService: Taxe38DetailAdminService, private taxe38Service: Taxe38AdminService, private locale38DetailService: Locale38DetailAdminService, private tauxTaxe38Service: TauxTaxe38AdminService){
        super(taxe38DetailService);
    }

    ngOnInit(): void {
    }


    get locale38Detail(): Locale38DetailDto {
       return this.locale38DetailService.item;
    }
    set locale38Detail(value: Locale38DetailDto) {
        this.locale38DetailService.item = value;
    }
    get locale38Details(): Array<Locale38DetailDto> {
       return this.locale38DetailService.items;
    }
    set locale38Details(value: Array<Locale38DetailDto>) {
        this.locale38DetailService.items = value;
    }
    get tauxTaxe38(): TauxTaxe38Dto {
       return this.tauxTaxe38Service.item;
    }
    set tauxTaxe38(value: TauxTaxe38Dto) {
        this.tauxTaxe38Service.item = value;
    }
    get tauxTaxe38s(): Array<TauxTaxe38Dto> {
       return this.tauxTaxe38Service.items;
    }
    set tauxTaxe38s(value: Array<TauxTaxe38Dto>) {
        this.tauxTaxe38Service.items = value;
    }
    get taxe38(): Taxe38Dto {
       return this.taxe38Service.item;
    }
    set taxe38(value: Taxe38Dto) {
        this.taxe38Service.item = value;
    }
    get taxe38s(): Array<Taxe38Dto> {
       return this.taxe38Service.items;
    }
    set taxe38s(value: Array<Taxe38Dto>) {
        this.taxe38Service.items = value;
    }


}
