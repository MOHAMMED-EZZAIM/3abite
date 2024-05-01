package ma.zs.univ.service.impl.admin.NotificationRetardDeuxiemeNiv;


import ma.zs.univ.bean.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveau;
import ma.zs.univ.dao.criteria.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauCriteria;
import ma.zs.univ.dao.facade.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauDao;
import ma.zs.univ.dao.specification.core.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauSpecification;
import ma.zs.univ.service.facade.admin.NotificationRetardDeuxiemeNiv.NotificationRetardDeuxiemeNiveauAdminService;
import ma.zs.univ.zynerator.service.AbstractServiceImpl;
import ma.zs.univ.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.univ.service.facade.admin.commun.LocaleAdminService ;
import ma.zs.univ.bean.core.commun.Locale ;
import ma.zs.univ.service.facade.admin.commun.RedevableAdminService ;
import ma.zs.univ.bean.core.commun.Redevable ;

import java.util.List;
@Service
public class NotificationRetardDeuxiemeNiveauAdminServiceImpl extends AbstractServiceImpl<NotificationRetardDeuxiemeNiveau, NotificationRetardDeuxiemeNiveauCriteria, NotificationRetardDeuxiemeNiveauDao> implements NotificationRetardDeuxiemeNiveauAdminService {






    public NotificationRetardDeuxiemeNiveau findByReferenceEntity(NotificationRetardDeuxiemeNiveau t){
        return t==null? null : dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(NotificationRetardDeuxiemeNiveau t){
        if( t != null) {
            t.setLocale(localeService.findOrSave(t.getLocale()));
            t.setRedevable(redevableService.findOrSave(t.getRedevable()));
        }
    }

    public List<NotificationRetardDeuxiemeNiveau> findByLocaleId(Long id){
        return dao.findByLocaleId(id);
    }
    public int deleteByLocaleId(Long id){
        return dao.deleteByLocaleId(id);
    }
    public long countByLocaleCode(String code){
        return dao.countByLocaleCode(code);
    }
    public List<NotificationRetardDeuxiemeNiveau> findByRedevableId(Long id){
        return dao.findByRedevableId(id);
    }
    public int deleteByRedevableId(Long id){
        return dao.deleteByRedevableId(id);
    }
    public long countByRedevableId(Long id){
        return dao.countByRedevableId(id);
    }

    public List<NotificationRetardDeuxiemeNiveau> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(NotificationRetardDeuxiemeNiveau.class, NotificationRetardDeuxiemeNiveauSpecification.class);
    }


    @Autowired
    private LocaleAdminService localeService ;
    @Autowired
    private RedevableAdminService redevableService ;

    public NotificationRetardDeuxiemeNiveauAdminServiceImpl(NotificationRetardDeuxiemeNiveauDao dao) {
        super(dao);
    }

}
