package  ma.zs.univ.ws.converter.taxe38;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.univ.zynerator.util.StringUtil;
import ma.zs.univ.zynerator.converter.AbstractConverter;
import ma.zs.univ.zynerator.util.DateUtil;
import ma.zs.univ.bean.core.taxe38.Trim;
import ma.zs.univ.ws.dto.taxe38.TrimDto;

@Component
public class TrimConverter extends AbstractConverter<Trim, TrimDto> {


    public  TrimConverter() {
        super(Trim.class, TrimDto.class);
    }

    @Override
    public Trim toItem(TrimDto dto) {
        if (dto == null) {
            return null;
        } else {
        Trim item = new Trim();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getNumero()))
                item.setNumero(dto.getNumero());



        return item;
        }
    }

    @Override
    public TrimDto toDto(Trim item) {
        if (item == null) {
            return null;
        } else {
            TrimDto dto = new TrimDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getNumero()))
                dto.setNumero(item.getNumero());


        return dto;
        }
    }




    public void initObject(boolean value) {
    }


}
