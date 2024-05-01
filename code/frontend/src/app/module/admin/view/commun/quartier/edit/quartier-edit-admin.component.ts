import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {QuartierAdminService} from 'src/app/shared/service/admin/commun/QuartierAdmin.service';
import {QuartierDto} from 'src/app/shared/model/commun/Quartier.model';
import {QuartierCriteria} from 'src/app/shared/criteria/commun/QuartierCriteria.model';


import {SecteurDto} from 'src/app/shared/model/commun/Secteur.model';
import {SecteurAdminService} from 'src/app/shared/service/admin/commun/SecteurAdmin.service';

@Component({
  selector: 'app-quartier-edit-admin',
  templateUrl: './quartier-edit-admin.component.html'
})
export class QuartierEditAdminComponent extends AbstractEditController<QuartierDto, QuartierCriteria, QuartierAdminService>   implements OnInit {


    private _validQuartierCode = true;
    private _validQuartierLibelle = true;

    private _validSecteurCode = true;
    private _validSecteurLibelle = true;



    constructor( private quartierService: QuartierAdminService , private secteurService: SecteurAdminService) {
        super(quartierService);
    }

    ngOnInit(): void {
        this.secteur = new SecteurDto();
        this.secteurService.findAll().subscribe((data) => this.secteurs = data);
    }


    public override setValidation(value: boolean){
        this.validQuartierCode = value;
        this.validQuartierLibelle = value;
        }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateQuartierCode();
        this.validateQuartierLibelle();
    }
    public validateQuartierCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validQuartierCode = false;
        } else {
            this.validQuartierCode = true;
        }
    }
    public validateQuartierLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validQuartierLibelle = false;
        } else {
            this.validQuartierLibelle = true;
        }
    }



   public async openCreateSecteur(secteur: string) {
        const isPermistted = await this.roleService.isPermitted('Secteur', 'edit');
        if (isPermistted) {
             this.secteur = new SecteurDto();
             this.createSecteurDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

   get secteur(): SecteurDto {
       return this.secteurService.item;
   }
  set secteur(value: SecteurDto) {
        this.secteurService.item = value;
   }
   get secteurs(): Array<SecteurDto> {
        return this.secteurService.items;
   }
   set secteurs(value: Array<SecteurDto>) {
        this.secteurService.items = value;
   }
   get createSecteurDialog(): boolean {
       return this.secteurService.createDialog;
   }
  set createSecteurDialog(value: boolean) {
       this.secteurService.createDialog= value;
   }


    get validQuartierCode(): boolean {
        return this._validQuartierCode;
    }
    set validQuartierCode(value: boolean) {
        this._validQuartierCode = value;
    }
    get validQuartierLibelle(): boolean {
        return this._validQuartierLibelle;
    }
    set validQuartierLibelle(value: boolean) {
        this._validQuartierLibelle = value;
    }

    get validSecteurCode(): boolean {
        return this._validSecteurCode;
    }
    set validSecteurCode(value: boolean) {
        this._validSecteurCode = value;
    }
    get validSecteurLibelle(): boolean {
        return this._validSecteurLibelle;
    }
    set validSecteurLibelle(value: boolean) {
        this._validSecteurLibelle = value;
    }
}
