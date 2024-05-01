import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {NotificationRetardPremierNiveauDto} from 'src/app/shared/model/NotificationPremierNiv/NotificationRetardPremierNiveau.model';
import {NotificationRetardPremierNiveauCriteria} from 'src/app/shared/criteria/NotificationPremierNiv/NotificationRetardPremierNiveauCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class NotificationRetardPremierNiveauAdminService extends AbstractService<NotificationRetardPremierNiveauDto, NotificationRetardPremierNiveauCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): NotificationRetardPremierNiveauDto {
        return new NotificationRetardPremierNiveauDto();
    }

    public constrcutCriteria(): NotificationRetardPremierNiveauCriteria {
        return new NotificationRetardPremierNiveauCriteria();
    }

    get API() {
        return environment.apiUrlUnivservice + 'admin/notificationRetardPremierNiveau/';
    }
}
