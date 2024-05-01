package ma.zs.univ.service.impl.admin.commun;


import ma.zs.univ.bean.core.commun.Redevable;
import ma.zs.univ.dao.criteria.core.commun.RedevableCriteria;
import ma.zs.univ.dao.facade.core.commun.RedevableDao;
import ma.zs.univ.dao.specification.core.commun.RedevableSpecification;
import ma.zs.univ.service.facade.admin.commun.RedevableAdminService;
import ma.zs.univ.zynerator.service.AbstractServiceImpl;
import ma.zs.univ.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import ma.zs.univ.zynerator.security.service.facade.UserService;
import ma.zs.univ.zynerator.security.service.facade.RoleService;
import ma.zs.univ.zynerator.security.bean.Role;
import java.util.Collection;
import java.util.List;
@Service
public class RedevableAdminServiceImpl extends AbstractServiceImpl<Redevable, RedevableCriteria, RedevableDao> implements RedevableAdminService {












    @Override
    public Redevable create(Redevable t) {
        if (findByUsername(t.getUsername()) != null || t.getPassword() == null) return null;
        t.setPassword(userService.cryptPassword(t.getPassword()));
        t.setEnabled(true);
        t.setAccountNonExpired(true);
        t.setAccountNonLocked(true);
        t.setCredentialsNonExpired(true);
        t.setPasswordChanged(false);
        /*if (t.getRoles() != null) {
            Collection<Role> roles = new ArrayList<Role>();
            for (Role role : t.getRoles()) {
                roles.add(roleService.save(role));
            }
            t.setRoles(roles);
        }*/
        Redevable mySaved = super.create(t);

        return mySaved;
     }

    public Redevable findByUsername(String username){
    return dao.findByUsername(username);
    }

    public boolean changePassword(String username, String newPassword) {
    return userService.changePassword(username, newPassword);
    }

    public void configure() {
        super.configure(Redevable.class, RedevableSpecification.class);
    }

    @Autowired
    private UserService userService;


    @Autowired
    private RoleService roleService;


    public RedevableAdminServiceImpl(RedevableDao dao) {
        super(dao);
    }

}
