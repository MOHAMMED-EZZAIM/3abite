package  ma.zs.univ.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.univ.ws.converter.commun.SecteurConverter;



import ma.zs.univ.zynerator.util.StringUtil;
import ma.zs.univ.zynerator.converter.AbstractConverter;
import ma.zs.univ.zynerator.util.DateUtil;
import ma.zs.univ.bean.core.commun.Quartier;
import ma.zs.univ.ws.dto.commun.QuartierDto;

@Component
public class QuartierConverter extends AbstractConverter<Quartier, QuartierDto> {

    @Autowired
    private SecteurConverter secteurConverter ;
    private boolean secteur;

    public  QuartierConverter() {
        super(Quartier.class, QuartierDto.class);
        init(true);
    }

    @Override
    public Quartier toItem(QuartierDto dto) {
        if (dto == null) {
            return null;
        } else {
        Quartier item = new Quartier();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(this.secteur && dto.getSecteur()!=null)
                item.setSecteur(secteurConverter.toItem(dto.getSecteur())) ;




        return item;
        }
    }

    @Override
    public QuartierDto toDto(Quartier item) {
        if (item == null) {
            return null;
        } else {
            QuartierDto dto = new QuartierDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(this.secteur && item.getSecteur()!=null) {
                dto.setSecteur(secteurConverter.toDto(item.getSecteur())) ;

            }


        return dto;
        }
    }

    public void copy(QuartierDto dto, Quartier t) {
    super.copy(dto, t);
    if (dto.getSecteur() != null)
        secteurConverter.copy(dto.getSecteur(), t.getSecteur());
    }



    public void initObject(boolean value) {
        this.secteur = value;
    }


    public SecteurConverter getSecteurConverter(){
        return this.secteurConverter;
    }
    public void setSecteurConverter(SecteurConverter secteurConverter ){
        this.secteurConverter = secteurConverter;
    }
    public boolean  isSecteur(){
        return this.secteur;
    }
    public void  setSecteur(boolean secteur){
        this.secteur = secteur;
    }
}
