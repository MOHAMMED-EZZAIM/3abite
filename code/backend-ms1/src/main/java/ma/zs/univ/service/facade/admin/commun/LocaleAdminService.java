package ma.zs.univ.service.facade.admin.commun;

import java.util.List;
import ma.zs.univ.bean.core.commun.Locale;
import ma.zs.univ.dao.criteria.core.commun.LocaleCriteria;
import ma.zs.univ.zynerator.service.IService;



public interface LocaleAdminService extends  IService<Locale,LocaleCriteria>  {

    List<Locale> findByRueId(Long id);
    int deleteByRueId(Long id);
    long countByRueCode(String code);
    List<Locale> findByRedevableId(Long id);
    int deleteByRedevableId(Long id);
    long countByRedevableId(Long id);
    List<Locale> findByCategorieLocaleId(Long id);
    int deleteByCategorieLocaleId(Long id);
    long countByCategorieLocaleCode(String code);




}
