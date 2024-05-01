import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {VilleAdminService} from 'src/app/shared/service/admin/commun/VilleAdmin.service';
import {VilleDto} from 'src/app/shared/model/commun/Ville.model';
import {VilleCriteria} from 'src/app/shared/criteria/commun/VilleCriteria.model';

@Component({
  selector: 'app-ville-view-admin',
  templateUrl: './ville-view-admin.component.html'
})
export class VilleViewAdminComponent extends AbstractViewController<VilleDto, VilleCriteria, VilleAdminService> implements OnInit {


    constructor(private villeService: VilleAdminService){
        super(villeService);
    }

    ngOnInit(): void {
    }




}
