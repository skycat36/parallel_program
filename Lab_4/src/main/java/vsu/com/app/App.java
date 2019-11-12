package vsu.com.app;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import vsu.com.controller.TaskManager;

import java.util.Date;

public class App {

    static int COUNT_TASK = 5;

    static int RAZ_MATRIX = 100;

    private static double[][] getRandomMatrix(int n){
        double[][] arr = new double[n][];
        for (int i = 0; i < n; i++){
            arr[i] = new double[n];
            for (int j = 0; j < n; j++){
                arr[i][j] = ((int)(Math.random() * 10));
            }
        }
        return arr;
    }

    public static void main(String[] args){
        long start = new Date().getTime();
        TaskManager taskManager = new TaskManager(COUNT_TASK, MatrixUtils.createRealMatrix(getRandomMatrix(RAZ_MATRIX)));
        RealMatrix rez = taskManager.calculateTrapecZero();
        long end = new Date().getTime();
        System.out.println("Время выполнения: " + (end - start));

        for (double[] row : rez.getData()){
            for (int i = 0; i < row.length; i++){
                System.out.print(row[i] + "   ");
            }
            System.out.println();
        }
    }
}
