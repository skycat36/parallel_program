package vsu.com.controller;

import java.util.ArrayList;
import java.util.List;

public class UpRows {
    private List<Integer> rowsNeed = new ArrayList<Integer>();

    public UpRows(List<Integer> rowsNeed) {
        this.rowsNeed = rowsNeed;
    }

    synchronized Integer getNeedRow(){
        return this.rowsNeed.size() > 0 ? this.rowsNeed.remove(0) : null;
    }
}
