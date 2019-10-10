package vsu.application;

import vsu.controller.TaskController;
import vsu.data.PointFunc;

import java.util.Date;
import java.util.List;

public class Application {

    private static int LIMIT_A = 0, LIMIT_B = 100000, N = 10000, ACCURACY = 5, COUNT_THREADS = 3;

    public static void main(String[] args){

        TaskController taskController = new TaskController(LIMIT_A, LIMIT_B, N, COUNT_THREADS, ACCURACY);


        long start = new Date().getTime();
        taskController.calculateFunction();

        long end = new Date().getTime();

        System.out.println("Время выполнения: " + (end - start));

//        System.out.println("Точка:                 Значение:");
//        for (PointFunc pointFunc: taskController.getPointList()){
//            System.out.println(pointFunc.getPoint() + " :        " + pointFunc.getValue());
//        }

    }
}
