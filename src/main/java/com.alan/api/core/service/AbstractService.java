package com.alan.api.core.service;

import com.alan.api.core.exception.ServiceException;
import com.alan.api.core.mapper.MyMapper;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * author: alan.peng
 * description: 基于通用Mybatis Mapper 插件的Service接口的实现
 * date: create in 10:43 2018/11/3
 * modified By：
 */
public abstract class AbstractService<T> implements Service<T>{

    @Autowired
    protected MyMapper<T> mapper;

    private final Class<T> modelClass;

    public AbstractService() {
        final ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @Override
    public void save(T model) {
        mapper.insertSelective(model);
    }

    @Override
    public void save(List<T> model) {
        this.mapper.insertList(model);
    }

    @Override
    public void deleteById(Object id) {
        this.mapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteBy(String fieldName, Object value) throws TooManyResultsException {
        try {
            final T model = this.modelClass.newInstance();
            final Field field = this.modelClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(model,value);
            this.mapper.delete(model);
        }  catch (ReflectiveOperationException e) {
            throw new ServiceException(e.getMessage(),e);
        }


    }

    @Override
    public void deleteByIds(String ids) {
        this.mapper.deleteByIds(ids);
    }

    @Override
    public void deleteByCondition(Condition condition) {
        this.mapper.deleteByCondition(condition);
    }

    @Override
    public void delete(T model) {
        this.mapper.delete(model);
    }

    @Override
    public void update(T model) {
        this.mapper.updateByPrimaryKeySelective(model);
    }

    @Override
    public void updateByCondition(T model, Condition condition) {
        this.mapper.updateByConditionSelective(model,condition);
    }

    @Override
    public T findById(Object id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    @Override
    public T findBy(String fieldName, Object value) throws TooManyResultsException {
        try {
            final T model = this.modelClass.newInstance();
            final Field field = this.modelClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(model, value);
            return this.mapper.selectOne(model);
        }  catch (ReflectiveOperationException e) {
            throw new ServiceException(e.getMessage(),e);
        }
    }

    @Override
    public List<T> findByIds(String ids) {
        return this.mapper.selectByIds(ids);
    }

    @Override
    public List<T> findByCondition(Condition condition) {
        return this.mapper.selectByCondition(condition);
    }

    @Override
    public List<T> findAll() {
        return this.mapper.selectAll();
    }

    @Override
    public int countByCondition(Condition condition) {
        return this.mapper.selectCountByCondition(condition);
    }
}
