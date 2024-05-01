import {Component, OnInit} from '@angular/core';
import {Taxe38AdminService} from 'src/app/shared/service/admin/taxe38/Taxe38Admin.service';
import {Taxe38Dto} from 'src/app/shared/model/taxe38/Taxe38.model';
import {Taxe38Criteria} from 'src/app/shared/criteria/taxe38/Taxe38Criteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {LocaleDto} from 'src/app/shared/model/commun/Locale.model';
import {LocaleAdminService} from 'src/app/shared/service/admin/commun/LocaleAdmin.service';
import {TrimDto} from 'src/app/shared/model/taxe38/Trim.model';
import {TrimAdminService} from 'src/app/shared/service/admin/taxe38/TrimAdmin.service';
import {Taxe38DetailDto} from 'src/app/shared/model/taxe38/Taxe38Detail.model';
import {Taxe38DetailAdminService} from 'src/app/shared/service/admin/taxe38/Taxe38DetailAdmin.service';
import {Locale38DetailDto} from 'src/app/shared/model/taxe38/Locale38Detail.model';
import {Locale38DetailAdminService} from 'src/app/shared/service/admin/taxe38/Locale38DetailAdmin.service';
import {RedevableDto} from 'src/app/shared/model/commun/Redevable.model';
import {RedevableAdminService} from 'src/app/shared/service/admin/commun/RedevableAdmin.service';
import {TauxTaxe38Dto} from 'src/app/shared/model/taxe38/TauxTaxe38.model';
import {TauxTaxe38AdminService} from 'src/app/shared/service/admin/taxe38/TauxTaxe38Admin.service';


@Component({
  selector: 'app-taxe38-list-admin',
  templateUrl: './taxe38-list-admin.component.html'
})
export class Taxe38ListAdminComponent extends AbstractListController<Taxe38Dto, Taxe38Criteria, Taxe38AdminService>  implements OnInit {

    override fileName = 'Taxe38';


    redevables: Array<RedevableDto>;
    locales: Array<LocaleDto>;
    trims: Array<TrimDto>;


    constructor( private taxe38Service: Taxe38AdminService  , private localeService: LocaleAdminService, private trimService: TrimAdminService, private taxe38DetailService: Taxe38DetailAdminService, private locale38DetailService: Locale38DetailAdminService, private redevableService: RedevableAdminService, private tauxTaxe38Service: TauxTaxe38AdminService) {
        super(taxe38Service);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('Taxe38').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadRedevable();
                this.loadLocale();
                this.loadTrim();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'redevable?.id', header: 'Redevable'},
            {field: 'locale?.code', header: 'Locale'},
            {field: 'anne', header: 'Anne'},
            {field: 'trim?.id', header: 'Trim'},
            {field: 'datePresentaion', header: 'Date presentaion'},
            {field: 'nombreMoisRetard', header: 'Nombre mois retard'},
            {field: 'montantBase', header: 'Montant base'},
            {field: 'montantRetardPremeirMois', header: 'Montant retard premeir mois'},
            {field: 'montantTotal', header: 'Montant total'},
        ];
    }


    public async loadRedevable(){
       this.redevableService.findAll().subscribe(redevables => this.redevables = redevables, error => console.log(error))
    }
    public async loadLocale(){
       this.localeService.findAllOptimized().subscribe(locales => this.locales = locales, error => console.log(error))
    }
    public async loadTrim(){
       this.trimService.findAll().subscribe(trims => this.trims = trims, error => console.log(error))
    }

	public override initDuplicate(res: Taxe38Dto) {
        if (res.taxe38Details != null) {
             res.taxe38Details.forEach(d => { d.taxe38 = null; d.id = null; });
        }
	}


   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                'Redevable': e.redevable?.id ,
                'Locale': e.locale?.code ,
                 'Anne': e.anne ,
                'Trim': e.trim?.id ,
                'Date presentaion': this.datePipe.transform(e.datePresentaion , 'dd/MM/yyyy hh:mm'),
                 'Nombre mois retard': e.nombreMoisRetard ,
                 'Montant base': e.montantBase ,
                 'Montant retard premeir mois': e.montantRetardPremeirMois ,
                 'Montant total': e.montantTotal ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
        //'Redevable': this.criteria.redevable?.id ? this.criteria.redevable?.id : environment.emptyForExport ,
        //'Locale': this.criteria.locale?.code ? this.criteria.locale?.code : environment.emptyForExport ,
            'Anne Min': this.criteria.anneMin ? this.criteria.anneMin : environment.emptyForExport ,
            'Anne Max': this.criteria.anneMax ? this.criteria.anneMax : environment.emptyForExport ,
        //'Trim': this.criteria.trim?.id ? this.criteria.trim?.id : environment.emptyForExport ,
            'Date presentaion Min': this.criteria.datePresentaionFrom ? this.datePipe.transform(this.criteria.datePresentaionFrom , this.dateFormat) : environment.emptyForExport ,
            'Date presentaion Max': this.criteria.datePresentaionTo ? this.datePipe.transform(this.criteria.datePresentaionTo , this.dateFormat) : environment.emptyForExport ,
            'Nombre mois retard Min': this.criteria.nombreMoisRetardMin ? this.criteria.nombreMoisRetardMin : environment.emptyForExport ,
            'Nombre mois retard Max': this.criteria.nombreMoisRetardMax ? this.criteria.nombreMoisRetardMax : environment.emptyForExport ,
            'Montant base Min': this.criteria.montantBaseMin ? this.criteria.montantBaseMin : environment.emptyForExport ,
            'Montant base Max': this.criteria.montantBaseMax ? this.criteria.montantBaseMax : environment.emptyForExport ,
            'Montant retard premeir mois Min': this.criteria.montantRetardPremeirMoisMin ? this.criteria.montantRetardPremeirMoisMin : environment.emptyForExport ,
            'Montant retard premeir mois Max': this.criteria.montantRetardPremeirMoisMax ? this.criteria.montantRetardPremeirMoisMax : environment.emptyForExport ,
            'Montant total Min': this.criteria.montantTotalMin ? this.criteria.montantTotalMin : environment.emptyForExport ,
            'Montant total Max': this.criteria.montantTotalMax ? this.criteria.montantTotalMax : environment.emptyForExport ,
        }];
      }
}
