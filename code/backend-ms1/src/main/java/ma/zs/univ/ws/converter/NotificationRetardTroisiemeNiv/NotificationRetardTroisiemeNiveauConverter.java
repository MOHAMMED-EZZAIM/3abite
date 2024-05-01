package  ma.zs.univ.ws.converter.NotificationRetardTroisiemeNiv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.univ.ws.converter.commun.LocaleConverter;
import ma.zs.univ.ws.converter.taxe38.TrimConverter;
import ma.zs.univ.ws.converter.commun.RedevableConverter;



import ma.zs.univ.zynerator.util.StringUtil;
import ma.zs.univ.zynerator.converter.AbstractConverter;
import ma.zs.univ.zynerator.util.DateUtil;
import ma.zs.univ.bean.core.NotificationRetardTroisiemeNiv.NotificationRetardTroisiemeNiveau;
import ma.zs.univ.ws.dto.NotificationRetardTroisiemeNiv.NotificationRetardTroisiemeNiveauDto;

@Component
public class NotificationRetardTroisiemeNiveauConverter extends AbstractConverter<NotificationRetardTroisiemeNiveau, NotificationRetardTroisiemeNiveauDto> {

    @Autowired
    private LocaleConverter localeConverter ;
    @Autowired
    private TrimConverter trimConverter ;
    @Autowired
    private RedevableConverter redevableConverter ;
    private boolean locale;
    private boolean redevable;
    private boolean trim;

    public  NotificationRetardTroisiemeNiveauConverter() {
        super(NotificationRetardTroisiemeNiveau.class, NotificationRetardTroisiemeNiveauDto.class);
        init(true);
    }

    @Override
    public NotificationRetardTroisiemeNiveau toItem(NotificationRetardTroisiemeNiveauDto dto) {
        if (dto == null) {
            return null;
        } else {
        NotificationRetardTroisiemeNiveau item = new NotificationRetardTroisiemeNiveau();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getAnne()))
                item.setAnne(dto.getAnne());
            if(this.locale && dto.getLocale()!=null)
                item.setLocale(localeConverter.toItem(dto.getLocale())) ;

            if(this.redevable && dto.getRedevable()!=null)
                item.setRedevable(redevableConverter.toItem(dto.getRedevable())) ;

            if(this.trim && dto.getTrim()!=null)
                item.setTrim(trimConverter.toItem(dto.getTrim())) ;




        return item;
        }
    }

    @Override
    public NotificationRetardTroisiemeNiveauDto toDto(NotificationRetardTroisiemeNiveau item) {
        if (item == null) {
            return null;
        } else {
            NotificationRetardTroisiemeNiveauDto dto = new NotificationRetardTroisiemeNiveauDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getAnne()))
                dto.setAnne(item.getAnne());
            if(this.locale && item.getLocale()!=null) {
                dto.setLocale(localeConverter.toDto(item.getLocale())) ;

            }
            if(this.redevable && item.getRedevable()!=null) {
                dto.setRedevable(redevableConverter.toDto(item.getRedevable())) ;

            }
            if(this.trim && item.getTrim()!=null) {
                dto.setTrim(trimConverter.toDto(item.getTrim())) ;

            }


        return dto;
        }
    }

    public void copy(NotificationRetardTroisiemeNiveauDto dto, NotificationRetardTroisiemeNiveau t) {
    super.copy(dto, t);
    if (dto.getLocale() != null)
        localeConverter.copy(dto.getLocale(), t.getLocale());
    if (dto.getRedevable() != null)
        redevableConverter.copy(dto.getRedevable(), t.getRedevable());
    if (dto.getTrim() != null)
        trimConverter.copy(dto.getTrim(), t.getTrim());
    }



    public void initObject(boolean value) {
        this.locale = value;
        this.redevable = value;
        this.trim = value;
    }


    public LocaleConverter getLocaleConverter(){
        return this.localeConverter;
    }
    public void setLocaleConverter(LocaleConverter localeConverter ){
        this.localeConverter = localeConverter;
    }
    public TrimConverter getTrimConverter(){
        return this.trimConverter;
    }
    public void setTrimConverter(TrimConverter trimConverter ){
        this.trimConverter = trimConverter;
    }
    public RedevableConverter getRedevableConverter(){
        return this.redevableConverter;
    }
    public void setRedevableConverter(RedevableConverter redevableConverter ){
        this.redevableConverter = redevableConverter;
    }
    public boolean  isLocale(){
        return this.locale;
    }
    public void  setLocale(boolean locale){
        this.locale = locale;
    }
    public boolean  isRedevable(){
        return this.redevable;
    }
    public void  setRedevable(boolean redevable){
        this.redevable = redevable;
    }
    public boolean  isTrim(){
        return this.trim;
    }
    public void  setTrim(boolean trim){
        this.trim = trim;
    }
}
