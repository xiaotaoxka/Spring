package com.wztedu.spring.depinjection;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义泛型类
 *
 * @param <T>
 */
public class BaseService<T> {
    @Autowired
    private BaseDao<T> baseDao;

    public void save() {
        baseDao.save();
    }
}