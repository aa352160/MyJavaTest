package com.jh352160;

import com.jh352160.annotation.run_classInfo;
import com.jh352160.annotation.run_fieldInfo;
import com.jh352160.annotation.run_methodInfo;

/**
 * Created by pcdalao on 2016/12/21.
 */
@run_classInfo("类注解RunTime Class")
public class RunTimeTest {
    @run_fieldInfo(value = {77, 88})
    public String fieldInfo = "filedInfo";

    @run_fieldInfo(value = {163})
    public int id = 55;

    @run_methodInfo(name = "彩笔学长", data = "finance")
    public static String getMethod() {
        return RunTimeTest.class.getSimpleName();
    }
}
