package ma.zs.univ.service.impl.admin.commun;


import ma.zs.univ.bean.core.commun.Locale;
import ma.zs.univ.dao.criteria.core.commun.LocaleCriteria;
import ma.zs.univ.dao.facade.core.commun.LocaleDao;
import ma.zs.univ.dao.specification.core.commun.LocaleSpecification;
import ma.zs.univ.service.facade.admin.commun.LocaleAdminService;
import ma.zs.univ.zynerator.service.AbstractServiceImpl;
import ma.zs.univ.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.univ.service.facade.admin.commun.RueAdminService ;
import ma.zs.univ.bean.core.commun.Rue ;
import ma.zs.univ.service.facade.admin.commun.RedevableAdminService ;
import ma.zs.univ.bean.core.commun.Redevable ;
import ma.zs.univ.service.facade.admin.taxe38.CategorieLocaleAdminService ;
import ma.zs.univ.bean.core.taxe38.CategorieLocale ;

import java.util.List;
@Service
public class LocaleAdminServiceImpl extends AbstractServiceImpl<Locale, LocaleCriteria, LocaleDao> implements LocaleAdminService {






    public Locale findByReferenceEntity(Locale t){
        return t==null? null : dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(Locale t){
        if( t != null) {
            t.setRue(rueService.findOrSave(t.getRue()));
            t.setRedevable(redevableService.findOrSave(t.getRedevable()));
            t.setCategorieLocale(categorieLocaleService.findOrSave(t.getCategorieLocale()));
        }
    }

    public List<Locale> findByRueId(Long id){
        return dao.findByRueId(id);
    }
    public int deleteByRueId(Long id){
        return dao.deleteByRueId(id);
    }
    public long countByRueCode(String code){
        return dao.countByRueCode(code);
    }
    public List<Locale> findByRedevableId(Long id){
        return dao.findByRedevableId(id);
    }
    public int deleteByRedevableId(Long id){
        return dao.deleteByRedevableId(id);
    }
    public long countByRedevableId(Long id){
        return dao.countByRedevableId(id);
    }
    public List<Locale> findByCategorieLocaleId(Long id){
        return dao.findByCategorieLocaleId(id);
    }
    public int deleteByCategorieLocaleId(Long id){
        return dao.deleteByCategorieLocaleId(id);
    }
    public long countByCategorieLocaleCode(String code){
        return dao.countByCategorieLocaleCode(code);
    }

    public List<Locale> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Locale.class, LocaleSpecification.class);
    }


    @Autowired
    private RueAdminService rueService ;
    @Autowired
    private RedevableAdminService redevableService ;
    @Autowired
    private CategorieLocaleAdminService categorieLocaleService ;

    public LocaleAdminServiceImpl(LocaleDao dao) {
        super(dao);
    }

}
