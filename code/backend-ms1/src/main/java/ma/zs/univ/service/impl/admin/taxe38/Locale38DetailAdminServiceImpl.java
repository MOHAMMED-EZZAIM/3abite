package ma.zs.univ.service.impl.admin.taxe38;


import ma.zs.univ.bean.core.taxe38.Locale38Detail;
import ma.zs.univ.dao.criteria.core.taxe38.Locale38DetailCriteria;
import ma.zs.univ.dao.facade.core.taxe38.Locale38DetailDao;
import ma.zs.univ.dao.specification.core.taxe38.Locale38DetailSpecification;
import ma.zs.univ.service.facade.admin.taxe38.Locale38DetailAdminService;
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
public class Locale38DetailAdminServiceImpl extends AbstractServiceImpl<Locale38Detail, Locale38DetailCriteria, Locale38DetailDao> implements Locale38DetailAdminService {






    public Locale38Detail findByReferenceEntity(Locale38Detail t){
        return t==null? null : dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(Locale38Detail t){
        if( t != null) {
            t.setTypeLocale38Detail(typeLocale38DetailService.findOrSave(t.getTypeLocale38Detail()));
        }
    }

    public List<Locale38Detail> findByTypeLocale38DetailId(Long id){
        return dao.findByTypeLocale38DetailId(id);
    }
    public int deleteByTypeLocale38DetailId(Long id){
        return dao.deleteByTypeLocale38DetailId(id);
    }
    public long countByTypeLocale38DetailCode(String code){
        return dao.countByTypeLocale38DetailCode(code);
    }

    public List<Locale38Detail> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Locale38Detail.class, Locale38DetailSpecification.class);
    }


    @Autowired
    private TypeLocale38DetailAdminService typeLocale38DetailService ;

    public Locale38DetailAdminServiceImpl(Locale38DetailDao dao) {
        super(dao);
    }

}
