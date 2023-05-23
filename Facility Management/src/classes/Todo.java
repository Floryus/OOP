package classes;

import enums.PriorityEnum;

public abstract class Todo {
    PriorityEnum prio;
    String ID;
    Employee resp;


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
}
