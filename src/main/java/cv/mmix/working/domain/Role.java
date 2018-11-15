package cv.mmix.working.domain;

//import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, EMPLOYER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
