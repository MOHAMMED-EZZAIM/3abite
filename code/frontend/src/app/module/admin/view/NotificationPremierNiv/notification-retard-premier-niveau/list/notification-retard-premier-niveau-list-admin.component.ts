import {Component, OnInit} from '@angular/core';
import {NotificationRetardPremierNiveauAdminService} from 'src/app/shared/service/admin/NotificationPremierNiv/NotificationRetardPremierNiveauAdmin.service';
import {NotificationRetardPremierNiveauDto} from 'src/app/shared/model/NotificationPremierNiv/NotificationRetardPremierNiveau.model';
import {NotificationRetardPremierNiveauCriteria} from 'src/app/shared/criteria/NotificationPremierNiv/NotificationRetardPremierNiveauCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {LocaleDto} from 'src/app/shared/model/commun/Locale.model';
import {LocaleAdminService} from 'src/app/shared/service/admin/commun/LocaleAdmin.service';
import {RedevableDto} from 'src/app/shared/model/commun/Redevable.model';
import {RedevableAdminService} from 'src/app/shared/service/admin/commun/RedevableAdmin.service';


@Component({
  selector: 'app-notification-retard-premier-niveau-list-admin',
  templateUrl: './notification-retard-premier-niveau-list-admin.component.html'
})
export class NotificationRetardPremierNiveauListAdminComponent extends AbstractListController<NotificationRetardPremierNiveauDto, NotificationRetardPremierNiveauCriteria, NotificationRetardPremierNiveauAdminService>  implements OnInit {

    override fileName = 'NotificationRetardPremierNiveau';


    locales: Array<LocaleDto>;
    redevables: Array<RedevableDto>;


    constructor( private notificationRetardPremierNiveauService: NotificationRetardPremierNiveauAdminService  , private localeService: LocaleAdminService, private redevableService: RedevableAdminService) {
        super(notificationRetardPremierNiveauService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('NotificationRetardPremierNiveau').subscribe(() => {
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
        }];
      }
}
