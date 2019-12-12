package vsu.com.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Taski extends Thread{

    private int id;

    private List<Integer> vectorA;
    private List<Integer> vectorB;

    private TaskManager taskManager;

    public Taski(int id, int n, TaskManager taskManager) {
        this.id = id;

        this.taskManager = taskManager;

        this.vectorA = getRandomVector(n);
        this.vectorB = getRandomVector(n);
    }

    private static List<Integer> getRandomVector(int n){
        List<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < n; i++){
                arr.add((int)(Math.random() * 1000)* (int)Math.pow(-1, (int)(Math.random() * 10)));
        }
        return arr;
    }

    private int getMax(List<Integer> arr){
        return Collections.max(arr);
    }

    private int getMin(List<Integer> arr){
        return Collections.min(arr);
    }

    @Override
    public void run() {
        this.taskManager.addPointTaski(
                new PointTaski(this.id, getMax(vectorA) * getMin(vectorB))
        );

    }
}
