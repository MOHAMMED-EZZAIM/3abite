import {Component, OnInit} from '@angular/core';
import {RueAdminService} from 'src/app/shared/service/admin/commun/RueAdmin.service';
import {RueDto} from 'src/app/shared/model/commun/Rue.model';
import {RueCriteria} from 'src/app/shared/criteria/commun/RueCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {QuartierDto} from 'src/app/shared/model/commun/Quartier.model';
import {QuartierAdminService} from 'src/app/shared/service/admin/commun/QuartierAdmin.service';


@Component({
  selector: 'app-rue-list-admin',
  templateUrl: './rue-list-admin.component.html'
})
export class RueListAdminComponent extends AbstractListController<RueDto, RueCriteria, RueAdminService>  implements OnInit {

    override fileName = 'Rue';


    quartiers: Array<QuartierDto>;


    constructor( private rueService: RueAdminService  , private quartierService: QuartierAdminService) {
        super(rueService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('Rue').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadQuartier();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'libelle', header: 'Libelle'},
            {field: 'quartier?.libelle', header: 'Quartier'},
        ];
    }


    public async loadQuartier(){
       this.quartierService.findAllOptimized().subscribe(quartiers => this.quartiers = quartiers, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                 'Libelle': e.libelle ,
                'Quartier': e.quartier?.libelle ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
        //'Quartier': this.criteria.quartier?.libelle ? this.criteria.quartier?.libelle : environment.emptyForExport ,
        }];
      }
}
