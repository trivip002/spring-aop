package com.example.demo.model;

import com.example.demo.aop.Column;
import lombok.SneakyThrows;
import org.springframework.jdbc.core.RowMapper;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.ResultSet;

public class Mapper<T> implements RowMapper<T>, Serializable {

    @Override
    public T mapRow(ResultSet resultSet, int i) {
        return convertToObject((Class<T>) this.getClass(), resultSet);
    }

    @SneakyThrows
    private T convertToObject(Class<T> classType, ResultSet rs) {
        Object result = classType.getDeclaredConstructor().newInstance();
        for (Field field : classType.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                if (field.getDeclaredAnnotation(Column.class) == null) {
                    field.set(result, rs.getObject(underScore(field)));
                } else {
                    field.set(result, rs.getObject(field.getDeclaredAnnotation(Column.class).name()));
                }
            } catch (Exception ignored) {
            }
        }
        return classType.cast(result);
    }

    private String underScore(Field field) {
        return field.getName().replaceAll("([A-Z])", "_$1").toLowerCase();
    }
}
