package entities;

public class TimeSlot {
    String startTime;
    String endTime;

    public TimeSlot(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public String getendTime() {
        return this.endTime;
    }

    public void setStartTime(String startString) {
        this.startTime = startTime;
    }

    public void setEndTime(String endString) {
        this.endTime = endTime;
    }

    public String setStartTime() {
        return startTime;
    }

    public String setEndTime() {
        return endTime;
    }
}
