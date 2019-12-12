package vsu.com.controller;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<Taski> taskiList = new ArrayList<Taski>();

    private List<PointTaski> pointTaskiList = new ArrayList<PointTaski>();


    public TaskManager(int countTask) {
        for (int i = 0; i < countTask; i++){
            this.taskiList.add(new Taski(i, countTask, this));
        }
    }

    public void goTaski(){
        for (Taski taski: this.taskiList){
            taski.run();
        }
    }

    protected void addPointTaski(PointTaski pointTaski){
        this.pointTaskiList.add(pointTaski);
    }

    public List<PointTaski> getPointTaskiList() {
        return pointTaskiList;
    }
}
