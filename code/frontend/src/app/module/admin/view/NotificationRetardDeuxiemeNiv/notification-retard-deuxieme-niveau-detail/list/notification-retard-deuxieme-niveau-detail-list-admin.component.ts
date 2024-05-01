import {Component, OnInit} from '@angular/core';
import {NotificationRetardDeuxiemeNiveauDetailAdminService} from 'src/app/shared/service/admin/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveauDetailAdmin.service';
import {NotificationRetardDeuxiemeNiveauDetailDto} from 'src/app/shared/model/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveauDetail.model';
import {NotificationRetardDeuxiemeNiveauDetailCriteria} from 'src/app/shared/criteria/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveauDetailCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {TrimDto} from 'src/app/shared/model/taxe38/Trim.model';
import {TrimAdminService} from 'src/app/shared/service/admin/taxe38/TrimAdmin.service';


@Component({
  selector: 'app-notification-retard-deuxieme-niveau-detail-list-admin',
  templateUrl: './notification-retard-deuxieme-niveau-detail-list-admin.component.html'
})
export class NotificationRetardDeuxiemeNiveauDetailListAdminComponent extends AbstractListController<NotificationRetardDeuxiemeNiveauDetailDto, NotificationRetardDeuxiemeNiveauDetailCriteria, NotificationRetardDeuxiemeNiveauDetailAdminService>  implements OnInit {

    override fileName = 'NotificationRetardDeuxiemeNiveauDetail';


    trims: Array<TrimDto>;


    constructor( private notificationRetardDeuxiemeNiveauDetailService: NotificationRetardDeuxiemeNiveauDetailAdminService  , private trimService: TrimAdminService) {
        super(notificationRetardDeuxiemeNiveauDetailService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('NotificationRetardDeuxiemeNiveauDetail').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadTrim();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'trim?.id', header: 'Trim'},
            {field: 'montantBase', header: 'Montant base'},
            {field: 'montantRetardPremierMois', header: 'Montant retard premier mois'},
            {field: 'montantRetardAutreMois', header: 'Montant retard autre mois'},
            {field: 'montantTotal', header: 'Montant total'},
        ];
    }


    public async loadTrim(){
       this.trimService.findAll().subscribe(trims => this.trims = trims, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                'Trim': e.trim?.id ,
                 'Montant base': e.montantBase ,
                 'Montant retard premier mois': e.montantRetardPremierMois ,
                 'Montant retard autre mois': e.montantRetardAutreMois ,
                 'Montant total': e.montantTotal ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
        //'Trim': this.criteria.trim?.id ? this.criteria.trim?.id : environment.emptyForExport ,
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
