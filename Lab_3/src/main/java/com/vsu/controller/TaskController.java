package com.vsu.controller;

import com.vsu.data.TaskPoint;
import com.vsu.data.Taska;

import java.util.ArrayList;
import java.util.List;

public class TaskController {

    private List<Taska> taskaList = new ArrayList<Taska>();

    private int rang, n;

    private int countTask;

    private List<TaskPoint> maxVector = new ArrayList<TaskPoint>();

    public TaskController(int n, int rang, int countTask) {
        this.n = n;
        this.rang = rang;
        this.countTask = countTask;
        this.initTaska();

    }

    private void initTaska(){
        for (int i = 0; i < this.countTask; i++){
            this.taskaList.add(new Taska(this.n, this.rang));
        }
    }

    public void goTaski(){

        for (Taska taska: this.taskaList){
            taska.run();
        }

        boolean ready = false;
        while (ready){
            ready = true;
            for (Taska taska: this.taskaList){
                if (taska.isAlive()){
                    ready = false;
                }
            }
        }

        for (Taska taska: this.taskaList){
            this.maxVector.add(taska.getMax());
        }
    }

    public List<TaskPoint> getMaxVector() {
        return maxVector;
    }
}
