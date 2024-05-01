package ma.zs.univ.service.facade.admin.NotificationPremierNiv;

import java.util.List;
import ma.zs.univ.bean.core.NotificationPremierNiv.NotificationRetardPremierNiveau;
import ma.zs.univ.dao.criteria.core.NotificationPremierNiv.NotificationRetardPremierNiveauCriteria;
import ma.zs.univ.zynerator.service.IService;



public interface NotificationRetardPremierNiveauAdminService extends  IService<NotificationRetardPremierNiveau,NotificationRetardPremierNiveauCriteria>  {

    List<NotificationRetardPremierNiveau> findByLocaleId(Long id);
    int deleteByLocaleId(Long id);
    long countByLocaleCode(String code);
    List<NotificationRetardPremierNiveau> findByRedevableId(Long id);
    int deleteByRedevableId(Long id);
    long countByRedevableId(Long id);




}
