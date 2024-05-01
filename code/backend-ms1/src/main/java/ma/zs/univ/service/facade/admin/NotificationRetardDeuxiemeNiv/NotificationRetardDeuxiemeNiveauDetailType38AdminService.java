package ma.zs.univ.service.facade.admin.NotificationRetardDeuxiemeNiv;

import java.util.List;
import ma.zs.univ.bean.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailType38;
import ma.zs.univ.dao.criteria.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailType38Criteria;
import ma.zs.univ.zynerator.service.IService;



public interface NotificationRetardDeuxiemeNiveauDetailType38AdminService extends  IService<NotificationRetardDeuxiemeNiveauDetailType38,NotificationRetardDeuxiemeNiveauDetailType38Criteria>  {

    List<NotificationRetardDeuxiemeNiveauDetailType38> findByTypeLocale38Id(Long id);
    int deleteByTypeLocale38Id(Long id);
    long countByTypeLocale38Code(String code);




}
