package ma.zs.univ.service.facade.admin.commun;

import java.util.List;
import ma.zs.univ.bean.core.commun.Redevable;
import ma.zs.univ.dao.criteria.core.commun.RedevableCriteria;
import ma.zs.univ.zynerator.service.IService;



public interface RedevableAdminService extends  IService<Redevable,RedevableCriteria>  {
    Redevable findByUsername(String username);
    boolean changePassword(String username, String newPassword);





}
