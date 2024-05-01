import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {Locale38DetailAdminService} from 'src/app/shared/service/admin/taxe38/Locale38DetailAdmin.service';
import {Locale38DetailDto} from 'src/app/shared/model/taxe38/Locale38Detail.model';
import {Locale38DetailCriteria} from 'src/app/shared/criteria/taxe38/Locale38DetailCriteria.model';

import {TypeLocale38DetailDto} from 'src/app/shared/model/taxe38/TypeLocale38Detail.model';
import {TypeLocale38DetailAdminService} from 'src/app/shared/service/admin/taxe38/TypeLocale38DetailAdmin.service';
@Component({
  selector: 'app-locale38-detail-view-admin',
  templateUrl: './locale38-detail-view-admin.component.html'
})
export class Locale38DetailViewAdminComponent extends AbstractViewController<Locale38DetailDto, Locale38DetailCriteria, Locale38DetailAdminService> implements OnInit {


    constructor(private locale38DetailService: Locale38DetailAdminService, private typeLocale38DetailService: TypeLocale38DetailAdminService){
        super(locale38DetailService);
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


}
