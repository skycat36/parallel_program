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



                if (rowNeedUpdate == (matrixRow.length-1) ){
                    matrixRow[matrixRow.length-1 - rowNeedUpdate] = 0;
                    matrixRow[matrixRow.length-1 - rowNeedUpdate + 1] = 0;
                }

                if (rowNeedUpdate == 0){
                    matrixRow[matrixRow.length-1 - rowNeedUpdate] = 0;
                    matrixRow[matrixRow.length-1 - rowNeedUpdate -1] = 0;
                }

                if (rowNeedUpdate != 0 && rowNeedUpdate != (matrixRow.length-1)){
                    matrixRow[matrixRow.length-1 - rowNeedUpdate] = 0;
                    matrixRow[matrixRow.length-1 - rowNeedUpdate -1] = 0;
                    matrixRow[matrixRow.length-1 - rowNeedUpdate + 1] = 0;
                }

                this.finalMatrix.setRow(rowNeedUpdate, matrixRow);

            }else {
                flagEnd = false;
            }
        }
    }


}
