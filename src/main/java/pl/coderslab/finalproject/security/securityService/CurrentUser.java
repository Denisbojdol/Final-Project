package pl.coderslab.finalproject.security.securityService;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
public class CurrentUser extends User {
    private final pl.coderslab.finalproject.security.securityEntity.User user;
    public CurrentUser(String username, String password,
                       Collection<? extends GrantedAuthority> authorities,
                       pl.coderslab.finalproject.security.securityEntity.User user) {
        super(username, password, authorities);
        this.user = user;
    }
    public pl.coderslab.finalproject.security.securityEntity.User getUser() {return user;}
}