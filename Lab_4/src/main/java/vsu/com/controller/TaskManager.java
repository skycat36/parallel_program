package vsu.com.controller;

import org.apache.commons.math3.linear.RealMatrix;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<Taski> taskiList;

    private RealMatrix nowMatrix;
    private List<UpRows> upRowsList = new ArrayList<UpRows>();

    public TaskManager(int countTask, RealMatrix nowMatrix) {
        this.taskiList = new ArrayList<Taski>();

        this.nowMatrix = nowMatrix;

        int countDevideOnTask =  (int)Math.round(Math.sqrt(countTask));

//        if ((countTask % 2) > 0){
//            countDevideOnTask++;
//        }

        double countDevideMatrix = nowMatrix.getRowDimension() / (countDevideOnTask);
        List<Integer> needRowUp = new ArrayList<Integer>();
        for (int i=0, j=0; i<nowMatrix.getRowDimension(); i++){
            if (countDevideMatrix > j) {
                j++;
            }else{
                j=0;
                this.upRowsList.add(new UpRows(needRowUp));
                needRowUp = new ArrayList<Integer>();

            }
            needRowUp.add(i);
        }
        this.upRowsList.add(new UpRows(needRowUp));

        for (int i=0; i<countTask; i++){
            taskiList.add(
                    new Taski(
                            this.upRowsList.get((int)Math.sqrt(i/countDevideOnTask)), nowMatrix)
            );
        }
    }

    private void goTaski(){
        for (Taski taski: this.taskiList){
            taski.run();
        }
    }

    public RealMatrix calculateTrapecZero(){

        this.goTaski();

        boolean flagReady = true;
        while (flagReady){
            flagReady = false;
            for (Taski taski: taskiList){
                if (taski.isAlive()){
                    flagReady = true;
                }
            }
        }
        return this.nowMatrix;
    }


}
