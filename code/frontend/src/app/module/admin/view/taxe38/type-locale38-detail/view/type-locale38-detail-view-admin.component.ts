import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {TypeLocale38DetailAdminService} from 'src/app/shared/service/admin/taxe38/TypeLocale38DetailAdmin.service';
import {TypeLocale38DetailDto} from 'src/app/shared/model/taxe38/TypeLocale38Detail.model';
import {TypeLocale38DetailCriteria} from 'src/app/shared/criteria/taxe38/TypeLocale38DetailCriteria.model';

@Component({
  selector: 'app-type-locale38-detail-view-admin',
  templateUrl: './type-locale38-detail-view-admin.component.html'
})
export class TypeLocale38DetailViewAdminComponent extends AbstractViewController<TypeLocale38DetailDto, TypeLocale38DetailCriteria, TypeLocale38DetailAdminService> implements OnInit {


    constructor(private typeLocale38DetailService: TypeLocale38DetailAdminService){
        super(typeLocale38DetailService);
    }

    ngOnInit(): void {
    }




}
