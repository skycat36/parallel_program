package com.vsu.app;

import com.vsu.controller.TaskController;
import com.vsu.data.TaskPoint;

import java.util.Date;

public class Application {

    private static int N = 5, ACCURACY = 5, COUNT_THREADS = 10;

    public static void main(String[] args) {

        TaskController taskController = new TaskController(N, ACCURACY, COUNT_THREADS);

        long start = new Date().getTime();
        taskController.goTaski();

        long end = new Date().getTime();

        System.out.println("Время выполнения: " + (end - start));

        System.out.println("Id потока:              Точка:                 Значение:");
        for (TaskPoint pointFunc : taskController.getMaxVector()) {
            System.out.println(pointFunc.getIdTask() + ":                         " + pointFunc.getNumber() + " :                    " + pointFunc.getValue());
        }

    }
}

