package com.vsu.data;

public class PointFunc {

    private double point;

    private double value;

    private boolean flagCalc = false;

    public PointFunc(double point) {
        this.point = point;
    }

    public double getPoint() {
        return point;
    }

    public boolean isFlagCalc() {
        return flagCalc;
    }

    public void setFlagCalc(boolean flagCalc) {
        this.flagCalc = flagCalc;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
