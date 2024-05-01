import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {TypeLocale38DetailDto} from 'src/app/shared/model/taxe38/TypeLocale38Detail.model';
import {TypeLocale38DetailCriteria} from 'src/app/shared/criteria/taxe38/TypeLocale38DetailCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class TypeLocale38DetailAdminService extends AbstractService<TypeLocale38DetailDto, TypeLocale38DetailCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): TypeLocale38DetailDto {
        return new TypeLocale38DetailDto();
    }

    public constrcutCriteria(): TypeLocale38DetailCriteria {
        return new TypeLocale38DetailCriteria();
    }

    get API() {
        return environment.apiUrlUnivservice + 'admin/typeLocale38Detail/';
    }
}
