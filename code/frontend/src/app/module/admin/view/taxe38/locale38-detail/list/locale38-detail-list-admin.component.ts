import {Component, OnInit} from '@angular/core';
import {Locale38DetailAdminService} from 'src/app/shared/service/admin/taxe38/Locale38DetailAdmin.service';
import {Locale38DetailDto} from 'src/app/shared/model/taxe38/Locale38Detail.model';
import {Locale38DetailCriteria} from 'src/app/shared/criteria/taxe38/Locale38DetailCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {TypeLocale38DetailDto} from 'src/app/shared/model/taxe38/TypeLocale38Detail.model';
import {TypeLocale38DetailAdminService} from 'src/app/shared/service/admin/taxe38/TypeLocale38DetailAdmin.service';


@Component({
  selector: 'app-locale38-detail-list-admin',
  templateUrl: './locale38-detail-list-admin.component.html'
})
export class Locale38DetailListAdminComponent extends AbstractListController<Locale38DetailDto, Locale38DetailCriteria, Locale38DetailAdminService>  implements OnInit {

    override fileName = 'Locale38Detail';


     yesOrNoActive: any[] = [];
    typeLocale38Details: Array<TypeLocale38DetailDto>;


    constructor( private locale38DetailService: Locale38DetailAdminService  , private typeLocale38DetailService: TypeLocale38DetailAdminService) {
        super(locale38DetailService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('Locale38Detail').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadTypeLocale38Detail();
                this.yesOrNoActive =  [{label: 'Active', value: null},{label: 'Oui', value: 1},{label: 'Non', value: 0}];
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'superficie', header: 'Superficie'},
            {field: 'typeLocale38Detail?.code', header: 'Type locale38 detail'},
            {field: 'active', header: 'Active'},
        ];
    }


    public async loadTypeLocale38Detail(){
       this.typeLocale38DetailService.findAllOptimized().subscribe(typeLocale38Details => this.typeLocale38Details = typeLocale38Details, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                 'Superficie': e.superficie ,
                'Type locale38 detail': e.typeLocale38Detail?.code ,
                'Active': e.active? 'Vrai' : 'Faux' ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
            'Superficie Min': this.criteria.superficieMin ? this.criteria.superficieMin : environment.emptyForExport ,
            'Superficie Max': this.criteria.superficieMax ? this.criteria.superficieMax : environment.emptyForExport ,
        //'Type locale38 detail': this.criteria.typeLocale38Detail?.code ? this.criteria.typeLocale38Detail?.code : environment.emptyForExport ,
            'Active': this.criteria.active ? (this.criteria.active ? environment.trueValue : environment.falseValue) : environment.emptyForExport ,
        }];
      }
}
