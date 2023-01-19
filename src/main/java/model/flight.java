package model;


public class flight {
    private int dayOfWeek;
    private int depTime;
    private int depDelay;
    private int arrTime;
    private int arrDelay;
    private int cancelled;
    private int diverted;
    private int airTime;
    private int distance;

    public flight(int dayOfWeek, int depTime, int depDelay, int arrTime, int arrDelay, int cancelled, int diverted, int airTime, int distance) {
        this.dayOfWeek = dayOfWeek;
        this.depTime = depTime;
        this.depDelay = depDelay;
        this.arrTime = arrTime;
        this.arrDelay = arrDelay;
        this.cancelled = cancelled;
        this.diverted = diverted;
        this.airTime = airTime;
        this.distance = distance;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public void setDepTime(int depTime) {
        this.depTime = depTime;
    }

    public void setDepDelay(int depDelay) {
        this.depDelay = depDelay;
    }

    public void setArrTime(int arrTime) {
        this.arrTime = arrTime;
    }

    public void setArrDelay(int arrDelay) {
        this.arrDelay = arrDelay;
    }

    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }

    public void setDiverted(int diverted) {
        this.diverted = diverted;
    }

    public void setAirTime(int airTime) {
        this.airTime = airTime;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public int getDepTime() {
        return depTime;
    }

    public int getDepDelay() {
        return depDelay;
    }

    public int getArrTime() {
        return arrTime;
    }

    public int getArrDelay() {
        return arrDelay;
    }

    public int getCancelled() {
        return cancelled;
    }

    public int getDiverted() {
        return diverted;
    }

    public int getAirTime() {
        return airTime;
    }

    public int getDistance() {
        return distance;
    }
}