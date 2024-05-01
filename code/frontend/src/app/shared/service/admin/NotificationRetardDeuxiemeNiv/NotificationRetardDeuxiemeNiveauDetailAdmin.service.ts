import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {NotificationRetardDeuxiemeNiveauDetailDto} from 'src/app/shared/model/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveauDetail.model';
import {NotificationRetardDeuxiemeNiveauDetailCriteria} from 'src/app/shared/criteria/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveauDetailCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class NotificationRetardDeuxiemeNiveauDetailAdminService extends AbstractService<NotificationRetardDeuxiemeNiveauDetailDto, NotificationRetardDeuxiemeNiveauDetailCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): NotificationRetardDeuxiemeNiveauDetailDto {
        return new NotificationRetardDeuxiemeNiveauDetailDto();
    }

    public constrcutCriteria(): NotificationRetardDeuxiemeNiveauDetailCriteria {
        return new NotificationRetardDeuxiemeNiveauDetailCriteria();
    }

    get API() {
        return environment.apiUrlUnivservice + 'admin/notificationRetardDeuxiemeNiveauDetail/';
    }
}
