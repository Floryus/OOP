package classes;

import java.util.GregorianCalendar;

import enums.PriorityEnum;

public class Task extends Todo {

private int maintenanceInterval;
private GregorianCalendar nextMaintenance;
private GregorianCalendar lastMaintenance;

public Task(String title, String description, PriorityEnum prio, int maintenanceInterval){
    super(title, description, prio);
    this.maintenanceInterval = maintenanceInterval;
    nextMaintenance.add(GregorianCalendar.MONTH, maintenanceInterval);
}

public GregorianCalendar getNextMaintenance(){
    return nextMaintenance;
}

public GregorianCalendar getLastMaintenance(){
    return lastMaintenance;
}

public void setMaintenanceInterval(int maintenanceInterval){
    this.maintenanceInterval = maintenanceInterval;
    nextMaintenance.add(GregorianCalendar.MONTH, maintenanceInterval);
}

public int getMaintenanceInterval(){
    return maintenanceInterval;
}
    
}
