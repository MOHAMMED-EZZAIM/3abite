import {Component, OnInit} from '@angular/core';
import {VilleAdminService} from 'src/app/shared/service/admin/commun/VilleAdmin.service';
import {VilleDto} from 'src/app/shared/model/commun/Ville.model';
import {VilleCriteria} from 'src/app/shared/criteria/commun/VilleCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-ville-list-admin',
  templateUrl: './ville-list-admin.component.html'
})
export class VilleListAdminComponent extends AbstractListController<VilleDto, VilleCriteria, VilleAdminService>  implements OnInit {

    override fileName = 'Ville';




    constructor( private villeService: VilleAdminService  ) {
        super(villeService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('Ville').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'libelle', header: 'Libelle'},
        ];
    }





   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                 'Libelle': e.libelle ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
        }];
      }
}
