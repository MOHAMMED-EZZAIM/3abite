package ma.zs.univ.service.facade.admin.taxe38;

import java.util.List;
import ma.zs.univ.bean.core.taxe38.Taxe38Detail;
import ma.zs.univ.dao.criteria.core.taxe38.Taxe38DetailCriteria;
import ma.zs.univ.zynerator.service.IService;



public interface Taxe38DetailAdminService extends  IService<Taxe38Detail,Taxe38DetailCriteria>  {

    List<Taxe38Detail> findByLocale38DetailId(Long id);
    int deleteByLocale38DetailId(Long id);
    long countByLocale38DetailCode(String code);
    List<Taxe38Detail> findByTauxTaxe38Id(Long id);
    int deleteByTauxTaxe38Id(Long id);
    long countByTauxTaxe38Code(String code);
    List<Taxe38Detail> findByTaxe38Id(Long id);
    int deleteByTaxe38Id(Long id);
    long countByTaxe38Code(String code);




}
