package com.alan.api.service;

import com.alan.api.core.service.Service;
import com.alan.api.model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * author: alan.peng
 * description:
 * date: create in 10:34 2018/11/3
 * modified By：
 */
public interface UserService extends Service<User> {

    /**
     *  获取所有用户以及对应角色
     *
     * @return 用户列表
     */
    List<User> findAllUserWithRole();

    /**
     *  按条件查询用户信息
     * @param column
     * @param param
     * @return
     */
    User findDetailBy(String column, Object param);

    /**
     * 按用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户
     * @throws UsernameNotFoundException 用户名找不到
     */
    User findDetailByUsername(String username) throws UsernameNotFoundException;

    /**
     * 按用户名更新最后一次登录时间
     * @param username
     */
    void updateLoginTimeByUsername(String username) ;

    /**
     *  验证用户密码
     *
     * @param rawPassword 原密码
     * @param encodedPassword 加密后的密码
     * @return
     */
    boolean verifyPassword(String rawPassword, String encodedPassword);
}
