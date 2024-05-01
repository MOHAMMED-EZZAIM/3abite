import {Component, OnInit} from '@angular/core';
import {TauxTaxe38AdminService} from 'src/app/shared/service/admin/taxe38/TauxTaxe38Admin.service';
import {TauxTaxe38Dto} from 'src/app/shared/model/taxe38/TauxTaxe38.model';
import {TauxTaxe38Criteria} from 'src/app/shared/criteria/taxe38/TauxTaxe38Criteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {TypeLocale38DetailDto} from 'src/app/shared/model/taxe38/TypeLocale38Detail.model';
import {TypeLocale38DetailAdminService} from 'src/app/shared/service/admin/taxe38/TypeLocale38DetailAdmin.service';
import {CategorieLocaleDto} from 'src/app/shared/model/taxe38/CategorieLocale.model';
import {CategorieLocaleAdminService} from 'src/app/shared/service/admin/taxe38/CategorieLocaleAdmin.service';


@Component({
  selector: 'app-taux-taxe38-list-admin',
  templateUrl: './taux-taxe38-list-admin.component.html'
})
export class TauxTaxe38ListAdminComponent extends AbstractListController<TauxTaxe38Dto, TauxTaxe38Criteria, TauxTaxe38AdminService>  implements OnInit {

    override fileName = 'TauxTaxe38';


    typeLocale38Details: Array<TypeLocale38DetailDto>;
    categorieLocales: Array<CategorieLocaleDto>;


    constructor( private tauxTaxe38Service: TauxTaxe38AdminService  , private typeLocale38DetailService: TypeLocale38DetailAdminService, private categorieLocaleService: CategorieLocaleAdminService) {
        super(tauxTaxe38Service);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('TauxTaxe38').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadTypeLocale38Detail();
                this.loadCategorieLocale();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'montantParMetreCarre', header: 'Montant par metre carre'},
            {field: 'dateMin', header: 'Date min'},
            {field: 'dateMax', header: 'Date max'},
            {field: 'pourcentagePremierRetard', header: 'Pourcentage premier retard'},
            {field: 'pourcentageAutreMoisRetard', header: 'Pourcentage autre mois retard'},
            {field: 'typeLocale38Detail?.code', header: 'Type locale38 detail'},
            {field: 'categorieLocale?.code', header: 'Categorie locale'},
        ];
    }


    public async loadTypeLocale38Detail(){
       this.typeLocale38DetailService.findAllOptimized().subscribe(typeLocale38Details => this.typeLocale38Details = typeLocale38Details, error => console.log(error))
    }
    public async loadCategorieLocale(){
       this.categorieLocaleService.findAllOptimized().subscribe(categorieLocales => this.categorieLocales = categorieLocales, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                 'Montant par metre carre': e.montantParMetreCarre ,
                'Date min': this.datePipe.transform(e.dateMin , 'dd/MM/yyyy hh:mm'),
                'Date max': this.datePipe.transform(e.dateMax , 'dd/MM/yyyy hh:mm'),
                 'Pourcentage premier retard': e.pourcentagePremierRetard ,
                 'Pourcentage autre mois retard': e.pourcentageAutreMoisRetard ,
                'Type locale38 detail': e.typeLocale38Detail?.code ,
                'Categorie locale': e.categorieLocale?.code ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
            'Montant par metre carre Min': this.criteria.montantParMetreCarreMin ? this.criteria.montantParMetreCarreMin : environment.emptyForExport ,
            'Montant par metre carre Max': this.criteria.montantParMetreCarreMax ? this.criteria.montantParMetreCarreMax : environment.emptyForExport ,
            'Date min Min': this.criteria.dateMinFrom ? this.datePipe.transform(this.criteria.dateMinFrom , this.dateFormat) : environment.emptyForExport ,
            'Date min Max': this.criteria.dateMinTo ? this.datePipe.transform(this.criteria.dateMinTo , this.dateFormat) : environment.emptyForExport ,
            'Date max Min': this.criteria.dateMaxFrom ? this.datePipe.transform(this.criteria.dateMaxFrom , this.dateFormat) : environment.emptyForExport ,
            'Date max Max': this.criteria.dateMaxTo ? this.datePipe.transform(this.criteria.dateMaxTo , this.dateFormat) : environment.emptyForExport ,
            'Pourcentage premier retard Min': this.criteria.pourcentagePremierRetardMin ? this.criteria.pourcentagePremierRetardMin : environment.emptyForExport ,
            'Pourcentage premier retard Max': this.criteria.pourcentagePremierRetardMax ? this.criteria.pourcentagePremierRetardMax : environment.emptyForExport ,
            'Pourcentage autre mois retard Min': this.criteria.pourcentageAutreMoisRetardMin ? this.criteria.pourcentageAutreMoisRetardMin : environment.emptyForExport ,
            'Pourcentage autre mois retard Max': this.criteria.pourcentageAutreMoisRetardMax ? this.criteria.pourcentageAutreMoisRetardMax : environment.emptyForExport ,
        //'Type locale38 detail': this.criteria.typeLocale38Detail?.code ? this.criteria.typeLocale38Detail?.code : environment.emptyForExport ,
        //'Categorie locale': this.criteria.categorieLocale?.code ? this.criteria.categorieLocale?.code : environment.emptyForExport ,
        }];
      }
}
