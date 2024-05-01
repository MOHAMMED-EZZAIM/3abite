package  ma.zs.univ.ws.converter.NotificationRetardDeuxiemeNiv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.univ.ws.converter.taxe38.TrimConverter;



import ma.zs.univ.zynerator.util.StringUtil;
import ma.zs.univ.zynerator.converter.AbstractConverter;
import ma.zs.univ.zynerator.util.DateUtil;
import ma.zs.univ.bean.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetail;
import ma.zs.univ.ws.dto.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailDto;

@Component
public class NotificationRetardDeuxiemeNiveauDetailConverter extends AbstractConverter<NotificationRetardDeuxiemeNiveauDetail, NotificationRetardDeuxiemeNiveauDetailDto> {

    @Autowired
    private TrimConverter trimConverter ;
    private boolean trim;

    public  NotificationRetardDeuxiemeNiveauDetailConverter() {
        super(NotificationRetardDeuxiemeNiveauDetail.class, NotificationRetardDeuxiemeNiveauDetailDto.class);
        init(true);
    }

    @Override
    public NotificationRetardDeuxiemeNiveauDetail toItem(NotificationRetardDeuxiemeNiveauDetailDto dto) {
        if (dto == null) {
            return null;
        } else {
        NotificationRetardDeuxiemeNiveauDetail item = new NotificationRetardDeuxiemeNiveauDetail();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getMontantBase()))
                item.setMontantBase(dto.getMontantBase());
            if(StringUtil.isNotEmpty(dto.getMontantRetardPremierMois()))
                item.setMontantRetardPremierMois(dto.getMontantRetardPremierMois());
            if(StringUtil.isNotEmpty(dto.getMontantRetardAutreMois()))
                item.setMontantRetardAutreMois(dto.getMontantRetardAutreMois());
            if(StringUtil.isNotEmpty(dto.getMontantTotal()))
                item.setMontantTotal(dto.getMontantTotal());
            if(this.trim && dto.getTrim()!=null)
                item.setTrim(trimConverter.toItem(dto.getTrim())) ;




        return item;
        }
    }

    @Override
    public NotificationRetardDeuxiemeNiveauDetailDto toDto(NotificationRetardDeuxiemeNiveauDetail item) {
        if (item == null) {
            return null;
        } else {
            NotificationRetardDeuxiemeNiveauDetailDto dto = new NotificationRetardDeuxiemeNiveauDetailDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getMontantBase()))
                dto.setMontantBase(item.getMontantBase());
            if(StringUtil.isNotEmpty(item.getMontantRetardPremierMois()))
                dto.setMontantRetardPremierMois(item.getMontantRetardPremierMois());
            if(StringUtil.isNotEmpty(item.getMontantRetardAutreMois()))
                dto.setMontantRetardAutreMois(item.getMontantRetardAutreMois());
            if(StringUtil.isNotEmpty(item.getMontantTotal()))
                dto.setMontantTotal(item.getMontantTotal());
            if(this.trim && item.getTrim()!=null) {
                dto.setTrim(trimConverter.toDto(item.getTrim())) ;

            }


        return dto;
        }
    }

    public void copy(NotificationRetardDeuxiemeNiveauDetailDto dto, NotificationRetardDeuxiemeNiveauDetail t) {
    super.copy(dto, t);
    if (dto.getTrim() != null)
        trimConverter.copy(dto.getTrim(), t.getTrim());
    }



    public void initObject(boolean value) {
        this.trim = value;
    }


    public TrimConverter getTrimConverter(){
        return this.trimConverter;
    }
    public void setTrimConverter(TrimConverter trimConverter ){
        this.trimConverter = trimConverter;
    }
    public boolean  isTrim(){
        return this.trim;
    }
    public void  setTrim(boolean trim){
        this.trim = trim;
    }
}
