package ma.zs.univ.service.facade.admin.taxe38;

import java.util.List;
import ma.zs.univ.bean.core.taxe38.TauxTaxe38;
import ma.zs.univ.dao.criteria.core.taxe38.TauxTaxe38Criteria;
import ma.zs.univ.zynerator.service.IService;



public interface TauxTaxe38AdminService extends  IService<TauxTaxe38,TauxTaxe38Criteria>  {

    List<TauxTaxe38> findByTypeLocale38DetailId(Long id);
    int deleteByTypeLocale38DetailId(Long id);
    long countByTypeLocale38DetailCode(String code);
    List<TauxTaxe38> findByCategorieLocaleId(Long id);
    int deleteByCategorieLocaleId(Long id);
    long countByCategorieLocaleCode(String code);




}
