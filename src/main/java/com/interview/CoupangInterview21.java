package com.interview;

import java.lang.reflect.Field;
import java.time.OffsetDateTime;
import java.util.*;

/**
 * Created by wuyuntao on 2025/6/29
 */
public class CoupangInterview21 {
// 1、找到新老字段pair做转换
    // 2、不入侵业务，考虑AOP
    // 3、可能父子类，可能用到反射
    // 4、可能存在集合 遍历


    // request
    // String phone
    // Double DeliveryFee;
    // Date orderAt


    // requestDTO
    // String globalPhone;
    // Money globalDeliveryFee;
    // OffsetDateTime globalOrderAt;


    public static void main(String[] args) {


    }


    // @controller("/xxx")
    // @Aspect(AspectConvertRequest.class)
    public Response getInfo(Request request) {
        return null;
    }




}


class AspectConvertRequest {


    // 新老字段映射


    // old name ->  new field Type
    private static HashMap<String, FieldType> fieldMap = new HashMap<>();


    public AspectConvertRequest() {
        fieldMap.put("phone", new FieldType("globalPhone", new PhoneFieldConvert()));
        fieldMap.put("DeliveryFee", new FieldType("globalDeliveryFee", new DeliveryConvert()));
        fieldMap.put("orderAt", new FieldType("globalOrderAt", new OffsetDateTimeFieldConvert()));
    }




    public RequestDTO convertRequest(Request request) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
//        Field[] oldFields = Request.class.getFields();


        List<Field> oriFields = new LinkedList<>();
        Class<?> clazz = request.getClass();
        while (clazz != null && !clazz.equals(Object.class)) {
            oriFields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }


        RequestDTO requestDTO = RequestDTO.class.newInstance();
        Class<?> targetClazz = requestDTO.getClass();
        for (Field filed : oriFields) {
            filed.setAccessible(true);
            String name = filed.getName();
            FieldType newFiledType = fieldMap.get(name);
            if (newFiledType == null) {
                continue;
            }
            Field newFiled = targetClazz.getField(newFiledType.name);
            newFiled.setAccessible(true);
            Object newVal = handleValue(newFiledType, newFiled, filed, filed.get(request));
            newFiled.set(targetClazz, newVal);


        }
        return requestDTO;


    }


    private Object handleValue(FieldType newFiledType, Field newField, Field oldField, Object oldVal) {
        if (oldVal == null) {
            return null;
        }


        if (isCustomObjectField(newField)) {
            return newFiledType.convert(oldVal);
        }
        // 考虑递归
        return newFiledType.convert(oldVal);


    }


    boolean isCustomObjectField(Field field) {
        Class<?> fieldType = field.getType();
        return !fieldType.isPrimitive() &&          // 排除基本类型
                !fieldType.isArray() &&              // 排除数组
                !(fieldType.getPackage() != null &&  // 排除 java.lang 和 java.util 等 Java 原生类
                        (fieldType.getPackage().getName().startsWith("java.lang") ||
                                fieldType.getPackage().getName().startsWith("java.util")));
    }
}




interface FieldConvert<S, T> {
    T ConvertValue(S source);
}


class CommonFieldConvert implements FieldConvert<Object, Object> {


    @Override
    public Object ConvertValue(Object source) {
        return source;
    }
}


class PhoneFieldConvert implements FieldConvert<String, String> {


    @Override
    public String ConvertValue(String source) {
        // phone
        return null;
    }
}




class DeliveryConvert implements FieldConvert<Double, Money> {


    @Override
    public Money ConvertValue(Double source) {
        // delivery
        return null;
    }
}




class OffsetDateTimeFieldConvert implements FieldConvert<Date, OffsetDateTime> {


    @Override
    public OffsetDateTime ConvertValue(Date source) {
        // atTime
        return null;
    }
}




// new dto field
class FieldType {
    String name;
    FieldConvert convertFunc;


    public FieldType(String name, FieldConvert<?,?> convert) {
        this.name = name;
        this.convertFunc = convert;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FieldType fieldType = (FieldType) o;
        return Objects.equals(name, fieldType.name) && Objects.equals(convertFunc, fieldType.convertFunc);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, convertFunc);
    }


    @SuppressWarnings("unchecked")
    public Object convert(Object obj) {
        // handle customer
        return convertFunc.ConvertValue(obj);
    }




}


class Request {
    String phone;
    Double DeliveryFee;
    Date orderAt;
}




class Response {

}


class Money {
    Double DeliveryFee;
}


class RequestDTO {
    String globalPhone;
    Money globalDeliveryFee;
    OffsetDateTime globalOrderAt;
}