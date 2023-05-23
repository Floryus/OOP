package classes;

import java.util.GregorianCalendar;

public class Task extends Todo {
    private GregorianCalendar date;
    private int interval;
    private GregorianCalendar nextMaintenance;
    
    public void createTask(int interval){
        super.init();
        this.date = new GregorianCalendar();
        this.nextMaintenance = new GregorianCalendar();
        this.interval = interval; 
        this.nextMaintenance.add(GregorianCalendar.MONTH, interval);
    }
}
