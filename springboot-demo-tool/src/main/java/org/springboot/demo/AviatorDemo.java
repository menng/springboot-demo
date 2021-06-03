package org.springboot.demo;

import com.googlecode.aviator.AviatorEvaluator;

import java.util.HashMap;
import java.util.Map;

public class AviatorDemo {
    public static void main(String[] args) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("param1", 1);
        maps.put("param2", "test123");
        maps.put("param3", 6);

        String expression = "param1 == 1 && string.contains(param2,\"test\") && param3 > 5";
        System.out.println(executeBoolean(expression, maps));
    }

    public static Boolean executeBoolean(String expression, Map<String, Object> mapParam) {
        return (boolean) (Boolean) AviatorEvaluator.execute(expression, mapParam);
    }
}
