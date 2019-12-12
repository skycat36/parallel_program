package vsu.com.app;

import vsu.com.controller.TaskManager;

import java.util.Date;

public class App {

    static int COUNT_TASK = 10;


    public static void main(String[] args){
        long start = new Date().getTime();
        TaskManager taskManager = new TaskManager(COUNT_TASK);
        taskManager.goTaski();
        long end = new Date().getTime();
        System.out.println("ID:        Value");
        taskManager.getPointTaskiList().forEach(x->System.out.println(x.getId() + "       " + x.getRes()));
        System.out.println("Время выполнения: " + (end - start));

    }
}
