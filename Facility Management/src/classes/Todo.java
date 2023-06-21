package classes;

import java.util.GregorianCalendar;

import enums.PriorityEnum;
import enums.StatusEnum;

/**
 * Die abstrakte Klasse Todo stellt eine Basisklasse für Aufgaben dar.
 */
public abstract class Todo {
    protected String title;
    protected String description;
    protected final GregorianCalendar CREATIONDATE;
    protected String id;
    protected Employee resp;
    protected PriorityEnum prio;
    protected GregorianCalendar dueDate;
    protected boolean isArchived;
    protected StatusEnum status;

    /**
     * Konstruktor der Todo-Klasse.
     *
     * @param title      Der Titel der Aufgabe.
     * @param description        Die Beschreibung der Aufgabe.
     * @param prio       Die Priorität der Aufgabe.
     */
    public Todo(String title, String description, PriorityEnum prio) {
        this.CREATIONDATE = new GregorianCalendar();
        this.isArchived = false;
        this.status = StatusEnum.OPEN;
        this.title = title;
        this.description = description;
        this.prio = prio;
    }

    /**
     * Gibt den Titel der Aufgabe zurück.
     *
     * @return Der Titel der Aufgabe.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gibt die Beschreibung der Aufgabe zurück.
     *
     * @return Die Beschreibung der Aufgabe.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gibt das Erstellungsdatum der Aufgabe zurück.
     *
     * @return Das Erstellungsdatum der Aufgabe.
     */
    public GregorianCalendar getCreationDate() {
        return CREATIONDATE;
    }

    /**
     * Gibt die ID der Aufgabe zurück.
     *
     * @return Die ID der Aufgabe.
     */
    public String getId() {
        return id;
    }

    /**
     * Gibt die Priorität der Aufgabe zurück.
     *
     * @return Die Priorität der Aufgabe.
     */
    public PriorityEnum getPriority() {
        return prio;
    }

    /**
     * Gibt das Fälligkeitsdatum der Aufgabe zurück.
     *
     * @return Das Fälligkeitsdatum der Aufgabe.
     */
    public GregorianCalendar getDueDate() {
        return dueDate;
    }

    /**
     * Gibt den zugeordneten Mitarbeiter der Aufgabe zurück.
     *
     * @return Der zugeordnete Mitarbeiter der Aufgabe.
     */
    public Employee getResp() {
        return resp;
    }

    /**
     * Überprüft, ob der Aufgabe bereits ein Mitarbeiter zugeordnet ist.
     *
     * @return true, wenn der Aufgabe ein Mitarbeiter zugeordnet ist, ansonsten false.
     */
    public boolean isRespSet() {
        return resp != null;
    }

    /**
     * Weist der Aufgabe einen Mitarbeiter zu.
     *
     * @param respEmp Der Mitarbeiter, der der Aufgabe zugewiesen werden soll.
     */
    public void setResp(Employee respEmp) {
        resp = respEmp;
    }

    /**
     * Entfernt den zugewiesenen Mitarbeiter von der Aufgabe.
     */
    public void removeResp() {
        resp = null;
    }
}
