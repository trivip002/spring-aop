package com.example.demo.model;

import com.example.demo.aop.Column;
import lombok.SneakyThrows;
import org.springframework.jdbc.core.RowMapper;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.Optional;

public class Mapper<T> implements RowMapper<T>, Serializable {

    @Override
    public T mapRow(ResultSet resultSet, int i) {
        return convertToObject((Class<T>) this.getClass(), resultSet);
    }

    @SneakyThrows
    private T convertToObject(Class<T> classType, ResultSet rs) {
        T result = classType.getDeclaredConstructor().newInstance();
        for (Field field : classType.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                field.set(result, rs.getObject(Optional.of(field.getDeclaredAnnotation(Column.class).name())
                        .orElse(field.getName().replaceAll("([A-Z])", "_$1").toLowerCase())));
            } catch (Exception ignored) {}
        }
        return classType.cast(result);
    }
}
