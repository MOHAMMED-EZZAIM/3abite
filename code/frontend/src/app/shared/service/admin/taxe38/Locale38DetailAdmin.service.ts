import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {Locale38DetailDto} from 'src/app/shared/model/taxe38/Locale38Detail.model';
import {Locale38DetailCriteria} from 'src/app/shared/criteria/taxe38/Locale38DetailCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class Locale38DetailAdminService extends AbstractService<Locale38DetailDto, Locale38DetailCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): Locale38DetailDto {
        return new Locale38DetailDto();
    }

    public constrcutCriteria(): Locale38DetailCriteria {
        return new Locale38DetailCriteria();
    }

    get API() {
        return environment.apiUrlUnivservice + 'admin/locale38Detail/';
    }
}
