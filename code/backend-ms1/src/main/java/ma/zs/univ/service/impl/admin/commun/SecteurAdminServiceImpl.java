package ma.zs.univ.service.impl.admin.commun;


import ma.zs.univ.bean.core.commun.Secteur;
import ma.zs.univ.dao.criteria.core.commun.SecteurCriteria;
import ma.zs.univ.dao.facade.core.commun.SecteurDao;
import ma.zs.univ.dao.specification.core.commun.SecteurSpecification;
import ma.zs.univ.service.facade.admin.commun.SecteurAdminService;
import ma.zs.univ.zynerator.service.AbstractServiceImpl;
import ma.zs.univ.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.univ.service.facade.admin.commun.VilleAdminService ;
import ma.zs.univ.bean.core.commun.Ville ;

import java.util.List;
@Service
public class SecteurAdminServiceImpl extends AbstractServiceImpl<Secteur, SecteurCriteria, SecteurDao> implements SecteurAdminService {






    public Secteur findByReferenceEntity(Secteur t){
        return t==null? null : dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(Secteur t){
        if( t != null) {
            t.setVille(villeService.findOrSave(t.getVille()));
        }
    }

    public List<Secteur> findByVilleId(Long id){
        return dao.findByVilleId(id);
    }
    public int deleteByVilleId(Long id){
        return dao.deleteByVilleId(id);
    }
    public long countByVilleCode(String code){
        return dao.countByVilleCode(code);
    }

    public List<Secteur> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Secteur.class, SecteurSpecification.class);
    }


    @Autowired
    private VilleAdminService villeService ;

    public SecteurAdminServiceImpl(SecteurDao dao) {
        super(dao);
    }

}
