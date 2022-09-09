package ss4_oop.bai_tap.stop_watch;

import java.util.Date;

public class StopWatch {
    private long startTime;
    private long endTime = new Date().getTime();

    public StopWatch() {
        startTime = new Date().getTime();
    }

    public void Start() {
        startTime = new Date().getTime();
    }

    public void End() {
        endTime = new Date().getTime();
    }

    public long getElapsedTime() {
        return endTime - startTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }


}
