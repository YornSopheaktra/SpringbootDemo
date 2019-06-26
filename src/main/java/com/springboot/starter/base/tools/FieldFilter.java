package com.springboot.starter.base.tools;

import javax.persistence.Entity;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.beanutils.PropertyUtils;

public class FieldFilter {
    private String fieldName;
    private Object[] fieldValues;

    private FilterMode filterMode;

    public FieldFilter(String fieldName, FilterMode filterMode, Object... fieldValues) {
        this.fieldName = fieldName;
        this.filterMode = filterMode;
        this.fieldValues = fieldValues;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Object[] getFieldValues() {
        return fieldValues;
    }

    public Object getFieldValue() {
        return fieldValues[0];
    }

    public Object getField2Value() {
        return fieldValues[1];
    }

    public void setFieldValue(Object... fieldValues) {
        if (!isSupportedField(fieldValues)) {
            throw new IllegalArgumentException("Only the following types are supported: Date, String, Number.");
        }
        this.fieldValues = fieldValues;
    }

    public FilterMode getFilterMode() {
        return filterMode;
    }

    public void setFilterMode(FilterMode filterMode) {
        this.filterMode = filterMode;
    }

    private boolean isSupportedField(Object fieldValue) {
		/*return fieldValue instanceof String
				|| fieldValue instanceof Date
				|| Number.class.isAssignableFrom(fieldValue.getClass());*/
        return true;
    }

    public static Object reflectionFieldValue(Object obj, String property, FieldFilter fileFilter) {
        try {
            if (property.contains(".")) {
                String props[] = property.split("\\.");
                Object value;
                if (List.class.isAssignableFrom(obj.getClass())) {
                    List list = (List) obj;
                    value = list.isEmpty() ? null : list.get(0);
                } else {
                    value = PropertyUtils.getProperty(obj, props[0]);
                    if (value == null) return null;
                    if (List.class.isAssignableFrom(value.getClass())) {
                        List list = (List) value;
                        value = list.isEmpty() ? null : list.get(0);
                    }
                }
                if (value == null) return null;
                return reflectionFieldValue(value, property.substring(props[0].length() + 1), fileFilter);
            } else {
                if (List.class.isAssignableFrom(obj.getClass())) {
                    List list = (List) obj;
                    return list.isEmpty() ? null : PropertyUtils.getProperty(list.get(0), property);
                } else {
                    return PropertyUtils.getProperty(obj, property);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Map<String, Field> getFields(Class clazz) {
        Map<String, Field> fieldMap = new HashMap();
        while (clazz != Object.class) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields)
                fieldMap.put(field.getName(), field);
            clazz = clazz.getSuperclass();
        }
        if (clazz.isAssignableFrom(Entity.class))
            fieldMap.remove("map");
        return fieldMap;
    }

    public static List<Field> listFields(Class clazz) {
        return (List<Field>) getFields(clazz).values();
    }

    public static Map<String, FieldFilter> aliasField(Class clazz) {
        Set<String> keys = getFields(clazz).keySet();
        Map<String, FieldFilter> map = new HashMap();
        for (String key : keys)
            map.put(key, new FieldFilter(key, null, null));
        return map;
    }

}
