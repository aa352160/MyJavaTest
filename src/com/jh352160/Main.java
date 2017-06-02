package com.jh352160;


import com.jh352160.json.JsonUtil;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BigDecimal bigDecimal1=new BigDecimal("1.0");
        BigDecimal bigDecimal2=new BigDecimal("1.00");
        System.out.println(bigDecimal1.equals(bigDecimal2));
        System.out.println(bigDecimal1.compareTo(bigDecimal2));
    }
}
