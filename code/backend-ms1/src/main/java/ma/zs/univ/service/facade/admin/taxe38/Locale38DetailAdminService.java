package ma.zs.univ.service.facade.admin.taxe38;

import java.util.List;
import ma.zs.univ.bean.core.taxe38.Locale38Detail;
import ma.zs.univ.dao.criteria.core.taxe38.Locale38DetailCriteria;
import ma.zs.univ.zynerator.service.IService;



public interface Locale38DetailAdminService extends  IService<Locale38Detail,Locale38DetailCriteria>  {

    List<Locale38Detail> findByTypeLocale38DetailId(Long id);
    int deleteByTypeLocale38DetailId(Long id);
    long countByTypeLocale38DetailCode(String code);




}
