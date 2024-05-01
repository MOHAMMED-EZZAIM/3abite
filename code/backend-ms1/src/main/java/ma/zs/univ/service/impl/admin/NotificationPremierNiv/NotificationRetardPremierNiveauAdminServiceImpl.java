package ma.zs.univ.service.impl.admin.NotificationPremierNiv;


import ma.zs.univ.bean.core.NotificationPremierNiv.NotificationRetardPremierNiveau;
import ma.zs.univ.dao.criteria.core.NotificationPremierNiv.NotificationRetardPremierNiveauCriteria;
import ma.zs.univ.dao.facade.core.NotificationPremierNiv.NotificationRetardPremierNiveauDao;
import ma.zs.univ.dao.specification.core.NotificationPremierNiv.NotificationRetardPremierNiveauSpecification;
import ma.zs.univ.service.facade.admin.NotificationPremierNiv.NotificationRetardPremierNiveauAdminService;
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
public class NotificationRetardPremierNiveauAdminServiceImpl extends AbstractServiceImpl<NotificationRetardPremierNiveau, NotificationRetardPremierNiveauCriteria, NotificationRetardPremierNiveauDao> implements NotificationRetardPremierNiveauAdminService {






    public NotificationRetardPremierNiveau findByReferenceEntity(NotificationRetardPremierNiveau t){
        return t==null? null : dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(NotificationRetardPremierNiveau t){
        if( t != null) {
            t.setLocale(localeService.findOrSave(t.getLocale()));
            t.setRedevable(redevableService.findOrSave(t.getRedevable()));
        }
    }

    public List<NotificationRetardPremierNiveau> findByLocaleId(Long id){
        return dao.findByLocaleId(id);
    }
    public int deleteByLocaleId(Long id){
        return dao.deleteByLocaleId(id);
    }
    public long countByLocaleCode(String code){
        return dao.countByLocaleCode(code);
    }
    public List<NotificationRetardPremierNiveau> findByRedevableId(Long id){
        return dao.findByRedevableId(id);
    }
    public int deleteByRedevableId(Long id){
        return dao.deleteByRedevableId(id);
    }
    public long countByRedevableId(Long id){
        return dao.countByRedevableId(id);
    }

    public List<NotificationRetardPremierNiveau> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(NotificationRetardPremierNiveau.class, NotificationRetardPremierNiveauSpecification.class);
    }


    @Autowired
    private LocaleAdminService localeService ;
    @Autowired
    private RedevableAdminService redevableService ;

    public NotificationRetardPremierNiveauAdminServiceImpl(NotificationRetardPremierNiveauDao dao) {
        super(dao);
    }

}
