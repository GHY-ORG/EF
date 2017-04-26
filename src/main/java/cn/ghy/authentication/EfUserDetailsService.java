package cn.ghy.authentication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cn.ghy.mappers.AuthorityMapper;
import cn.ghy.mappers.UserInfoMapper;
import cn.ghy.models.Authority;
import cn.ghy.models.UserInfo;

@Service
public class EfUserDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private AuthorityMapper authorityMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserInfo userInfo;
        try {
            userInfo = userInfoMapper.findByUsername(userName);
        } catch (Exception e) {
            throw new UsernameNotFoundException("userinfo select fail");
        }
        if (userInfo == null) {
            throw new UsernameNotFoundException("no userinfo found");
        } else {
            try {
                List<Authority> authorities = authorityMapper.getAuthorityByUserId(userInfo.getId());
                return new EfUserDetails(userInfo, authorities);
            } catch (Exception e) {
                throw new UsernameNotFoundException("user authorities select fail");
            }
        }
    }
}
