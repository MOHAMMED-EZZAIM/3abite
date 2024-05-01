import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {NotificationRetardTroisiemeNiveauDto} from 'src/app/shared/model/NotificationRetardTroisiemeNiv/NotificationRetardTroisiemeNiveau.model';
import {NotificationRetardTroisiemeNiveauCriteria} from 'src/app/shared/criteria/NotificationRetardTroisiemeNiv/NotificationRetardTroisiemeNiveauCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class NotificationRetardTroisiemeNiveauAdminService extends AbstractService<NotificationRetardTroisiemeNiveauDto, NotificationRetardTroisiemeNiveauCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): NotificationRetardTroisiemeNiveauDto {
        return new NotificationRetardTroisiemeNiveauDto();
    }

    public constrcutCriteria(): NotificationRetardTroisiemeNiveauCriteria {
        return new NotificationRetardTroisiemeNiveauCriteria();
    }

    get API() {
        return environment.apiUrlUnivservice + 'admin/notificationRetardTroisiemeNiveau/';
    }
}
