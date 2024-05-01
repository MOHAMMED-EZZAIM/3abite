import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {TauxTaxe38Dto} from 'src/app/shared/model/taxe38/TauxTaxe38.model';
import {TauxTaxe38Criteria} from 'src/app/shared/criteria/taxe38/TauxTaxe38Criteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class TauxTaxe38AdminService extends AbstractService<TauxTaxe38Dto, TauxTaxe38Criteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): TauxTaxe38Dto {
        return new TauxTaxe38Dto();
    }

    public constrcutCriteria(): TauxTaxe38Criteria {
        return new TauxTaxe38Criteria();
    }

    get API() {
        return environment.apiUrlUnivservice + 'admin/tauxTaxe38/';
    }
}
