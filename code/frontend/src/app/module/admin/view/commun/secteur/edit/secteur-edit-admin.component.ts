import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {SecteurAdminService} from 'src/app/shared/service/admin/commun/SecteurAdmin.service';
import {SecteurDto} from 'src/app/shared/model/commun/Secteur.model';
import {SecteurCriteria} from 'src/app/shared/criteria/commun/SecteurCriteria.model';


import {VilleDto} from 'src/app/shared/model/commun/Ville.model';
import {VilleAdminService} from 'src/app/shared/service/admin/commun/VilleAdmin.service';

@Component({
  selector: 'app-secteur-edit-admin',
  templateUrl: './secteur-edit-admin.component.html'
})
export class SecteurEditAdminComponent extends AbstractEditController<SecteurDto, SecteurCriteria, SecteurAdminService>   implements OnInit {


    private _validSecteurCode = true;
    private _validSecteurLibelle = true;

    private _validVilleCode = true;
    private _validVilleLibelle = true;



    constructor( private secteurService: SecteurAdminService , private villeService: VilleAdminService) {
        super(secteurService);
    }

    ngOnInit(): void {
        this.ville = new VilleDto();
        this.villeService.findAll().subscribe((data) => this.villes = data);
    }


    public override setValidation(value: boolean){
        this.validSecteurCode = value;
        this.validSecteurLibelle = value;
        }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateSecteurCode();
        this.validateSecteurLibelle();
    }
    public validateSecteurCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validSecteurCode = false;
        } else {
            this.validSecteurCode = true;
        }
    }
    public validateSecteurLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validSecteurLibelle = false;
        } else {
            this.validSecteurLibelle = true;
        }
    }



   public async openCreateVille(ville: string) {
        const isPermistted = await this.roleService.isPermitted('Ville', 'edit');
        if (isPermistted) {
             this.ville = new VilleDto();
             this.createVilleDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

   get ville(): VilleDto {
       return this.villeService.item;
   }
  set ville(value: VilleDto) {
        this.villeService.item = value;
   }
   get villes(): Array<VilleDto> {
        return this.villeService.items;
   }
   set villes(value: Array<VilleDto>) {
        this.villeService.items = value;
   }
   get createVilleDialog(): boolean {
       return this.villeService.createDialog;
   }
  set createVilleDialog(value: boolean) {
       this.villeService.createDialog= value;
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

    get validVilleCode(): boolean {
        return this._validVilleCode;
    }
    set validVilleCode(value: boolean) {
        this._validVilleCode = value;
    }
    get validVilleLibelle(): boolean {
        return this._validVilleLibelle;
    }
    set validVilleLibelle(value: boolean) {
        this._validVilleLibelle = value;
    }
}
