package com.alan.api.service.impl;

import com.alan.api.model.User;
import com.alan.api.service.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author: alan.peng
 * description:
 * date: create in 18:05 2018/11/3
 * modified By：
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userService.findDetailByUsername(username);
        List<SimpleGrantedAuthority> authorities =
                user.getPermissionCodeList().stream()
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());Collectors.toList();
        authorities.add(new SimpleGrantedAuthority(user.getRoleName()));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                authorities
        );
    }
}
