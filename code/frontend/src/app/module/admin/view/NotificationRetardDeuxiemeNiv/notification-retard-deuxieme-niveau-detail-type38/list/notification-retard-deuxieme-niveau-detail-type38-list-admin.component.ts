import {Component, OnInit} from '@angular/core';
import {NotificationRetardDeuxiemeNiveauDetailType38AdminService} from 'src/app/shared/service/admin/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveauDetailType38Admin.service';
import {NotificationRetardDeuxiemeNiveauDetailType38Dto} from 'src/app/shared/model/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveauDetailType38.model';
import {NotificationRetardDeuxiemeNiveauDetailType38Criteria} from 'src/app/shared/criteria/NotificationRetardDeuxiemeNiv/NotificationRetardDeuxiemeNiveauDetailType38Criteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {TypeLocale38DetailDto} from 'src/app/shared/model/taxe38/TypeLocale38Detail.model';
import {TypeLocale38DetailAdminService} from 'src/app/shared/service/admin/taxe38/TypeLocale38DetailAdmin.service';


@Component({
  selector: 'app-notification-retard-deuxieme-niveau-detail-type38-list-admin',
  templateUrl: './notification-retard-deuxieme-niveau-detail-type38-list-admin.component.html'
})
export class NotificationRetardDeuxiemeNiveauDetailType38ListAdminComponent extends AbstractListController<NotificationRetardDeuxiemeNiveauDetailType38Dto, NotificationRetardDeuxiemeNiveauDetailType38Criteria, NotificationRetardDeuxiemeNiveauDetailType38AdminService>  implements OnInit {

    override fileName = 'NotificationRetardDeuxiemeNiveauDetailType38';


    typeLocale38s: Array<TypeLocale38DetailDto>;


    constructor( private notificationRetardDeuxiemeNiveauDetailType38Service: NotificationRetardDeuxiemeNiveauDetailType38AdminService  , private typeLocale38DetailService: TypeLocale38DetailAdminService) {
        super(notificationRetardDeuxiemeNiveauDetailType38Service);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('NotificationRetardDeuxiemeNiveauDetailType38').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadTypeLocale38();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'typeLocale38?.code', header: 'Type locale38'},
            {field: 'montantBase', header: 'Montant base'},
            {field: 'montantRetardPremierMois', header: 'Montant retard premier mois'},
            {field: 'montantRetardAutreMois', header: 'Montant retard autre mois'},
            {field: 'montantTotal', header: 'Montant total'},
        ];
    }


    public async loadTypeLocale38(){
       this.typeLocale38DetailService.findAllOptimized().subscribe(typeLocale38s => this.typeLocale38s = typeLocale38s, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                'Type locale38': e.typeLocale38?.code ,
                 'Montant base': e.montantBase ,
                 'Montant retard premier mois': e.montantRetardPremierMois ,
                 'Montant retard autre mois': e.montantRetardAutreMois ,
                 'Montant total': e.montantTotal ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
        //'Type locale38': this.criteria.typeLocale38?.code ? this.criteria.typeLocale38?.code : environment.emptyForExport ,
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
