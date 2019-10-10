package vsu.controller;

import vsu.data.PointFunc;
import vsu.data.Taska;

import java.util.ArrayList;
import java.util.List;

public class TaskController {

    private List<Taska> taskList = new ArrayList();

    private List<PointFunc> pointList = new ArrayList();

    private int limitA, limitB, n, countTask, accuracy;

    public TaskController(int limitA, int limitB, int n, int countTask, int accuracy) {
        this.limitA = limitA;
        this.limitB = limitB;
        this.n = n;
        this.countTask = countTask;
        this.accuracy = accuracy;
        this.initTasks();
        this.calculetePoints();
    }

    private void calculetePoints(){
        double step = ((double) Math.abs(this.limitB) - Math.abs(this.limitA)) / ((double)this.n);
        for (double i = this.limitA; i < this.limitB; i += step ){
            this.pointList.add(new PointFunc(i));
        }
        this.pointList.add(new PointFunc(this.limitB));
    }

    private void initTasks(){
        for (int i=0; i < this.countTask; i++){
            this.taskList.add(new Taska(i, this.accuracy));
        }
    }

    private boolean proveEnd(){
        for (PointFunc pointFunc : this.pointList){
            if (!pointFunc.isFlagCalc()){
                return true;
            }
        }
        return false;
    }

    private PointFunc getFreePoint(){
        for (PointFunc pointFunc: this.pointList){
            if (!pointFunc.isFlagCalc()){
                pointFunc.setFlagCalc(true);
                return pointFunc;
            }
        }
        return null;
    }

    public void calculateFunction(){

        while (proveEnd()){
            for (Taska taska: this.taskList){
                if (taska.isReady()){
                    PointFunc pointFunc = getFreePoint();
                    if (pointFunc != null) {
                        taska.setPointFunc(pointFunc);
                        taska.run();
                    }
                }
            }
        }

    }

    public List<PointFunc> getPointList() {
        return pointList;
    }

    public List getTaskList() {
        return taskList;
    }

    public int getLimitA() {
        return limitA;
    }

    public int getLimitB() {
        return limitB;
    }

    public int getN() {
        return n;
    }

    public int getCountTask() {
        return countTask;
    }
}
