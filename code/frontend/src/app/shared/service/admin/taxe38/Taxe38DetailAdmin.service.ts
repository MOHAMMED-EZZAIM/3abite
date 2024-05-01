import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {Taxe38DetailDto} from 'src/app/shared/model/taxe38/Taxe38Detail.model';
import {Taxe38DetailCriteria} from 'src/app/shared/criteria/taxe38/Taxe38DetailCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class Taxe38DetailAdminService extends AbstractService<Taxe38DetailDto, Taxe38DetailCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): Taxe38DetailDto {
        return new Taxe38DetailDto();
    }

    public constrcutCriteria(): Taxe38DetailCriteria {
        return new Taxe38DetailCriteria();
    }

    get API() {
        return environment.apiUrlUnivservice + 'admin/taxe38Detail/';
    }
}
