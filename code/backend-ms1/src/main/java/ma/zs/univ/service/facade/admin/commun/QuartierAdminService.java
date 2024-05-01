package ma.zs.univ.service.facade.admin.commun;

import java.util.List;
import ma.zs.univ.bean.core.commun.Quartier;
import ma.zs.univ.dao.criteria.core.commun.QuartierCriteria;
import ma.zs.univ.zynerator.service.IService;



public interface QuartierAdminService extends  IService<Quartier,QuartierCriteria>  {

    List<Quartier> findBySecteurId(Long id);
    int deleteBySecteurId(Long id);
    long countBySecteurCode(String code);




}
