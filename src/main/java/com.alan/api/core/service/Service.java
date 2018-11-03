package com.alan.api.core.service;

import org.apache.ibatis.exceptions.TooManyResultsException;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * author: alan.peng
 * description: service 层基础接口，其它service接口，请继承该接口
 *
 * date: create in 10:14 2018/11/3
 * modified By：
 */
public interface Service<T> {

    /**
     * 持久化
     *
     * @param model 实体
     */
    void save(T model);

    /**
     * 持久化
     * @param model 实体
     */
    void save(List<T> model);

    /**
     * 通过主键删除
     * @param id
     */
    void deleteById(Object id);

    /**
     * 通过Model中某个成员变量名称（非数据库中column的名称）删除
     *
     * @param fieldName 数据库中的字段名
     * @param value 字段对应的值
     * @throws TooManyResultsException
     */
    void deleteBy(String fieldName, Object value) throws TooManyResultsException;

    /**
     * 批量删除 eg：ids -> "1,2,3,4"
     *
     *  @param ids 多个ID
     */
    void deleteByIds(String ids);

    /**
     * 根据条件删除
     *
     * @param condition 条件
     */
    void deleteByCondition(Condition condition);

    /**
     * 根据对象删除
     * @param model 对象
     */
    void delete(T model);

    /**
     * 更新对象
     *
     * @param model 实体对象
     */
    void update(T model);

    /**
     * 根据条件更新
     *
     * @param condition
     */
    void updateByCondition(T model, Condition condition);

    /**
     * 通过ID查找
     * @param id
     * @return T
     */
    T findById(Object id);

    /**
     * 通过model 中的某个成员的变量名称查找，value须符合unique约束
     *
     * @param fieldName 数据库字段名
     * @param value     字段对应的名称
     * @return  T
     * @throws TooManyResultsException
     */
    T findBy(String fieldName, Object value) throws TooManyResultsException;

    /**
     * 通过多个ID查找 // eg: ids -> "1,2,3,4"
     *
     * @param ids 多个ID
     * @return List<T>
     */
    List<T> findByIds(String ids);

    /**
     * 通过条件查询
     * @param condition
     * @return List<T>
     */
    List<T> findByCondition(Condition condition);

    /**
     * 查询所有
     *
     * @return List<T>
     */
    List<T> findAll();

    /**
     * 计数
     *
     * @param condition
     * @return 数量
     */
    int countByCondition(Condition condition);
}
