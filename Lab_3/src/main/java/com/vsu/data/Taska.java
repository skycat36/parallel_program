package com.vsu.data;

import java.util.ArrayList;
import java.util.List;

public class Taska extends Thread {

    private int count;

    private List<TaskPoint> arr = new ArrayList();

    public Taska(int count) {
        this.count = count;

    }

    private void initArr(){
        for (int i=0; i < this.count; i++){

        }
    }

    @Override
    public void run() {

    }
}
