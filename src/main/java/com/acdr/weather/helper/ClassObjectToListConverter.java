package com.acdr.weather.helper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ClassObjectToListConverter {

    public static <T> List<T> convert(Object object) {

        Class<?> objectClass = object.getClass();
        Field[] fields = objectClass.getDeclaredFields();

        List<T> results = new ArrayList<>();

        for (Field field : fields) {
            field.setAccessible(true);

            try {
                Object value = field.get(object);

                if (value != null) {
                    results.add((T) value);
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return results;
    }
}
