import {Component, OnInit} from '@angular/core';
import {NotificationRetardTroisiemeNiveauAdminService} from 'src/app/shared/service/admin/NotificationRetardTroisiemeNiv/NotificationRetardTroisiemeNiveauAdmin.service';
import {NotificationRetardTroisiemeNiveauDto} from 'src/app/shared/model/NotificationRetardTroisiemeNiv/NotificationRetardTroisiemeNiveau.model';
import {NotificationRetardTroisiemeNiveauCriteria} from 'src/app/shared/criteria/NotificationRetardTroisiemeNiv/NotificationRetardTroisiemeNiveauCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {LocaleDto} from 'src/app/shared/model/commun/Locale.model';
import {LocaleAdminService} from 'src/app/shared/service/admin/commun/LocaleAdmin.service';
import {TrimDto} from 'src/app/shared/model/taxe38/Trim.model';
import {TrimAdminService} from 'src/app/shared/service/admin/taxe38/TrimAdmin.service';
import {RedevableDto} from 'src/app/shared/model/commun/Redevable.model';
import {RedevableAdminService} from 'src/app/shared/service/admin/commun/RedevableAdmin.service';


@Component({
  selector: 'app-notification-retard-troisieme-niveau-list-admin',
  templateUrl: './notification-retard-troisieme-niveau-list-admin.component.html'
})
export class NotificationRetardTroisiemeNiveauListAdminComponent extends AbstractListController<NotificationRetardTroisiemeNiveauDto, NotificationRetardTroisiemeNiveauCriteria, NotificationRetardTroisiemeNiveauAdminService>  implements OnInit {

    override fileName = 'NotificationRetardTroisiemeNiveau';


    locales: Array<LocaleDto>;
    redevables: Array<RedevableDto>;
    trims: Array<TrimDto>;


    constructor( private notificationRetardTroisiemeNiveauService: NotificationRetardTroisiemeNiveauAdminService  , private localeService: LocaleAdminService, private trimService: TrimAdminService, private redevableService: RedevableAdminService) {
        super(notificationRetardTroisiemeNiveauService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('NotificationRetardTroisiemeNiveau').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadLocale();
                this.loadRedevable();
                this.loadTrim();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'locale?.code', header: 'Locale'},
            {field: 'redevable?.id', header: 'Redevable'},
            {field: 'anne', header: 'Anne'},
            {field: 'trim?.id', header: 'Trim'},
        ];
    }


    public async loadLocale(){
       this.localeService.findAllOptimized().subscribe(locales => this.locales = locales, error => console.log(error))
    }
    public async loadRedevable(){
       this.redevableService.findAll().subscribe(redevables => this.redevables = redevables, error => console.log(error))
    }
    public async loadTrim(){
       this.trimService.findAll().subscribe(trims => this.trims = trims, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                'Locale': e.locale?.code ,
                'Redevable': e.redevable?.id ,
                 'Anne': e.anne ,
                'Trim': e.trim?.id ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
        //'Locale': this.criteria.locale?.code ? this.criteria.locale?.code : environment.emptyForExport ,
        //'Redevable': this.criteria.redevable?.id ? this.criteria.redevable?.id : environment.emptyForExport ,
            'Anne Min': this.criteria.anneMin ? this.criteria.anneMin : environment.emptyForExport ,
            'Anne Max': this.criteria.anneMax ? this.criteria.anneMax : environment.emptyForExport ,
        //'Trim': this.criteria.trim?.id ? this.criteria.trim?.id : environment.emptyForExport ,
        }];
      }
}
