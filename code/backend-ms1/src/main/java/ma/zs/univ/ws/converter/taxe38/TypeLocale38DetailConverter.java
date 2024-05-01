package  ma.zs.univ.ws.converter.taxe38;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.univ.zynerator.util.StringUtil;
import ma.zs.univ.zynerator.converter.AbstractConverter;
import ma.zs.univ.zynerator.util.DateUtil;
import ma.zs.univ.bean.core.taxe38.TypeLocale38Detail;
import ma.zs.univ.ws.dto.taxe38.TypeLocale38DetailDto;

@Component
public class TypeLocale38DetailConverter extends AbstractConverter<TypeLocale38Detail, TypeLocale38DetailDto> {


    public  TypeLocale38DetailConverter() {
        super(TypeLocale38Detail.class, TypeLocale38DetailDto.class);
    }

    @Override
    public TypeLocale38Detail toItem(TypeLocale38DetailDto dto) {
        if (dto == null) {
            return null;
        } else {
        TypeLocale38Detail item = new TypeLocale38Detail();
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
    public TypeLocale38DetailDto toDto(TypeLocale38Detail item) {
        if (item == null) {
            return null;
        } else {
            TypeLocale38DetailDto dto = new TypeLocale38DetailDto();
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
