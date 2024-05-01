package ma.zs.univ.service.impl.admin.commun;


import ma.zs.univ.bean.core.commun.Rue;
import ma.zs.univ.dao.criteria.core.commun.RueCriteria;
import ma.zs.univ.dao.facade.core.commun.RueDao;
import ma.zs.univ.dao.specification.core.commun.RueSpecification;
import ma.zs.univ.service.facade.admin.commun.RueAdminService;
import ma.zs.univ.zynerator.service.AbstractServiceImpl;
import ma.zs.univ.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.univ.service.facade.admin.commun.QuartierAdminService ;
import ma.zs.univ.bean.core.commun.Quartier ;

import java.util.List;
@Service
public class RueAdminServiceImpl extends AbstractServiceImpl<Rue, RueCriteria, RueDao> implements RueAdminService {






    public Rue findByReferenceEntity(Rue t){
        return t==null? null : dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(Rue t){
        if( t != null) {
            t.setQuartier(quartierService.findOrSave(t.getQuartier()));
        }
    }

    public List<Rue> findByQuartierId(Long id){
        return dao.findByQuartierId(id);
    }
    public int deleteByQuartierId(Long id){
        return dao.deleteByQuartierId(id);
    }
    public long countByQuartierCode(String code){
        return dao.countByQuartierCode(code);
    }

    public List<Rue> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Rue.class, RueSpecification.class);
    }


    @Autowired
    private QuartierAdminService quartierService ;

    public RueAdminServiceImpl(RueDao dao) {
        super(dao);
    }

}
