package ma.zs.univ.service.facade.admin.commun;

import java.util.List;
import ma.zs.univ.bean.core.commun.Secteur;
import ma.zs.univ.dao.criteria.core.commun.SecteurCriteria;
import ma.zs.univ.zynerator.service.IService;



public interface SecteurAdminService extends  IService<Secteur,SecteurCriteria>  {

    List<Secteur> findByVilleId(Long id);
    int deleteByVilleId(Long id);
    long countByVilleCode(String code);




}
