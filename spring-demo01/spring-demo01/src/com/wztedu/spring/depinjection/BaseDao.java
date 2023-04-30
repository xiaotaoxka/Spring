package com.wztedu.spring.depinjection;

/**
 * 自定义泛型类
 *
 * @param <T>
 */
public abstract class BaseDao<T> {
    public abstract void save();
}

