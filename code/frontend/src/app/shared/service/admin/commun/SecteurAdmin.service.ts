import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {SecteurDto} from 'src/app/shared/model/commun/Secteur.model';
import {SecteurCriteria} from 'src/app/shared/criteria/commun/SecteurCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class SecteurAdminService extends AbstractService<SecteurDto, SecteurCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): SecteurDto {
        return new SecteurDto();
    }

    public constrcutCriteria(): SecteurCriteria {
        return new SecteurCriteria();
    }

    get API() {
        return environment.apiUrlUnivservice + 'admin/secteur/';
    }
}
