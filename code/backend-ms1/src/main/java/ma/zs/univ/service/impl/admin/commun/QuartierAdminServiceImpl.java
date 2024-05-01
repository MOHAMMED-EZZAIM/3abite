package ma.zs.univ.service.impl.admin.commun;


import ma.zs.univ.bean.core.commun.Quartier;
import ma.zs.univ.dao.criteria.core.commun.QuartierCriteria;
import ma.zs.univ.dao.facade.core.commun.QuartierDao;
import ma.zs.univ.dao.specification.core.commun.QuartierSpecification;
import ma.zs.univ.service.facade.admin.commun.QuartierAdminService;
import ma.zs.univ.zynerator.service.AbstractServiceImpl;
import ma.zs.univ.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.univ.service.facade.admin.commun.SecteurAdminService ;
import ma.zs.univ.bean.core.commun.Secteur ;

import java.util.List;
@Service
public class QuartierAdminServiceImpl extends AbstractServiceImpl<Quartier, QuartierCriteria, QuartierDao> implements QuartierAdminService {






    public Quartier findByReferenceEntity(Quartier t){
        return t==null? null : dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(Quartier t){
        if( t != null) {
            t.setSecteur(secteurService.findOrSave(t.getSecteur()));
        }
    }

    public List<Quartier> findBySecteurId(Long id){
        return dao.findBySecteurId(id);
    }
    public int deleteBySecteurId(Long id){
        return dao.deleteBySecteurId(id);
    }
    public long countBySecteurCode(String code){
        return dao.countBySecteurCode(code);
    }

    public List<Quartier> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Quartier.class, QuartierSpecification.class);
    }


    @Autowired
    private SecteurAdminService secteurService ;

    public QuartierAdminServiceImpl(QuartierDao dao) {
        super(dao);
    }

}
