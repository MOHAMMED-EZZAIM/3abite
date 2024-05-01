import {Component, OnInit} from '@angular/core';
import {Taxe38DetailAdminService} from 'src/app/shared/service/admin/taxe38/Taxe38DetailAdmin.service';
import {Taxe38DetailDto} from 'src/app/shared/model/taxe38/Taxe38Detail.model';
import {Taxe38DetailCriteria} from 'src/app/shared/criteria/taxe38/Taxe38DetailCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {Taxe38Dto} from 'src/app/shared/model/taxe38/Taxe38.model';
import {Taxe38AdminService} from 'src/app/shared/service/admin/taxe38/Taxe38Admin.service';
import {Locale38DetailDto} from 'src/app/shared/model/taxe38/Locale38Detail.model';
import {Locale38DetailAdminService} from 'src/app/shared/service/admin/taxe38/Locale38DetailAdmin.service';
import {TauxTaxe38Dto} from 'src/app/shared/model/taxe38/TauxTaxe38.model';
import {TauxTaxe38AdminService} from 'src/app/shared/service/admin/taxe38/TauxTaxe38Admin.service';


@Component({
  selector: 'app-taxe38-detail-list-admin',
  templateUrl: './taxe38-detail-list-admin.component.html'
})
export class Taxe38DetailListAdminComponent extends AbstractListController<Taxe38DetailDto, Taxe38DetailCriteria, Taxe38DetailAdminService>  implements OnInit {

    override fileName = 'Taxe38Detail';


    locale38Details: Array<Locale38DetailDto>;
    tauxTaxe38s: Array<TauxTaxe38Dto>;
    taxe38s: Array<Taxe38Dto>;


    constructor( private taxe38DetailService: Taxe38DetailAdminService  , private taxe38Service: Taxe38AdminService, private locale38DetailService: Locale38DetailAdminService, private tauxTaxe38Service: TauxTaxe38AdminService) {
        super(taxe38DetailService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('Taxe38Detail').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadLocale38Detail();
                this.loadTauxTaxe38();
                this.loadTaxe38();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'montantParMetreCarre', header: 'Montant par metre carre'},
            {field: 'locale38Detail?.code', header: 'Locale38 detail'},
            {field: 'tauxTaxe38?.code', header: 'Taux taxe38'},
            {field: 'taxe38?.code', header: 'Taxe38'},
            {field: 'montantBase', header: 'Montant base'},
            {field: 'montantRetardPremierMois', header: 'Montant retard premier mois'},
            {field: 'montantRetardAutreMois', header: 'Montant retard autre mois'},
        ];
    }


    public async loadLocale38Detail(){
       this.locale38DetailService.findAllOptimized().subscribe(locale38Details => this.locale38Details = locale38Details, error => console.log(error))
    }
    public async loadTauxTaxe38(){
       this.tauxTaxe38Service.findAllOptimized().subscribe(tauxTaxe38s => this.tauxTaxe38s = tauxTaxe38s, error => console.log(error))
    }
    public async loadTaxe38(){
       this.taxe38Service.findAllOptimized().subscribe(taxe38s => this.taxe38s = taxe38s, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                 'Montant par metre carre': e.montantParMetreCarre ,
                'Locale38 detail': e.locale38Detail?.code ,
                'Taux taxe38': e.tauxTaxe38?.code ,
                'Taxe38': e.taxe38?.code ,
                 'Montant base': e.montantBase ,
                 'Montant retard premier mois': e.montantRetardPremierMois ,
                 'Montant retard autre mois': e.montantRetardAutreMois ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
            'Montant par metre carre Min': this.criteria.montantParMetreCarreMin ? this.criteria.montantParMetreCarreMin : environment.emptyForExport ,
            'Montant par metre carre Max': this.criteria.montantParMetreCarreMax ? this.criteria.montantParMetreCarreMax : environment.emptyForExport ,
        //'Locale38 detail': this.criteria.locale38Detail?.code ? this.criteria.locale38Detail?.code : environment.emptyForExport ,
        //'Taux taxe38': this.criteria.tauxTaxe38?.code ? this.criteria.tauxTaxe38?.code : environment.emptyForExport ,
        //'Taxe38': this.criteria.taxe38?.code ? this.criteria.taxe38?.code : environment.emptyForExport ,
            'Montant base Min': this.criteria.montantBaseMin ? this.criteria.montantBaseMin : environment.emptyForExport ,
            'Montant base Max': this.criteria.montantBaseMax ? this.criteria.montantBaseMax : environment.emptyForExport ,
            'Montant retard premier mois Min': this.criteria.montantRetardPremierMoisMin ? this.criteria.montantRetardPremierMoisMin : environment.emptyForExport ,
            'Montant retard premier mois Max': this.criteria.montantRetardPremierMoisMax ? this.criteria.montantRetardPremierMoisMax : environment.emptyForExport ,
            'Montant retard autre mois Min': this.criteria.montantRetardAutreMoisMin ? this.criteria.montantRetardAutreMoisMin : environment.emptyForExport ,
            'Montant retard autre mois Max': this.criteria.montantRetardAutreMoisMax ? this.criteria.montantRetardAutreMoisMax : environment.emptyForExport ,
        }];
      }
}
