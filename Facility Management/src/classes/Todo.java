package classes;

import enums.PriorityEnum;

/**
 * Die abstrakte Klasse Todo stellt eine Aufgabe in der Facility Management Software dar.
 * Sie definiert Eigenschaften und Methoden, um die Zuweisung der Aufgabe an einen Mitarbeiter zu verwalten.
 */
public abstract class Todo {
    PriorityEnum prio;
    String ID;
    Employee resp;

    /**
     * Gibt den Mitarbeiter zurück, dem die Aufgabe zugewiesen wurde.
     *
     * @return Der Mitarbeiter, dem die Aufgabe zugewiesen wurde.
     */
    public Employee getResp() {
        return resp; 
    }

    /**
     * Überprüft, ob die Aufgabe bereits einem Mitarbeiter zugewiesen wurde.
     *
     * @return true, wenn die Aufgabe einem Mitarbeiter zugewiesen wurde, andernfalls false.
     */
    public boolean isRespSet() {
        return resp != null;
    }

    /**
     * Weist die Aufgabe einem Mitarbeiter zu.
     *
     * @param respEmp Der Mitarbeiter, dem die Aufgabe zugewiesen werden soll.
     */
    public void setResp(Employee respEmp) {
        resp = respEmp;
    }

    /**
     * Entfernt die Zuweisung der Aufgabe von einem Mitarbeiter.
     */
    public void removeResp() {
        resp = null;
    }
}
