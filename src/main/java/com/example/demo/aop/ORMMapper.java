package com.example.demo.aop;

import java.lang.reflect.Field;
import java.sql.ResultSet;

public class ORMMapper {

    public static <T> T convertToObject(Class<T> classObj, ResultSet rs) {
        try {
            Object result = classObj.getDeclaredConstructor().newInstance();
            Field[] fields = classObj.getDeclaredFields();
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    if (field.getDeclaredAnnotation(Key.class) != null) field.set(result, rs.getObject(field.getDeclaredAnnotation(Key.class).column()));
                } catch (Exception ignored) {}
            }
            return (T) result;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
