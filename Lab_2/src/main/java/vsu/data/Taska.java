package vsu.data;

public class Taska extends Thread  {

    private int id;

    private boolean ready = true;

    private PointFunc pointFunc;

    private int accuracy;

    public Taska(int id, int accuracy) {
        this.id = id;
        this.accuracy = accuracy;
    }

    public void setPointFunc(PointFunc pointFunc) {
        this.setReady(false);
        this.pointFunc = pointFunc;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public void run() {
        pointFunc.setValue(SomeFunction.value(this.pointFunc.getPoint(), this.accuracy));
        this.setReady(true);

    }


}
