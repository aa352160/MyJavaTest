package com.jh352160.annotation;

import com.jh352160.annotation.RunTimeTest;
import com.jh352160.annotation.run_classInfo;
import com.jh352160.annotation.run_fieldInfo;
import com.jh352160.annotation.run_methodInfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Created by pcdalao on 2016/12/21.
 */
public class AnnotationTest {

    /**
     * 解析运行时注解
     */
    public void showRunTimeInfo() {
        StringBuffer sb = new StringBuffer();
        //获取Class 注解
        Class<?> clazz = RunTimeTest.class;
        Constructor<?>[] constructors = clazz.getConstructors();
        //获取包含的注解类信息
        run_classInfo runClassInfo = clazz.getAnnotation(run_classInfo.class);
        if (runClassInfo != null) {
            //获取class注解
            sb.append("Class注解: ").append("\n");
            sb.append(Modifier.toString(clazz.getModifiers())).append(" ")
                    .append(clazz.getSimpleName()).append("\n");

            sb.append("注解值：").append("\n")
                    .append(runClassInfo.value()).append("\n\n");
        }

        //获取Field注解
        sb.append("Field注解：").append("\n");
        Field[] fields = clazz.getDeclaredFields(); //获取自身的不包括继承类
        for (Field field : fields) {
            //获取field注解类信息
            run_fieldInfo fieldInfo = field.getAnnotation(run_fieldInfo.class);
            if (fieldInfo != null) {
                sb.append(Modifier.toString(field.getModifiers())).append(" ")
                        .append(field.getType().getSimpleName()).append(" ")
                        .append(field.getName()).append("\n");
                sb.append("注解值： ").append("\n")
                        .append(Arrays.toString(fieldInfo.value())).append("\n\n");
            }
        }

        //获取Method 注解
        sb.append("Method注解： ").append("\n");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            run_methodInfo methodInfo = method.getAnnotation(run_methodInfo.class);
            if (methodInfo != null) {
                sb.append(Modifier.toString(method.getModifiers())).append(" ")
                        .append(method.getReturnType().getSimpleName()).append(" ")
                        .append(method.getName()).append("\n");
                sb.append("注解值：").append("\n");
                sb.append("name: ").append(methodInfo.name()).append("\n");
                sb.append("data: ").append(methodInfo.data()).append("\n");
                sb.append("id: ").append(methodInfo.id()).append("\n");
            }

        }
        System.out.println(sb.toString());
    }

}
