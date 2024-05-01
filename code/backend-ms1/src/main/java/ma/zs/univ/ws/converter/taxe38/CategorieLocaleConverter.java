package  ma.zs.univ.ws.converter.taxe38;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.univ.zynerator.util.StringUtil;
import ma.zs.univ.zynerator.converter.AbstractConverter;
import ma.zs.univ.zynerator.util.DateUtil;
import ma.zs.univ.bean.core.taxe38.CategorieLocale;
import ma.zs.univ.ws.dto.taxe38.CategorieLocaleDto;

@Component
public class CategorieLocaleConverter extends AbstractConverter<CategorieLocale, CategorieLocaleDto> {


    public  CategorieLocaleConverter() {
        super(CategorieLocale.class, CategorieLocaleDto.class);
    }

    @Override
    public CategorieLocale toItem(CategorieLocaleDto dto) {
        if (dto == null) {
            return null;
        } else {
        CategorieLocale item = new CategorieLocale();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());



        return item;
        }
    }

    @Override
    public CategorieLocaleDto toDto(CategorieLocale item) {
        if (item == null) {
            return null;
        } else {
            CategorieLocaleDto dto = new CategorieLocaleDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());


        return dto;
        }
    }




    public void initObject(boolean value) {
    }


}
