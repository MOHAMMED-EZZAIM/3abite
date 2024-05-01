import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {RueDto} from 'src/app/shared/model/commun/Rue.model';
import {RueCriteria} from 'src/app/shared/criteria/commun/RueCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class RueAdminService extends AbstractService<RueDto, RueCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): RueDto {
        return new RueDto();
    }

    public constrcutCriteria(): RueCriteria {
        return new RueCriteria();
    }

    get API() {
        return environment.apiUrlUnivservice + 'admin/rue/';
    }
}
