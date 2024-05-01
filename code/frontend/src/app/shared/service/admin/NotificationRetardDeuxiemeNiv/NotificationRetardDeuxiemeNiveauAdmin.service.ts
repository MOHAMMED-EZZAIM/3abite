import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {NotificationRetardDeuxiemeNiveauDto} from 'src/app/shared/model/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveau.model';
import {NotificationRetardDeuxiemeNiveauCriteria} from 'src/app/shared/criteria/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveauCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class NotificationRetardDeuxiemeNiveauAdminService extends AbstractService<NotificationRetardDeuxiemeNiveauDto, NotificationRetardDeuxiemeNiveauCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): NotificationRetardDeuxiemeNiveauDto {
        return new NotificationRetardDeuxiemeNiveauDto();
    }

    public constrcutCriteria(): NotificationRetardDeuxiemeNiveauCriteria {
        return new NotificationRetardDeuxiemeNiveauCriteria();
    }

    get API() {
        return environment.apiUrlUnivservice + 'admin/notificationRetardDeuxiemeNiveau/';
    }
}
