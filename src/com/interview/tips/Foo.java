package com.interview.tips;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

abstract class Foo<T> {

    public Class<T> getTClass() {
        Class<T> entityClass = null;
        Type t = getClass().getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            Type[] p = ((ParameterizedType) t).getActualTypeArguments();
            entityClass = (Class<T>) p[0];
        }
        return entityClass;
    }
}
