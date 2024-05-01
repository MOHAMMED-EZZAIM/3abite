import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {TrimAdminService} from 'src/app/shared/service/admin/taxe38/TrimAdmin.service';
import {TrimDto} from 'src/app/shared/model/taxe38/Trim.model';
import {TrimCriteria} from 'src/app/shared/criteria/taxe38/TrimCriteria.model';

@Component({
  selector: 'app-trim-view-admin',
  templateUrl: './trim-view-admin.component.html'
})
export class TrimViewAdminComponent extends AbstractViewController<TrimDto, TrimCriteria, TrimAdminService> implements OnInit {


    constructor(private trimService: TrimAdminService){
        super(trimService);
    }

    ngOnInit(): void {
    }




}
