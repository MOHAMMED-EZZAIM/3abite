package ma.zs.univ.service.impl.admin.NotificationRetardTroisiemeNiv;


import ma.zs.univ.bean.core.NotificationRetardTroisiemeNiv.NotificationRetardTroisiemeNiveau;
import ma.zs.univ.dao.criteria.core.NotificationRetardTroisiemeNiv.NotificationRetardTroisiemeNiveauCriteria;
import ma.zs.univ.dao.facade.core.NotificationRetardTroisiemeNiv.NotificationRetardTroisiemeNiveauDao;
import ma.zs.univ.dao.specification.core.NotificationRetardTroisiemeNiv.NotificationRetardTroisiemeNiveauSpecification;
import ma.zs.univ.service.facade.admin.NotificationRetardTroisiemeNiv.NotificationRetardTroisiemeNiveauAdminService;
import ma.zs.univ.zynerator.service.AbstractServiceImpl;
import ma.zs.univ.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.univ.service.facade.admin.commun.LocaleAdminService ;
import ma.zs.univ.bean.core.commun.Locale ;
import ma.zs.univ.service.facade.admin.taxe38.TrimAdminService ;
import ma.zs.univ.bean.core.taxe38.Trim ;
import ma.zs.univ.service.facade.admin.commun.RedevableAdminService ;
import ma.zs.univ.bean.core.commun.Redevable ;

import java.util.List;
@Service
public class NotificationRetardTroisiemeNiveauAdminServiceImpl extends AbstractServiceImpl<NotificationRetardTroisiemeNiveau, NotificationRetardTroisiemeNiveauCriteria, NotificationRetardTroisiemeNiveauDao> implements NotificationRetardTroisiemeNiveauAdminService {






    public NotificationRetardTroisiemeNiveau findByReferenceEntity(NotificationRetardTroisiemeNiveau t){
        return t==null? null : dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(NotificationRetardTroisiemeNiveau t){
        if( t != null) {
            t.setLocale(localeService.findOrSave(t.getLocale()));
            t.setRedevable(redevableService.findOrSave(t.getRedevable()));
            t.setTrim(trimService.findOrSave(t.getTrim()));
        }
    }

    public List<NotificationRetardTroisiemeNiveau> findByLocaleId(Long id){
        return dao.findByLocaleId(id);
    }
    public int deleteByLocaleId(Long id){
        return dao.deleteByLocaleId(id);
    }
    public long countByLocaleCode(String code){
        return dao.countByLocaleCode(code);
    }
    public List<NotificationRetardTroisiemeNiveau> findByRedevableId(Long id){
        return dao.findByRedevableId(id);
    }
    public int deleteByRedevableId(Long id){
        return dao.deleteByRedevableId(id);
    }
    public long countByRedevableId(Long id){
        return dao.countByRedevableId(id);
    }
    public List<NotificationRetardTroisiemeNiveau> findByTrimId(Long id){
        return dao.findByTrimId(id);
    }
    public int deleteByTrimId(Long id){
        return dao.deleteByTrimId(id);
    }
    public long countByTrimId(Long id){
        return dao.countByTrimId(id);
    }

    public List<NotificationRetardTroisiemeNiveau> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(NotificationRetardTroisiemeNiveau.class, NotificationRetardTroisiemeNiveauSpecification.class);
    }


    @Autowired
    private LocaleAdminService localeService ;
    @Autowired
    private TrimAdminService trimService ;
    @Autowired
    private RedevableAdminService redevableService ;

    public NotificationRetardTroisiemeNiveauAdminServiceImpl(NotificationRetardTroisiemeNiveauDao dao) {
        super(dao);
    }

}
