package com.example.demo.aop;

import java.lang.reflect.Field;
import java.sql.ResultSet;

public class StudentMapper {

    public static <T> T convertToObject(Class<T> classObj, ResultSet rs) {
        try {
            Object result = Class.forName(classObj.getName()).newInstance();
            Field[] fields = classObj.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.getDeclaredAnnotation(Key.class) != null) field.set(result, rs.getObject(field.getDeclaredAnnotation(Key.class).column()));
            }
            return (T) result;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
