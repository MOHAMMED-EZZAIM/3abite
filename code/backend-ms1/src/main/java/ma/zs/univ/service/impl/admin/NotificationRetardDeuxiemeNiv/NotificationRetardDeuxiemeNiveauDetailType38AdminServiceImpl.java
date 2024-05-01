package ma.zs.univ.service.impl.admin.NotificationRetardDeuxiemeNiv;


import ma.zs.univ.bean.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailType38;
import ma.zs.univ.dao.criteria.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailType38Criteria;
import ma.zs.univ.dao.facade.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailType38Dao;
import ma.zs.univ.dao.specification.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailType38Specification;
import ma.zs.univ.service.facade.admin.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDetailType38AdminService;
import ma.zs.univ.zynerator.service.AbstractServiceImpl;
import ma.zs.univ.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.univ.service.facade.admin.taxe38.TypeLocale38DetailAdminService ;
import ma.zs.univ.bean.core.taxe38.TypeLocale38Detail ;

import java.util.List;
@Service
public class NotificationRetardDeuxiemeNiveauDetailType38AdminServiceImpl extends AbstractServiceImpl<NotificationRetardDeuxiemeNiveauDetailType38, NotificationRetardDeuxiemeNiveauDetailType38Criteria, NotificationRetardDeuxiemeNiveauDetailType38Dao> implements NotificationRetardDeuxiemeNiveauDetailType38AdminService {






    public NotificationRetardDeuxiemeNiveauDetailType38 findByReferenceEntity(NotificationRetardDeuxiemeNiveauDetailType38 t){
        return t==null? null : dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(NotificationRetardDeuxiemeNiveauDetailType38 t){
        if( t != null) {
            t.setTypeLocale38(typeLocale38DetailService.findOrSave(t.getTypeLocale38()));
        }
    }

    public List<NotificationRetardDeuxiemeNiveauDetailType38> findByTypeLocale38Id(Long id){
        return dao.findByTypeLocale38Id(id);
    }
    public int deleteByTypeLocale38Id(Long id){
        return dao.deleteByTypeLocale38Id(id);
    }
    public long countByTypeLocale38Code(String code){
        return dao.countByTypeLocale38Code(code);
    }

    public List<NotificationRetardDeuxiemeNiveauDetailType38> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(NotificationRetardDeuxiemeNiveauDetailType38.class, NotificationRetardDeuxiemeNiveauDetailType38Specification.class);
    }


    @Autowired
    private TypeLocale38DetailAdminService typeLocale38DetailService ;

    public NotificationRetardDeuxiemeNiveauDetailType38AdminServiceImpl(NotificationRetardDeuxiemeNiveauDetailType38Dao dao) {
        super(dao);
    }

}
