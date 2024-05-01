package  ma.zs.univ.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.univ.ws.converter.commun.QuartierConverter;



import ma.zs.univ.zynerator.util.StringUtil;
import ma.zs.univ.zynerator.converter.AbstractConverter;
import ma.zs.univ.zynerator.util.DateUtil;
import ma.zs.univ.bean.core.commun.Rue;
import ma.zs.univ.ws.dto.commun.RueDto;

@Component
public class RueConverter extends AbstractConverter<Rue, RueDto> {

    @Autowired
    private QuartierConverter quartierConverter ;
    private boolean quartier;

    public  RueConverter() {
        super(Rue.class, RueDto.class);
        init(true);
    }

    @Override
    public Rue toItem(RueDto dto) {
        if (dto == null) {
            return null;
        } else {
        Rue item = new Rue();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(this.quartier && dto.getQuartier()!=null)
                item.setQuartier(quartierConverter.toItem(dto.getQuartier())) ;




        return item;
        }
    }

    @Override
    public RueDto toDto(Rue item) {
        if (item == null) {
            return null;
        } else {
            RueDto dto = new RueDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(this.quartier && item.getQuartier()!=null) {
                dto.setQuartier(quartierConverter.toDto(item.getQuartier())) ;

            }


        return dto;
        }
    }

    public void copy(RueDto dto, Rue t) {
    super.copy(dto, t);
    if (dto.getQuartier() != null)
        quartierConverter.copy(dto.getQuartier(), t.getQuartier());
    }



    public void initObject(boolean value) {
        this.quartier = value;
    }


    public QuartierConverter getQuartierConverter(){
        return this.quartierConverter;
    }
    public void setQuartierConverter(QuartierConverter quartierConverter ){
        this.quartierConverter = quartierConverter;
    }
    public boolean  isQuartier(){
        return this.quartier;
    }
    public void  setQuartier(boolean quartier){
        this.quartier = quartier;
    }
}
