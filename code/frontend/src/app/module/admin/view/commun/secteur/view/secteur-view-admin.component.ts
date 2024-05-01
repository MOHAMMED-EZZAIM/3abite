import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {SecteurAdminService} from 'src/app/shared/service/admin/commun/SecteurAdmin.service';
import {SecteurDto} from 'src/app/shared/model/commun/Secteur.model';
import {SecteurCriteria} from 'src/app/shared/criteria/commun/SecteurCriteria.model';

import {VilleDto} from 'src/app/shared/model/commun/Ville.model';
import {VilleAdminService} from 'src/app/shared/service/admin/commun/VilleAdmin.service';
@Component({
  selector: 'app-secteur-view-admin',
  templateUrl: './secteur-view-admin.component.html'
})
export class SecteurViewAdminComponent extends AbstractViewController<SecteurDto, SecteurCriteria, SecteurAdminService> implements OnInit {


    constructor(private secteurService: SecteurAdminService, private villeService: VilleAdminService){
        super(secteurService);
    }

    ngOnInit(): void {
    }


    get ville(): VilleDto {
       return this.villeService.item;
    }
    set ville(value: VilleDto) {
        this.villeService.item = value;
    }
    get villes(): Array<VilleDto> {
       return this.villeService.items;
    }
    set villes(value: Array<VilleDto>) {
        this.villeService.items = value;
    }


}
