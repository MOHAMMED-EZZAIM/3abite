package  ma.zs.univ.ws.converter.taxe38;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.univ.ws.converter.taxe38.TypeLocale38DetailConverter;
import ma.zs.univ.ws.converter.taxe38.CategorieLocaleConverter;



import ma.zs.univ.zynerator.util.StringUtil;
import ma.zs.univ.zynerator.converter.AbstractConverter;
import ma.zs.univ.zynerator.util.DateUtil;
import ma.zs.univ.bean.core.taxe38.TauxTaxe38;
import ma.zs.univ.ws.dto.taxe38.TauxTaxe38Dto;

@Component
public class TauxTaxe38Converter extends AbstractConverter<TauxTaxe38, TauxTaxe38Dto> {

    @Autowired
    private TypeLocale38DetailConverter typeLocale38DetailConverter ;
    @Autowired
    private CategorieLocaleConverter categorieLocaleConverter ;
    private boolean typeLocale38Detail;
    private boolean categorieLocale;

    public  TauxTaxe38Converter() {
        super(TauxTaxe38.class, TauxTaxe38Dto.class);
        init(true);
    }

    @Override
    public TauxTaxe38 toItem(TauxTaxe38Dto dto) {
        if (dto == null) {
            return null;
        } else {
        TauxTaxe38 item = new TauxTaxe38();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getMontantParMetreCarre()))
                item.setMontantParMetreCarre(dto.getMontantParMetreCarre());
            if(StringUtil.isNotEmpty(dto.getDateMin()))
                item.setDateMin(DateUtil.stringEnToDate(dto.getDateMin()));
            if(StringUtil.isNotEmpty(dto.getDateMax()))
                item.setDateMax(DateUtil.stringEnToDate(dto.getDateMax()));
            if(StringUtil.isNotEmpty(dto.getPourcentagePremierRetard()))
                item.setPourcentagePremierRetard(dto.getPourcentagePremierRetard());
            if(StringUtil.isNotEmpty(dto.getPourcentageAutreMoisRetard()))
                item.setPourcentageAutreMoisRetard(dto.getPourcentageAutreMoisRetard());
            if(this.typeLocale38Detail && dto.getTypeLocale38Detail()!=null)
                item.setTypeLocale38Detail(typeLocale38DetailConverter.toItem(dto.getTypeLocale38Detail())) ;

            if(this.categorieLocale && dto.getCategorieLocale()!=null)
                item.setCategorieLocale(categorieLocaleConverter.toItem(dto.getCategorieLocale())) ;




        return item;
        }
    }

    @Override
    public TauxTaxe38Dto toDto(TauxTaxe38 item) {
        if (item == null) {
            return null;
        } else {
            TauxTaxe38Dto dto = new TauxTaxe38Dto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getMontantParMetreCarre()))
                dto.setMontantParMetreCarre(item.getMontantParMetreCarre());
            if(item.getDateMin()!=null)
                dto.setDateMin(DateUtil.dateTimeToString(item.getDateMin()));
            if(item.getDateMax()!=null)
                dto.setDateMax(DateUtil.dateTimeToString(item.getDateMax()));
            if(StringUtil.isNotEmpty(item.getPourcentagePremierRetard()))
                dto.setPourcentagePremierRetard(item.getPourcentagePremierRetard());
            if(StringUtil.isNotEmpty(item.getPourcentageAutreMoisRetard()))
                dto.setPourcentageAutreMoisRetard(item.getPourcentageAutreMoisRetard());
            if(this.typeLocale38Detail && item.getTypeLocale38Detail()!=null) {
                dto.setTypeLocale38Detail(typeLocale38DetailConverter.toDto(item.getTypeLocale38Detail())) ;

            }
            if(this.categorieLocale && item.getCategorieLocale()!=null) {
                dto.setCategorieLocale(categorieLocaleConverter.toDto(item.getCategorieLocale())) ;

            }


        return dto;
        }
    }

    public void copy(TauxTaxe38Dto dto, TauxTaxe38 t) {
    super.copy(dto, t);
    if (dto.getTypeLocale38Detail() != null)
        typeLocale38DetailConverter.copy(dto.getTypeLocale38Detail(), t.getTypeLocale38Detail());
    if (dto.getCategorieLocale() != null)
        categorieLocaleConverter.copy(dto.getCategorieLocale(), t.getCategorieLocale());
    }



    public void initObject(boolean value) {
        this.typeLocale38Detail = value;
        this.categorieLocale = value;
    }


    public TypeLocale38DetailConverter getTypeLocale38DetailConverter(){
        return this.typeLocale38DetailConverter;
    }
    public void setTypeLocale38DetailConverter(TypeLocale38DetailConverter typeLocale38DetailConverter ){
        this.typeLocale38DetailConverter = typeLocale38DetailConverter;
    }
    public CategorieLocaleConverter getCategorieLocaleConverter(){
        return this.categorieLocaleConverter;
    }
    public void setCategorieLocaleConverter(CategorieLocaleConverter categorieLocaleConverter ){
        this.categorieLocaleConverter = categorieLocaleConverter;
    }
    public boolean  isTypeLocale38Detail(){
        return this.typeLocale38Detail;
    }
    public void  setTypeLocale38Detail(boolean typeLocale38Detail){
        this.typeLocale38Detail = typeLocale38Detail;
    }
    public boolean  isCategorieLocale(){
        return this.categorieLocale;
    }
    public void  setCategorieLocale(boolean categorieLocale){
        this.categorieLocale = categorieLocale;
    }
}
