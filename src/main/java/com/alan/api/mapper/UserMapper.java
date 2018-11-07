package com.alan.api.mapper;

import com.alan.api.core.mapper.MyMapper;
import com.alan.api.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * author: alan.peng
 * description:
 * date: create in 17:35 2018/11/2
 * modified By：
 */
public interface UserMapper extends MyMapper<User> {

    /**
     * 获取所有用户以及对应角色
     * @return 用户列表
     */
    List<User> findAllUserWithRole();

    /**
     * 按条件查询用户信息
     *
     * @param param
     * @return 用户
     */
    User findDetailBy(Map<String,Object> param);

    /**
     * 按用户名更新最后登录时间
     * @param username
     */
    void updateLoginTimeByUsername(@Param("username") String username);
}
