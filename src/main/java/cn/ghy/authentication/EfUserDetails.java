package cn.ghy.authentication;

import cn.ghy.models.Authority;
import cn.ghy.models.UserInfo;
import cn.ghy.models.UserStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class EfUserDetails implements UserDetails {

    private UserInfo userInfo;
    private List<Authority> authorities;

    public EfUserDetails(UserInfo user, List<Authority> authorities) {

        this.userInfo = user;
        this.authorities = authorities;
    }

    @Override
    public String getUsername() {

        return this.userInfo.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {

        return this.userInfo.getStatus().equals(UserStatus.ACTIVE);
    }

    @Override
    public boolean isAccountNonLocked() {

        return this.userInfo.getStatus().equals(UserStatus.LOCKED);
    }

    @Override
    public boolean isCredentialsNonExpired() {

        return true;
    }

    @Override
    public boolean isEnabled() {

        return this.userInfo.getStatus().equals(UserStatus.ACTIVE);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return this.authorities;
    }

    @Override
    public String getPassword() {

        return this.userInfo.getPassword();
    }
}
