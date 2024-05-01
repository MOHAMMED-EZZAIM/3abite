package ma.zs.univ.service.impl.admin.taxe38;


import ma.zs.univ.bean.core.taxe38.Trim;
import ma.zs.univ.dao.criteria.core.taxe38.TrimCriteria;
import ma.zs.univ.dao.facade.core.taxe38.TrimDao;
import ma.zs.univ.dao.specification.core.taxe38.TrimSpecification;
import ma.zs.univ.service.facade.admin.taxe38.TrimAdminService;
import ma.zs.univ.zynerator.service.AbstractServiceImpl;
import ma.zs.univ.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class TrimAdminServiceImpl extends AbstractServiceImpl<Trim, TrimCriteria, TrimDao> implements TrimAdminService {













    public void configure() {
        super.configure(Trim.class, TrimSpecification.class);
    }



    public TrimAdminServiceImpl(TrimDao dao) {
        super(dao);
    }

}
