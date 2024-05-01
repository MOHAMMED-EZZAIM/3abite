package ma.zs.univ.service.facade.admin.NotificationRetardTroisiemeNiv;

import java.util.List;
import ma.zs.univ.bean.core.NotificationRetardTroisiemeNiv.NotificationRetardTroisiemeNiveau;
import ma.zs.univ.dao.criteria.core.NotificationRetardTroisiemeNiv.NotificationRetardTroisiemeNiveauCriteria;
import ma.zs.univ.zynerator.service.IService;



public interface NotificationRetardTroisiemeNiveauAdminService extends  IService<NotificationRetardTroisiemeNiveau,NotificationRetardTroisiemeNiveauCriteria>  {

    List<NotificationRetardTroisiemeNiveau> findByLocaleId(Long id);
    int deleteByLocaleId(Long id);
    long countByLocaleCode(String code);
    List<NotificationRetardTroisiemeNiveau> findByRedevableId(Long id);
    int deleteByRedevableId(Long id);
    long countByRedevableId(Long id);
    List<NotificationRetardTroisiemeNiveau> findByTrimId(Long id);
    int deleteByTrimId(Long id);
    long countByTrimId(Long id);




}
