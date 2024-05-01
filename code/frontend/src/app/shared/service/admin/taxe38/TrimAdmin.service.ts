import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {TrimDto} from 'src/app/shared/model/taxe38/Trim.model';
import {TrimCriteria} from 'src/app/shared/criteria/taxe38/TrimCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class TrimAdminService extends AbstractService<TrimDto, TrimCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): TrimDto {
        return new TrimDto();
    }

    public constrcutCriteria(): TrimCriteria {
        return new TrimCriteria();
    }

    get API() {
        return environment.apiUrlUnivservice + 'admin/trim/';
    }
}
