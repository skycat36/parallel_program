package com.vsu.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Taska extends Thread {

    final int DEF = 0;

    private int id;

    private int count;

    private List<TaskPoint> arr = new ArrayList();

    private int rang;

    private TaskPoint max;

    public Taska(int id, int count, int rang) {
        this.id = id;
        this.count = count;
        this.rang = rang;
    }

    private Integer generateMessage(){
        return Integer.parseInt(String.valueOf(Math.round(Math.random() * 100)));
    }

    private void initArr(){
        for (int i=0; i < this.count; i++){
            this.arr.add(new TaskPoint(this.id, i + 1, generateMessage()));
        }

    }

    private void calcMax(){
        List<TaskPoint> temp = new ArrayList<TaskPoint>();
        if (this.count % 2 != 0){
            for (int i = 0; i < this.count; i++){
                if (this.arr.get(i).getNumber() % 2 != 0){
                    temp.add(this.arr.get(i));
                }
            }

            Collections.sort(temp);
            this.max = temp.get(0);
        }else{
            this.max = new TaskPoint(this.DEF);
        }
    }


    @Override
    public void run() {
        this.initArr();
        this.calcMax();
    }

    public TaskPoint getMax() {
        return max;
    }
}
