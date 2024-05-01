package ma.zs.univ.service.impl.admin.taxe38;


import ma.zs.univ.bean.core.taxe38.TauxTaxe38;
import ma.zs.univ.dao.criteria.core.taxe38.TauxTaxe38Criteria;
import ma.zs.univ.dao.facade.core.taxe38.TauxTaxe38Dao;
import ma.zs.univ.dao.specification.core.taxe38.TauxTaxe38Specification;
import ma.zs.univ.service.facade.admin.taxe38.TauxTaxe38AdminService;
import ma.zs.univ.zynerator.service.AbstractServiceImpl;
import ma.zs.univ.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.univ.service.facade.admin.taxe38.TypeLocale38DetailAdminService ;
import ma.zs.univ.bean.core.taxe38.TypeLocale38Detail ;
import ma.zs.univ.service.facade.admin.taxe38.CategorieLocaleAdminService ;
import ma.zs.univ.bean.core.taxe38.CategorieLocale ;

import java.util.List;
@Service
public class TauxTaxe38AdminServiceImpl extends AbstractServiceImpl<TauxTaxe38, TauxTaxe38Criteria, TauxTaxe38Dao> implements TauxTaxe38AdminService {






    public TauxTaxe38 findByReferenceEntity(TauxTaxe38 t){
        return t==null? null : dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(TauxTaxe38 t){
        if( t != null) {
            t.setTypeLocale38Detail(typeLocale38DetailService.findOrSave(t.getTypeLocale38Detail()));
            t.setCategorieLocale(categorieLocaleService.findOrSave(t.getCategorieLocale()));
        }
    }

    public List<TauxTaxe38> findByTypeLocale38DetailId(Long id){
        return dao.findByTypeLocale38DetailId(id);
    }
    public int deleteByTypeLocale38DetailId(Long id){
        return dao.deleteByTypeLocale38DetailId(id);
    }
    public long countByTypeLocale38DetailCode(String code){
        return dao.countByTypeLocale38DetailCode(code);
    }
    public List<TauxTaxe38> findByCategorieLocaleId(Long id){
        return dao.findByCategorieLocaleId(id);
    }
    public int deleteByCategorieLocaleId(Long id){
        return dao.deleteByCategorieLocaleId(id);
    }
    public long countByCategorieLocaleCode(String code){
        return dao.countByCategorieLocaleCode(code);
    }

    public List<TauxTaxe38> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(TauxTaxe38.class, TauxTaxe38Specification.class);
    }


    @Autowired
    private TypeLocale38DetailAdminService typeLocale38DetailService ;
    @Autowired
    private CategorieLocaleAdminService categorieLocaleService ;

    public TauxTaxe38AdminServiceImpl(TauxTaxe38Dao dao) {
        super(dao);
    }

}
