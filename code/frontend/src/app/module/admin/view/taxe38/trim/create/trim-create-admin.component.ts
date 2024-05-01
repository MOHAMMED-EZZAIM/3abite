import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {TrimAdminService} from 'src/app/shared/service/admin/taxe38/TrimAdmin.service';
import {TrimDto} from 'src/app/shared/model/taxe38/Trim.model';
import {TrimCriteria} from 'src/app/shared/criteria/taxe38/TrimCriteria.model';
@Component({
  selector: 'app-trim-create-admin',
  templateUrl: './trim-create-admin.component.html'
})
export class TrimCreateAdminComponent extends AbstractCreateController<TrimDto, TrimCriteria, TrimAdminService>  implements OnInit {



   private _validTrimLibelle = true;

    constructor( private trimService: TrimAdminService ) {
        super(trimService);
    }

    ngOnInit(): void {
    }





    public override setValidation(value: boolean){
        this.validTrimLibelle = value;
    }



    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateTrimLibelle();
    }

    public validateTrimLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validTrimLibelle = false;
        } else {
            this.validTrimLibelle = true;
        }
    }






    get validTrimLibelle(): boolean {
        return this._validTrimLibelle;
    }

    set validTrimLibelle(value: boolean) {
         this._validTrimLibelle = value;
    }



}
