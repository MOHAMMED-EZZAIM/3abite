import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {CategorieLocaleAdminService} from 'src/app/shared/service/admin/taxe38/CategorieLocaleAdmin.service';
import {CategorieLocaleDto} from 'src/app/shared/model/taxe38/CategorieLocale.model';
import {CategorieLocaleCriteria} from 'src/app/shared/criteria/taxe38/CategorieLocaleCriteria.model';

@Component({
  selector: 'app-categorie-locale-view-admin',
  templateUrl: './categorie-locale-view-admin.component.html'
})
export class CategorieLocaleViewAdminComponent extends AbstractViewController<CategorieLocaleDto, CategorieLocaleCriteria, CategorieLocaleAdminService> implements OnInit {


    constructor(private categorieLocaleService: CategorieLocaleAdminService){
        super(categorieLocaleService);
    }

    ngOnInit(): void {
    }




}
