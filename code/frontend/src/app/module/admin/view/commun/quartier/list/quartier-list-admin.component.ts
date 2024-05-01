import {Component, OnInit} from '@angular/core';
import {QuartierAdminService} from 'src/app/shared/service/admin/commun/QuartierAdmin.service';
import {QuartierDto} from 'src/app/shared/model/commun/Quartier.model';
import {QuartierCriteria} from 'src/app/shared/criteria/commun/QuartierCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {SecteurDto} from 'src/app/shared/model/commun/Secteur.model';
import {SecteurAdminService} from 'src/app/shared/service/admin/commun/SecteurAdmin.service';


@Component({
  selector: 'app-quartier-list-admin',
  templateUrl: './quartier-list-admin.component.html'
})
export class QuartierListAdminComponent extends AbstractListController<QuartierDto, QuartierCriteria, QuartierAdminService>  implements OnInit {

    override fileName = 'Quartier';


    secteurs: Array<SecteurDto>;


    constructor( private quartierService: QuartierAdminService  , private secteurService: SecteurAdminService) {
        super(quartierService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('Quartier').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadSecteur();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'libelle', header: 'Libelle'},
            {field: 'secteur?.libelle', header: 'Secteur'},
        ];
    }


    public async loadSecteur(){
       this.secteurService.findAllOptimized().subscribe(secteurs => this.secteurs = secteurs, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                 'Libelle': e.libelle ,
                'Secteur': e.secteur?.libelle ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
        //'Secteur': this.criteria.secteur?.libelle ? this.criteria.secteur?.libelle : environment.emptyForExport ,
        }];
      }
}
