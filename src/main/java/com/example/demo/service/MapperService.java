package com.example.demo.service;

import com.example.demo.aop.Column;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.jdbc.core.RowMapper;

import java.lang.reflect.Field;
import java.sql.ResultSet;

@AllArgsConstructor
public class MapperService<T> implements RowMapper<T> {

    private final Class<T> classType;

    @Override
    public T mapRow(ResultSet resultSet, int i) {
        return convertToObject(classType, resultSet);
    }

    @SneakyThrows
    private T convertToObject(Class<T> classType, ResultSet rs) {
        T result = classType.getDeclaredConstructor().newInstance();
        for (Field field : classType.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                String columnName = field.getDeclaredAnnotation(Column.class) != null ?
                        field.getDeclaredAnnotation(Column.class).name() :
                        field.getName().replaceAll("([A-Z])", "_$1").toLowerCase();
                field.set(result, rs.getObject(columnName));
            } catch (Exception ignored) {}
        }
        return classType.cast(result);
    }
}
