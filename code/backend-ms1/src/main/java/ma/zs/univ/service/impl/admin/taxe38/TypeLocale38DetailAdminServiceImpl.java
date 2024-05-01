package ma.zs.univ.service.impl.admin.taxe38;


import ma.zs.univ.bean.core.taxe38.TypeLocale38Detail;
import ma.zs.univ.dao.criteria.core.taxe38.TypeLocale38DetailCriteria;
import ma.zs.univ.dao.facade.core.taxe38.TypeLocale38DetailDao;
import ma.zs.univ.dao.specification.core.taxe38.TypeLocale38DetailSpecification;
import ma.zs.univ.service.facade.admin.taxe38.TypeLocale38DetailAdminService;
import ma.zs.univ.zynerator.service.AbstractServiceImpl;
import ma.zs.univ.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class TypeLocale38DetailAdminServiceImpl extends AbstractServiceImpl<TypeLocale38Detail, TypeLocale38DetailCriteria, TypeLocale38DetailDao> implements TypeLocale38DetailAdminService {






    public TypeLocale38Detail findByReferenceEntity(TypeLocale38Detail t){
        return t==null? null : dao.findByCode(t.getCode());
    }


    public List<TypeLocale38Detail> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(TypeLocale38Detail.class, TypeLocale38DetailSpecification.class);
    }



    public TypeLocale38DetailAdminServiceImpl(TypeLocale38DetailDao dao) {
        super(dao);
    }

}
