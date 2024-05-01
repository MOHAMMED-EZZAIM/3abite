import {Component, OnInit} from '@angular/core';
import {SecteurAdminService} from 'src/app/shared/service/admin/commun/SecteurAdmin.service';
import {SecteurDto} from 'src/app/shared/model/commun/Secteur.model';
import {SecteurCriteria} from 'src/app/shared/criteria/commun/SecteurCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {VilleDto} from 'src/app/shared/model/commun/Ville.model';
import {VilleAdminService} from 'src/app/shared/service/admin/commun/VilleAdmin.service';


@Component({
  selector: 'app-secteur-list-admin',
  templateUrl: './secteur-list-admin.component.html'
})
export class SecteurListAdminComponent extends AbstractListController<SecteurDto, SecteurCriteria, SecteurAdminService>  implements OnInit {

    override fileName = 'Secteur';


    villes: Array<VilleDto>;


    constructor( private secteurService: SecteurAdminService  , private villeService: VilleAdminService) {
        super(secteurService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('Secteur').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadVille();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'libelle', header: 'Libelle'},
            {field: 'ville?.libelle', header: 'Ville'},
        ];
    }


    public async loadVille(){
       this.villeService.findAllOptimized().subscribe(villes => this.villes = villes, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                 'Libelle': e.libelle ,
                'Ville': e.ville?.libelle ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
        //'Ville': this.criteria.ville?.libelle ? this.criteria.ville?.libelle : environment.emptyForExport ,
        }];
      }
}
