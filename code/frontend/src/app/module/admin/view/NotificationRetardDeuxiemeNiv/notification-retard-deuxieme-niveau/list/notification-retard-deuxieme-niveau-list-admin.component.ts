import {Component, OnInit} from '@angular/core';
import {NotificationRetardDeuxiemeNiveauAdminService} from 'src/app/shared/service/admin/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveauAdmin.service';
import {NotificationRetardDeuxiemeNiveauDto} from 'src/app/shared/model/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveau.model';
import {NotificationRetardDeuxiemeNiveauCriteria} from 'src/app/shared/criteria/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveauCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {LocaleDto} from 'src/app/shared/model/commun/Locale.model';
import {LocaleAdminService} from 'src/app/shared/service/admin/commun/LocaleAdmin.service';
import {RedevableDto} from 'src/app/shared/model/commun/Redevable.model';
import {RedevableAdminService} from 'src/app/shared/service/admin/commun/RedevableAdmin.service';


@Component({
  selector: 'app-notification-retard-deuxieme-niveau-list-admin',
  templateUrl: './notification-retard-deuxieme-niveau-list-admin.component.html'
})
export class NotificationRetardDeuxiemeNiveauListAdminComponent extends AbstractListController<NotificationRetardDeuxiemeNiveauDto, NotificationRetardDeuxiemeNiveauCriteria, NotificationRetardDeuxiemeNiveauAdminService>  implements OnInit {

    override fileName = 'NotificationRetardDeuxiemeNiveau';


    locales: Array<LocaleDto>;
    redevables: Array<RedevableDto>;


    constructor( private notificationRetardDeuxiemeNiveauService: NotificationRetardDeuxiemeNiveauAdminService  , private localeService: LocaleAdminService, private redevableService: RedevableAdminService) {
        super(notificationRetardDeuxiemeNiveauService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('NotificationRetardDeuxiemeNiveau').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadLocale();
                this.loadRedevable();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'locale?.code', header: 'Locale'},
            {field: 'redevable?.id', header: 'Redevable'},
            {field: 'anne', header: 'Anne'},
            {field: 'montantBase', header: 'Montant base'},
            {field: 'montantRetardPremierMois', header: 'Montant retard premier mois'},
            {field: 'montantRetardAutreMois', header: 'Montant retard autre mois'},
            {field: 'montantTotal', header: 'Montant total'},
        ];
    }


    public async loadLocale(){
       this.localeService.findAllOptimized().subscribe(locales => this.locales = locales, error => console.log(error))
    }
    public async loadRedevable(){
       this.redevableService.findAll().subscribe(redevables => this.redevables = redevables, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                'Locale': e.locale?.code ,
                'Redevable': e.redevable?.id ,
                 'Anne': e.anne ,
                 'Montant base': e.montantBase ,
                 'Montant retard premier mois': e.montantRetardPremierMois ,
                 'Montant retard autre mois': e.montantRetardAutreMois ,
                 'Montant total': e.montantTotal ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
        //'Locale': this.criteria.locale?.code ? this.criteria.locale?.code : environment.emptyForExport ,
        //'Redevable': this.criteria.redevable?.id ? this.criteria.redevable?.id : environment.emptyForExport ,
            'Anne Min': this.criteria.anneMin ? this.criteria.anneMin : environment.emptyForExport ,
            'Anne Max': this.criteria.anneMax ? this.criteria.anneMax : environment.emptyForExport ,
            'Montant base Min': this.criteria.montantBaseMin ? this.criteria.montantBaseMin : environment.emptyForExport ,
            'Montant base Max': this.criteria.montantBaseMax ? this.criteria.montantBaseMax : environment.emptyForExport ,
            'Montant retard premier mois Min': this.criteria.montantRetardPremierMoisMin ? this.criteria.montantRetardPremierMoisMin : environment.emptyForExport ,
            'Montant retard premier mois Max': this.criteria.montantRetardPremierMoisMax ? this.criteria.montantRetardPremierMoisMax : environment.emptyForExport ,
            'Montant retard autre mois Min': this.criteria.montantRetardAutreMoisMin ? this.criteria.montantRetardAutreMoisMin : environment.emptyForExport ,
            'Montant retard autre mois Max': this.criteria.montantRetardAutreMoisMax ? this.criteria.montantRetardAutreMoisMax : environment.emptyForExport ,
            'Montant total Min': this.criteria.montantTotalMin ? this.criteria.montantTotalMin : environment.emptyForExport ,
            'Montant total Max': this.criteria.montantTotalMax ? this.criteria.montantTotalMax : environment.emptyForExport ,
        }];
      }
}
