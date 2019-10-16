package com.vsu.data;

public class TaskPoint implements Comparable {

    private int number;

    private int value;

    public TaskPoint(int number, int value) {
        this.number = number;
        this.value = value;
    }

    public TaskPoint(int value) {
        this.value = value;
    }

    public int getNumber() {
        return number;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int compareTo(Object o) {
        if (((TaskPoint)o).value == this.value){
            return 0;
        }

        if (((TaskPoint)o).value > this.value){
            return 1;
        }else {
            return -1;
        }
    }
}
