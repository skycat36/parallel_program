package com.vsu.data;

import org.apache.commons.math3.util.ArithmeticUtils;

public class SomeFunction {

    public static double value(double x, int accuracy){
        double result = 1;
        int changeFlag = -1;
        for (int i = 0; i < accuracy; i++){
            changeFlag *= (-1);
            result += Math.pow(x, Math.pow(2, i)) / ArithmeticUtils.factorialDouble((int) (Math.pow(2, i)+1)) * changeFlag;
        }
        return result;
    }

}
