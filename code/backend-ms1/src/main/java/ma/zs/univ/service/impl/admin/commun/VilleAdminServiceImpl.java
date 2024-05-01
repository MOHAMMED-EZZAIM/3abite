package ma.zs.univ.service.impl.admin.commun;


import ma.zs.univ.bean.core.commun.Ville;
import ma.zs.univ.dao.criteria.core.commun.VilleCriteria;
import ma.zs.univ.dao.facade.core.commun.VilleDao;
import ma.zs.univ.dao.specification.core.commun.VilleSpecification;
import ma.zs.univ.service.facade.admin.commun.VilleAdminService;
import ma.zs.univ.zynerator.service.AbstractServiceImpl;
import ma.zs.univ.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class VilleAdminServiceImpl extends AbstractServiceImpl<Ville, VilleCriteria, VilleDao> implements VilleAdminService {






    public Ville findByReferenceEntity(Ville t){
        return t==null? null : dao.findByCode(t.getCode());
    }


    public List<Ville> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Ville.class, VilleSpecification.class);
    }



    public VilleAdminServiceImpl(VilleDao dao) {
        super(dao);
    }

}
