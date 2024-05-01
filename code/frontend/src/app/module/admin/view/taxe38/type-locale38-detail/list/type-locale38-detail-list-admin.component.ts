import {Component, OnInit} from '@angular/core';
import {TypeLocale38DetailAdminService} from 'src/app/shared/service/admin/taxe38/TypeLocale38DetailAdmin.service';
import {TypeLocale38DetailDto} from 'src/app/shared/model/taxe38/TypeLocale38Detail.model';
import {TypeLocale38DetailCriteria} from 'src/app/shared/criteria/taxe38/TypeLocale38DetailCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-type-locale38-detail-list-admin',
  templateUrl: './type-locale38-detail-list-admin.component.html'
})
export class TypeLocale38DetailListAdminComponent extends AbstractListController<TypeLocale38DetailDto, TypeLocale38DetailCriteria, TypeLocale38DetailAdminService>  implements OnInit {

    override fileName = 'TypeLocale38Detail';




    constructor( private typeLocale38DetailService: TypeLocale38DetailAdminService  ) {
        super(typeLocale38DetailService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('TypeLocale38Detail').subscribe(() => {
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
