package  ma.zs.univ.ws.converter.NotificationPremierNiv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.univ.ws.converter.commun.LocaleConverter;
import ma.zs.univ.ws.converter.commun.RedevableConverter;



import ma.zs.univ.zynerator.util.StringUtil;
import ma.zs.univ.zynerator.converter.AbstractConverter;
import ma.zs.univ.zynerator.util.DateUtil;
import ma.zs.univ.bean.core.NotificationPremierNiv.NotificationRetardPremierNiveau;
import ma.zs.univ.ws.dto.NotificationPremierNiv.NotificationRetardPremierNiveauDto;

@Component
public class NotificationRetardPremierNiveauConverter extends AbstractConverter<NotificationRetardPremierNiveau, NotificationRetardPremierNiveauDto> {

    @Autowired
    private LocaleConverter localeConverter ;
    @Autowired
    private RedevableConverter redevableConverter ;
    private boolean locale;
    private boolean redevable;

    public  NotificationRetardPremierNiveauConverter() {
        super(NotificationRetardPremierNiveau.class, NotificationRetardPremierNiveauDto.class);
        init(true);
    }

    @Override
    public NotificationRetardPremierNiveau toItem(NotificationRetardPremierNiveauDto dto) {
        if (dto == null) {
            return null;
        } else {
        NotificationRetardPremierNiveau item = new NotificationRetardPremierNiveau();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getAnne()))
                item.setAnne(dto.getAnne());
            if(StringUtil.isNotEmpty(dto.getMontantBase()))
                item.setMontantBase(dto.getMontantBase());
            if(this.locale && dto.getLocale()!=null)
                item.setLocale(localeConverter.toItem(dto.getLocale())) ;

            if(this.redevable && dto.getRedevable()!=null)
                item.setRedevable(redevableConverter.toItem(dto.getRedevable())) ;




        return item;
        }
    }

    @Override
    public NotificationRetardPremierNiveauDto toDto(NotificationRetardPremierNiveau item) {
        if (item == null) {
            return null;
        } else {
            NotificationRetardPremierNiveauDto dto = new NotificationRetardPremierNiveauDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getAnne()))
                dto.setAnne(item.getAnne());
            if(StringUtil.isNotEmpty(item.getMontantBase()))
                dto.setMontantBase(item.getMontantBase());
            if(this.locale && item.getLocale()!=null) {
                dto.setLocale(localeConverter.toDto(item.getLocale())) ;

            }
            if(this.redevable && item.getRedevable()!=null) {
                dto.setRedevable(redevableConverter.toDto(item.getRedevable())) ;

            }


        return dto;
        }
    }

    public void copy(NotificationRetardPremierNiveauDto dto, NotificationRetardPremierNiveau t) {
    super.copy(dto, t);
    if (dto.getLocale() != null)
        localeConverter.copy(dto.getLocale(), t.getLocale());
    if (dto.getRedevable() != null)
        redevableConverter.copy(dto.getRedevable(), t.getRedevable());
    }



    public void initObject(boolean value) {
        this.locale = value;
        this.redevable = value;
    }


    public LocaleConverter getLocaleConverter(){
        return this.localeConverter;
    }
    public void setLocaleConverter(LocaleConverter localeConverter ){
        this.localeConverter = localeConverter;
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
}
