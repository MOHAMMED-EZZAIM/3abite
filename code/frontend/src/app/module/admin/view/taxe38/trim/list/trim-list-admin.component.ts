import {Component, OnInit} from '@angular/core';
import {TrimAdminService} from 'src/app/shared/service/admin/taxe38/TrimAdmin.service';
import {TrimDto} from 'src/app/shared/model/taxe38/Trim.model';
import {TrimCriteria} from 'src/app/shared/criteria/taxe38/TrimCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-trim-list-admin',
  templateUrl: './trim-list-admin.component.html'
})
export class TrimListAdminComponent extends AbstractListController<TrimDto, TrimCriteria, TrimAdminService>  implements OnInit {

    override fileName = 'Trim';




    constructor( private trimService: TrimAdminService  ) {
        super(trimService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('Trim').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'numero', header: 'Numero'},
        ];
    }





   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Libelle': e.libelle ,
                 'Numero': e.numero ,
            }
        });

        this.criteriaData = [{
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
            'Numero Min': this.criteria.numeroMin ? this.criteria.numeroMin : environment.emptyForExport ,
            'Numero Max': this.criteria.numeroMax ? this.criteria.numeroMax : environment.emptyForExport ,
        }];
      }
}
