package ma.zs.univ.service.facade.admin.commun;

import java.util.List;
import ma.zs.univ.bean.core.commun.Rue;
import ma.zs.univ.dao.criteria.core.commun.RueCriteria;
import ma.zs.univ.zynerator.service.IService;



public interface RueAdminService extends  IService<Rue,RueCriteria>  {

    List<Rue> findByQuartierId(Long id);
    int deleteByQuartierId(Long id);
    long countByQuartierCode(String code);




}
