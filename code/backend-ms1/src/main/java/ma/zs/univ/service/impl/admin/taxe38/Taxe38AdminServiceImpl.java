package ma.zs.univ.service.impl.admin.taxe38;


import ma.zs.univ.bean.core.taxe38.Taxe38;
import ma.zs.univ.dao.criteria.core.taxe38.Taxe38Criteria;
import ma.zs.univ.dao.facade.core.taxe38.Taxe38Dao;
import ma.zs.univ.dao.specification.core.taxe38.Taxe38Specification;
import ma.zs.univ.service.facade.admin.taxe38.Taxe38AdminService;
import ma.zs.univ.zynerator.service.AbstractServiceImpl;
import ma.zs.univ.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.univ.service.facade.admin.commun.LocaleAdminService ;
import ma.zs.univ.bean.core.commun.Locale ;
import ma.zs.univ.service.facade.admin.taxe38.TrimAdminService ;
import ma.zs.univ.bean.core.taxe38.Trim ;
import ma.zs.univ.service.facade.admin.taxe38.Taxe38DetailAdminService ;
import ma.zs.univ.bean.core.taxe38.Taxe38Detail ;
import ma.zs.univ.service.facade.admin.commun.RedevableAdminService ;
import ma.zs.univ.bean.core.commun.Redevable ;

import java.util.List;
@Service
public class Taxe38AdminServiceImpl extends AbstractServiceImpl<Taxe38, Taxe38Criteria, Taxe38Dao> implements Taxe38AdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Taxe38 create(Taxe38 t) {
        Taxe38 saved= super.create(t);
        if (saved != null && t.getTaxe38Details() != null) {
                t.getTaxe38Details().forEach(element-> {
                element.setTaxe38(saved);
                taxe38DetailService.create(element);
            });
        }
        return saved;

    }

    public Taxe38 findWithAssociatedLists(Long id){
        Taxe38 result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setTaxe38Details(taxe38DetailService.findByTaxe38Id(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        taxe38DetailService.deleteByTaxe38Id(id);
    }


    public void updateWithAssociatedLists(Taxe38 taxe38){
    if(taxe38 !=null && taxe38.getId() != null){
            List<List<Taxe38Detail>> resultTaxe38Details= taxe38DetailService.getToBeSavedAndToBeDeleted(taxe38DetailService.findByTaxe38Id(taxe38.getId()),taxe38.getTaxe38Details());
            taxe38DetailService.delete(resultTaxe38Details.get(1));
            ListUtil.emptyIfNull(resultTaxe38Details.get(0)).forEach(e -> e.setTaxe38(taxe38));
            taxe38DetailService.update(resultTaxe38Details.get(0),true);
        }
    }




    public Taxe38 findByReferenceEntity(Taxe38 t){
        return t==null? null : dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(Taxe38 t){
        if( t != null) {
            t.setRedevable(redevableService.findOrSave(t.getRedevable()));
            t.setLocale(localeService.findOrSave(t.getLocale()));
            t.setTrim(trimService.findOrSave(t.getTrim()));
        }
    }

    public List<Taxe38> findByRedevableId(Long id){
        return dao.findByRedevableId(id);
    }
    public int deleteByRedevableId(Long id){
        return dao.deleteByRedevableId(id);
    }
    public long countByRedevableId(Long id){
        return dao.countByRedevableId(id);
    }
    public List<Taxe38> findByLocaleId(Long id){
        return dao.findByLocaleId(id);
    }
    public int deleteByLocaleId(Long id){
        return dao.deleteByLocaleId(id);
    }
    public long countByLocaleCode(String code){
        return dao.countByLocaleCode(code);
    }
    public List<Taxe38> findByTrimId(Long id){
        return dao.findByTrimId(id);
    }
    public int deleteByTrimId(Long id){
        return dao.deleteByTrimId(id);
    }
    public long countByTrimId(Long id){
        return dao.countByTrimId(id);
    }

    public List<Taxe38> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Taxe38.class, Taxe38Specification.class);
    }


    @Autowired
    private LocaleAdminService localeService ;
    @Autowired
    private TrimAdminService trimService ;
    @Autowired
    private Taxe38DetailAdminService taxe38DetailService ;
    @Autowired
    private RedevableAdminService redevableService ;

    public Taxe38AdminServiceImpl(Taxe38Dao dao) {
        super(dao);
    }

}
