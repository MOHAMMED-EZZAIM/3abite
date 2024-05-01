import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {NotificationRetardDeuxiemeNiveauDetailType38Dto} from 'src/app/shared/model/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveauDetailType38.model';
import {NotificationRetardDeuxiemeNiveauDetailType38Criteria} from 'src/app/shared/criteria/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveauDetailType38Criteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class NotificationRetardDeuxiemeNiveauDetailType38AdminService extends AbstractService<NotificationRetardDeuxiemeNiveauDetailType38Dto, NotificationRetardDeuxiemeNiveauDetailType38Criteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
    }

    public constrcutDto(): NotificationRetardDeuxiemeNiveauDetailType38Dto {
        return new NotificationRetardDeuxiemeNiveauDetailType38Dto();
    }

    public constrcutCriteria(): NotificationRetardDeuxiemeNiveauDetailType38Criteria {
        return new NotificationRetardDeuxiemeNiveauDetailType38Criteria();
    }

    get API() {
        return environment.apiUrlUnivservice + 'admin/notificationRetardDeuxiemeNiveauDetailType38/';
    }
}
