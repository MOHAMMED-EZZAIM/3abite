import {Component, OnInit} from '@angular/core';
import {LocaleAdminService} from 'src/app/shared/service/admin/commun/LocaleAdmin.service';
import {LocaleDto} from 'src/app/shared/model/commun/Locale.model';
import {LocaleCriteria} from 'src/app/shared/criteria/commun/LocaleCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {RueDto} from 'src/app/shared/model/commun/Rue.model';
import {RueAdminService} from 'src/app/shared/service/admin/commun/RueAdmin.service';
import {RedevableDto} from 'src/app/shared/model/commun/Redevable.model';
import {RedevableAdminService} from 'src/app/shared/service/admin/commun/RedevableAdmin.service';
import {CategorieLocaleDto} from 'src/app/shared/model/taxe38/CategorieLocale.model';
import {CategorieLocaleAdminService} from 'src/app/shared/service/admin/taxe38/CategorieLocaleAdmin.service';


@Component({
  selector: 'app-locale-list-admin',
  templateUrl: './locale-list-admin.component.html'
})
export class LocaleListAdminComponent extends AbstractListController<LocaleDto, LocaleCriteria, LocaleAdminService>  implements OnInit {

    override fileName = 'Locale';


    rues: Array<RueDto>;
    redevables: Array<RedevableDto>;
    categorieLocales: Array<CategorieLocaleDto>;


    constructor( private localeService: LocaleAdminService  , private rueService: RueAdminService, private redevableService: RedevableAdminService, private categorieLocaleService: CategorieLocaleAdminService) {
        super(localeService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('Locale').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadRue();
                this.loadRedevable();
                this.loadCategorieLocale();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'complementAdresse', header: 'Complement adresse'},
            {field: 'rue?.libelle', header: 'Rue'},
            {field: 'redevable?.id', header: 'Redevable'},
            {field: 'categorieLocale?.code', header: 'Categorie locale'},
        ];
    }


    public async loadRue(){
       this.rueService.findAllOptimized().subscribe(rues => this.rues = rues, error => console.log(error))
    }
    public async loadRedevable(){
       this.redevableService.findAll().subscribe(redevables => this.redevables = redevables, error => console.log(error))
    }
    public async loadCategorieLocale(){
       this.categorieLocaleService.findAllOptimized().subscribe(categorieLocales => this.categorieLocales = categorieLocales, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                 'Complement adresse': e.complementAdresse ,
                'Rue': e.rue?.libelle ,
                'Redevable': e.redevable?.id ,
                'Categorie locale': e.categorieLocale?.code ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
            'Complement adresse': this.criteria.complementAdresse ? this.criteria.complementAdresse : environment.emptyForExport ,
        //'Rue': this.criteria.rue?.libelle ? this.criteria.rue?.libelle : environment.emptyForExport ,
        //'Redevable': this.criteria.redevable?.id ? this.criteria.redevable?.id : environment.emptyForExport ,
        //'Categorie locale': this.criteria.categorieLocale?.code ? this.criteria.categorieLocale?.code : environment.emptyForExport ,
        }];
      }
}
