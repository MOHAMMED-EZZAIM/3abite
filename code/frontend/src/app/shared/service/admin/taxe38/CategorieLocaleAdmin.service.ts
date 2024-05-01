import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {CategorieLocaleDto} from 'src/app/shared/model/taxe38/CategorieLocale.model';
import {CategorieLocaleCriteria} from 'src/app/shared/criteria/taxe38/CategorieLocaleCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class CategorieLocaleAdminService extends AbstractService<CategorieLocaleDto, CategorieLocaleCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): CategorieLocaleDto {
        return new CategorieLocaleDto();
    }

    public constrcutCriteria(): CategorieLocaleCriteria {
        return new CategorieLocaleCriteria();
    }

    get API() {
        return environment.apiUrlUnivservice + 'admin/categorieLocale/';
    }
}
