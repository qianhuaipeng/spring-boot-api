package com.alan.api.service.impl;

import com.alan.api.core.exception.ServiceException;
import com.alan.api.core.service.AbstractService;
import com.alan.api.mapper.UserMapper;
import com.alan.api.mapper.UserRoleMapper;
import com.alan.api.model.User;
import com.alan.api.model.UserRole;
import com.alan.api.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author: alan.peng
 * description:
 * date: create in 11:25 2018/11/3
 * modified By：
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends AbstractService<User> implements UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserRoleMapper userRoleMapper;
    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public void save(User user) {
        User u = this.findBy("username", user.getUsername());
        if(u != null) {
            throw new ServiceException("username already existed");
        } else {
            u = this.findBy("email", user.getEmail());
            if (u != null) {
                throw new ServiceException("email already existed");
            } else {
                user.setPassword(this.passwordEncoder.encode(user.getPassword().trim()));
                this.userMapper.insertSelective(user);
                Long roleId = user.getRoleId();
                if(roleId == null) {
                    roleId = 2L;
                }
                this.userRoleMapper.insertSelective(new UserRole().setUserId(user.getId()).setRoleId(roleId));
            }
        }

    }


    @Override
    public List<User> findAllUserWithRole() {
        return userMapper.findAllUserWithRole();
    }

    @Override
    public User findDetailBy(String column, Object param) {
        Map<String,Object> map = new HashMap<>(1);
        map.put(column, param);
        return this.userMapper.findDetailBy(map);
    }

    @Override
    public User findDetailByUsername(String username) throws UsernameNotFoundException {
        User user = this.findDetailBy("username",username);
        if (user == null) {
            throw new UsernameNotFoundException("not found this username");
        }
        if ("ROLE_ADMIN".equals(user.getRoleName())) {

        }
        return null;
    }

    @Override
    public void updateLoginTimeByUsername(String username) {

    }

    @Override
    public boolean verifyPassword(String rawPassword, String encodedPassword) {
        return false;
    }

    @Override
    public void delete(User model) {

    }

    @Override
    public void update(User model) {

    }

    @Override
    public void updateByCondition(User model, Condition condition) {

    }
}
