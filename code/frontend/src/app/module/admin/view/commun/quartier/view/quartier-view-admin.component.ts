import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {QuartierAdminService} from 'src/app/shared/service/admin/commun/QuartierAdmin.service';
import {QuartierDto} from 'src/app/shared/model/commun/Quartier.model';
import {QuartierCriteria} from 'src/app/shared/criteria/commun/QuartierCriteria.model';

import {SecteurDto} from 'src/app/shared/model/commun/Secteur.model';
import {SecteurAdminService} from 'src/app/shared/service/admin/commun/SecteurAdmin.service';
@Component({
  selector: 'app-quartier-view-admin',
  templateUrl: './quartier-view-admin.component.html'
})
export class QuartierViewAdminComponent extends AbstractViewController<QuartierDto, QuartierCriteria, QuartierAdminService> implements OnInit {


    constructor(private quartierService: QuartierAdminService, private secteurService: SecteurAdminService){
        super(quartierService);
    }

    ngOnInit(): void {
    }


    get secteur(): SecteurDto {
       return this.secteurService.item;
    }
    set secteur(value: SecteurDto) {
        this.secteurService.item = value;
    }
    get secteurs(): Array<SecteurDto> {
       return this.secteurService.items;
    }
    set secteurs(value: Array<SecteurDto>) {
        this.secteurService.items = value;
    }


}
