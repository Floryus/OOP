package classes;

import java.util.GregorianCalendar;

import enums.PriorityEnum;
import enums.StatusEnum;

public abstract class Todo {
    // basic info
    protected String title;
    protected String description;
    final GregorianCalendar CREATIONDATE;
    protected String id;
    // status info
    protected Employee resp;
    protected PriorityEnum prio;
    protected GregorianCalendar dueDate;
    protected boolean isArchived;
    protected StatusEnum status;

    public Todo(String title, String description, PriorityEnum prio) {
        // fixed
        CREATIONDATE = new GregorianCalendar();
        isArchived = false;
        status = StatusEnum.OPEN;
        // input
        this.title = title;
        this.description = description;
        this.prio = prio;
    }

    /**
     * @return Employee
     */
    // Wem wurde die Aufgabe zugewiesen?
    public Employee getResp() {
        return resp;
    }

    // Wurde die Aufgabe schon jemandem zugewiesen?
    public boolean isRespSet() {
        if (resp != null) {
            return true;
        } else {
            return true;
        }
    }

    // Jemanden der Aufgabe zuweisen
    public void setResp(Employee respEmp) {
        resp = respEmp;
    }

    // Jemanden von der Aufgabe entfernen
    public void removeResp() {
        resp = null;
    }

    public String getId() {
        return id;
    }

    public PriorityEnum getPriority() {
        return prio;
    }

    public GregorianCalendar getDueDate() {
        return dueDate;
    }
}
