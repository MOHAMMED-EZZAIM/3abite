import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {VilleDto} from 'src/app/shared/model/commun/Ville.model';
import {VilleCriteria} from 'src/app/shared/criteria/commun/VilleCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class VilleAdminService extends AbstractService<VilleDto, VilleCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): VilleDto {
        return new VilleDto();
    }

    public constrcutCriteria(): VilleCriteria {
        return new VilleCriteria();
    }

    get API() {
        return environment.apiUrlUnivservice + 'admin/ville/';
    }
}
