package com.chmykhun.jdbc.util;

import com.chmykhun.jdbc.annotation.Column;
import com.chmykhun.jdbc.annotation.Entity;
import com.chmykhun.jdbc.annotation.Id;
import com.chmykhun.jdbc.annotation.Table;

import java.io.Serializable;
import java.lang.reflect.Field;

public class MappingHelper {

    private static final String REGEX_FOR_CAMELCASE_SPLITTING = "(?<=[a-z])(?=[A-Z])|(?<=[A-Z])(?=[A-Z][a-z])";

    public static boolean isEntity(Class entityClass) {
        if (entityClass != null && entityClass.isAnnotationPresent(Entity.class) && getIdField(entityClass) != null) {
            return true;
        }
        return false;
    }

    public static Serializable getId(Object entity) {
        return getFieldValue(getIdField(entity.getClass()), entity);
    }

    public static String getTableName(Class entityClass) {
        return ((Table) entityClass.getAnnotation(Table.class)).name();
    }

    public static String getFieldName(Field field) {
        String fieldName;
        if (field.isAnnotationPresent(Column.class)) {
            fieldName = field.getAnnotation(Column.class).name();
        } else {
            fieldName = buildFieldName(field);
        }

        return fieldName;
    }

    public static Serializable getFieldValue(Field field, Object entity) {
        if (field != null) {
            field.setAccessible(true);
            try {
                return (Serializable) field.get(entity);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public static Field getIdField(Class entityClass) {
        for (Field field : entityClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(Id.class)) {
                return field;
            }
        }

        return null;
    }

    private static String buildFieldName(Field field) {
        String[] words = field.getName().split(REGEX_FOR_CAMELCASE_SPLITTING);
        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            builder.append(word.toLowerCase());
            builder.append("_");
        }
        builder.deleteCharAt(builder.length() - 1);

        return builder.toString();
    }

}
