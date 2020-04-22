package com.interview.tips;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

abstract class Bar<T, R> {

    public Class<T> getTClass1() {
        Class<T> entityClass = null;
        Type t = getClass().getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            Type[] p = ((ParameterizedType) t).getActualTypeArguments();
            entityClass = (Class<T>) p[0];
        }
        return entityClass;
    }

    public Class<R> getTClass2() {
        Class<R> entityClass = null;
        Type t = getClass().getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            Type[] p = ((ParameterizedType) t).getActualTypeArguments();
            entityClass = (Class<R>) p[1];
        }
        return entityClass;
    }
}
