package ma.zs.univ.service.impl.admin.NotificationRetardDeuxiemeNiv;


import ma.zs.univ.bean.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetail;
import ma.zs.univ.dao.criteria.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailCriteria;
import ma.zs.univ.dao.facade.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailDao;
import ma.zs.univ.dao.specification.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailSpecification;
import ma.zs.univ.service.facade.admin.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailAdminService;
import ma.zs.univ.zynerator.service.AbstractServiceImpl;
import ma.zs.univ.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.univ.service.facade.admin.taxe38.TrimAdminService ;
import ma.zs.univ.bean.core.taxe38.Trim ;

import java.util.List;
@Service
public class NotificationRetardDeuxiemeNiveauDetailAdminServiceImpl extends AbstractServiceImpl<NotificationRetardDeuxiemeNiveauDetail, NotificationRetardDeuxiemeNiveauDetailCriteria, NotificationRetardDeuxiemeNiveauDetailDao> implements NotificationRetardDeuxiemeNiveauDetailAdminService {






    public NotificationRetardDeuxiemeNiveauDetail findByReferenceEntity(NotificationRetardDeuxiemeNiveauDetail t){
        return t==null? null : dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(NotificationRetardDeuxiemeNiveauDetail t){
        if( t != null) {
            t.setTrim(trimService.findOrSave(t.getTrim()));
        }
    }

    public List<NotificationRetardDeuxiemeNiveauDetail> findByTrimId(Long id){
        return dao.findByTrimId(id);
    }
    public int deleteByTrimId(Long id){
        return dao.deleteByTrimId(id);
    }
    public long countByTrimId(Long id){
        return dao.countByTrimId(id);
    }

    public List<NotificationRetardDeuxiemeNiveauDetail> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(NotificationRetardDeuxiemeNiveauDetail.class, NotificationRetardDeuxiemeNiveauDetailSpecification.class);
    }


    @Autowired
    private TrimAdminService trimService ;

    public NotificationRetardDeuxiemeNiveauDetailAdminServiceImpl(NotificationRetardDeuxiemeNiveauDetailDao dao) {
        super(dao);
    }

}
