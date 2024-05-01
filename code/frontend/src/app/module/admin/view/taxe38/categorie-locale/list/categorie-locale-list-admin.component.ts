import {Component, OnInit} from '@angular/core';
import {CategorieLocaleAdminService} from 'src/app/shared/service/admin/taxe38/CategorieLocaleAdmin.service';
import {CategorieLocaleDto} from 'src/app/shared/model/taxe38/CategorieLocale.model';
import {CategorieLocaleCriteria} from 'src/app/shared/criteria/taxe38/CategorieLocaleCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-categorie-locale-list-admin',
  templateUrl: './categorie-locale-list-admin.component.html'
})
export class CategorieLocaleListAdminComponent extends AbstractListController<CategorieLocaleDto, CategorieLocaleCriteria, CategorieLocaleAdminService>  implements OnInit {

    override fileName = 'CategorieLocale';




    constructor( private categorieLocaleService: CategorieLocaleAdminService  ) {
        super(categorieLocaleService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('CategorieLocale').subscribe(() => {
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
