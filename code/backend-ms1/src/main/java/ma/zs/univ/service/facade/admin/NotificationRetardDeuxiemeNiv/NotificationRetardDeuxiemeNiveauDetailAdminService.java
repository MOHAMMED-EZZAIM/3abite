package ma.zs.univ.service.facade.admin.NotificationRetardDeuxiemeNiv;

import java.util.List;
import ma.zs.univ.bean.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetail;
import ma.zs.univ.dao.criteria.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailCriteria;
import ma.zs.univ.zynerator.service.IService;



public interface NotificationRetardDeuxiemeNiveauDetailAdminService extends  IService<NotificationRetardDeuxiemeNiveauDetail,NotificationRetardDeuxiemeNiveauDetailCriteria>  {

    List<NotificationRetardDeuxiemeNiveauDetail> findByTrimId(Long id);
    int deleteByTrimId(Long id);
    long countByTrimId(Long id);




}
