package ma.zs.univ.service.facade.admin.taxe38;

import java.util.List;
import ma.zs.univ.bean.core.taxe38.Taxe38;
import ma.zs.univ.dao.criteria.core.taxe38.Taxe38Criteria;
import ma.zs.univ.zynerator.service.IService;



public interface Taxe38AdminService extends  IService<Taxe38,Taxe38Criteria>  {

    List<Taxe38> findByRedevableId(Long id);
    int deleteByRedevableId(Long id);
    long countByRedevableId(Long id);
    List<Taxe38> findByLocaleId(Long id);
    int deleteByLocaleId(Long id);
    long countByLocaleCode(String code);
    List<Taxe38> findByTrimId(Long id);
    int deleteByTrimId(Long id);
    long countByTrimId(Long id);




}
