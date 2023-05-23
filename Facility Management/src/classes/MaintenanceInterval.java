package classes;

import java.time.Period;

public class MaintenanceInterval {
    private Period interval;

    public MaintenanceInterval(Period interval) {
        this.interval = interval;
    }

    public Period getInterval() {
        return interval;
    }

    public void setInterval(Period interval) {
        this.interval = interval;
    }

    public String toString() {
        return "Maintenance Interval: " + interval.toString();
    }
}
