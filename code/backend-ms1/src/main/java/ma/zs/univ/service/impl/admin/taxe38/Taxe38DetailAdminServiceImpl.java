package ma.zs.univ.service.impl.admin.taxe38;


import ma.zs.univ.bean.core.taxe38.Taxe38Detail;
import ma.zs.univ.dao.criteria.core.taxe38.Taxe38DetailCriteria;
import ma.zs.univ.dao.facade.core.taxe38.Taxe38DetailDao;
import ma.zs.univ.dao.specification.core.taxe38.Taxe38DetailSpecification;
import ma.zs.univ.service.facade.admin.taxe38.Taxe38DetailAdminService;
import ma.zs.univ.zynerator.service.AbstractServiceImpl;
import ma.zs.univ.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.univ.service.facade.admin.taxe38.Taxe38AdminService ;
import ma.zs.univ.bean.core.taxe38.Taxe38 ;
import ma.zs.univ.service.facade.admin.taxe38.Locale38DetailAdminService ;
import ma.zs.univ.bean.core.taxe38.Locale38Detail ;
import ma.zs.univ.service.facade.admin.taxe38.TauxTaxe38AdminService ;
import ma.zs.univ.bean.core.taxe38.TauxTaxe38 ;

import java.util.List;
@Service
public class Taxe38DetailAdminServiceImpl extends AbstractServiceImpl<Taxe38Detail, Taxe38DetailCriteria, Taxe38DetailDao> implements Taxe38DetailAdminService {






    public Taxe38Detail findByReferenceEntity(Taxe38Detail t){
        return t==null? null : dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(Taxe38Detail t){
        if( t != null) {
            t.setLocale38Detail(locale38DetailService.findOrSave(t.getLocale38Detail()));
            t.setTauxTaxe38(tauxTaxe38Service.findOrSave(t.getTauxTaxe38()));
            t.setTaxe38(taxe38Service.findOrSave(t.getTaxe38()));
        }
    }

    public List<Taxe38Detail> findByLocale38DetailId(Long id){
        return dao.findByLocale38DetailId(id);
    }
    public int deleteByLocale38DetailId(Long id){
        return dao.deleteByLocale38DetailId(id);
    }
    public long countByLocale38DetailCode(String code){
        return dao.countByLocale38DetailCode(code);
    }
    public List<Taxe38Detail> findByTauxTaxe38Id(Long id){
        return dao.findByTauxTaxe38Id(id);
    }
    public int deleteByTauxTaxe38Id(Long id){
        return dao.deleteByTauxTaxe38Id(id);
    }
    public long countByTauxTaxe38Code(String code){
        return dao.countByTauxTaxe38Code(code);
    }
    public List<Taxe38Detail> findByTaxe38Id(Long id){
        return dao.findByTaxe38Id(id);
    }
    public int deleteByTaxe38Id(Long id){
        return dao.deleteByTaxe38Id(id);
    }
    public long countByTaxe38Code(String code){
        return dao.countByTaxe38Code(code);
    }

    public List<Taxe38Detail> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Taxe38Detail.class, Taxe38DetailSpecification.class);
    }


    @Autowired
    private Taxe38AdminService taxe38Service ;
    @Autowired
    private Locale38DetailAdminService locale38DetailService ;
    @Autowired
    private TauxTaxe38AdminService tauxTaxe38Service ;

    public Taxe38DetailAdminServiceImpl(Taxe38DetailDao dao) {
        super(dao);
    }

}
