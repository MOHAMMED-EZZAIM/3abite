package ma.zs.univ.service.facade.admin.NotificationRetardDeuxiemeNiv;

import java.util.List;
import ma.zs.univ.bean.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveau;
import ma.zs.univ.dao.criteria.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauCriteria;
import ma.zs.univ.zynerator.service.IService;



public interface NotificationRetardDeuxiemeNiveauAdminService extends  IService<NotificationRetardDeuxiemeNiveau,NotificationRetardDeuxiemeNiveauCriteria>  {

    List<NotificationRetardDeuxiemeNiveau> findByLocaleId(Long id);
    int deleteByLocaleId(Long id);
    long countByLocaleCode(String code);
    List<NotificationRetardDeuxiemeNiveau> findByRedevableId(Long id);
    int deleteByRedevableId(Long id);
    long countByRedevableId(Long id);




}
