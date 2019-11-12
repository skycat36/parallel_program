package vsu.com.controller;

import org.apache.commons.math3.linear.RealMatrix;

public class Taski extends Thread{

    private UpRows upRows;
    private RealMatrix finalMatrix;

    public Taski(UpRows upRows, RealMatrix finalMatrix) {
        this.upRows = upRows;
        this.finalMatrix = finalMatrix;
    }

    @Override
    public void run() {
        boolean flagEnd = true;
        while (flagEnd) {
            Integer rowNeedUpdate = upRows.getNeedRow();

            if (rowNeedUpdate != null) {
                double[] matrixRow = this.finalMatrix.getRow(rowNeedUpdate);

                for (int i = 0; i < rowNeedUpdate; i++) {
                    matrixRow[i] = 0;
                }

                this.finalMatrix.setRow(rowNeedUpdate, matrixRow);

            }else {
                flagEnd = false;
            }
        }
    }
}
