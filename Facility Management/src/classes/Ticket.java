package classes;

import java.util.Arrays;
import java.util.GregorianCalendar;

import enums.GroupEnum;
import enums.PriorityEnum;
import enums.StatusEnum;

/**
 * Die Klasse Ticket erbt von der Klasse Todo und repräsentiert ein Ticket für eine Aufgabe.
 */
public class Ticket extends Todo implements Comparable<Ticket> {
    private GregorianCalendar dueDate;
    private Maintainable item;
    private GroupEnum group;
    private boolean isArchived;
    private StatusEnum status;

    /**
     * Konstruktor der Ticket-Klasse.
     *
     * @param title      Der Titel des Tickets.
     * @param description        Die Beschreibung des Tickets.
     * @param prio       Die Priorität des Tickets.
     * @param dueDate    Das Fälligkeitsdatum des Tickets.
     * @param item       Das zugehörige Maintainable-Objekt des Tickets.
     * @param group      Die Gruppe des Tickets.
     */
    public Ticket(String title, String description, PriorityEnum prio, GregorianCalendar dueDate, Maintainable item,
                  GroupEnum group) {
        super(title, description, prio);
        this.isArchived = false;
        this.status = StatusEnum.OPEN;
        this.dueDate = dueDate;
        this.item = item;
        this.group = group;
    }

    /**
     * Gibt den Titel des Tickets zurück.
     *
     * @return Der Titel des Tickets.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gibt die Beschreibung des Tickets zurück.
     *
     * @return Die Beschreibung des Tickets.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gibt die Gruppe des Tickets zurück.
     *
     * @return Die Gruppe des Tickets.
     */
    public GroupEnum getGroup() {
        return group;
    }

    /**
     * Gibt die Priorität des Tickets zurück.
     *
     * @return Die Priorität des Tickets.
     */
    public PriorityEnum getPrio() {
        return prio;
    }

    /**
     * Vergleicht dieses Ticket mit einem anderen Ticket.
     * Die Tickets werden nach ihrer Priorität sortiert.
     *
     * @param other Das andere Ticket, mit dem dieses Ticket verglichen wird.
     * @return Eine negative ganze Zahl, wenn dieses Ticket eine niedrigere Priorität hat als das andere Ticket,
     *         eine positive ganze Zahl, wenn dieses Ticket eine höhere Priorität hat als das andere Ticket,
     *         oder 0, wenn beide Tickets die gleiche Priorität haben.
     */
    @Override
    public int compareTo(Ticket other) {
        return this.prio.compareTo(other.prio);
    }

    /**
     * Gibt eine textuelle Repräsentation des Tickets zurück.
     *
     * @return Eine textuelle Repräsentation des Tickets.
     */
    public String toString() {
        return this.title + " is for " + this.group + " with prio " + this.prio;
    }

    /**
     * Aktualisiert den Status des Tickets.
     * Der Status wird zum nächsten Status in der Reihenfolge geändert.
     * Wenn der letzte Status erreicht ist, wird das Ticket archiviert.
     */
    public void updateStatus() {
        StatusEnum[] arr = StatusEnum.values();
        int curr = Arrays.asList(arr).indexOf(this.status);
        if (curr == arr.length - 1) {
            this.isArchived = true;
            return;
        }
        this.status = arr[curr + 1];
    }

    /**
     * Gibt den aktuellen Status des Tickets zurück.
     *
     * @return Der aktuelle Status des Tickets.
     */
    public StatusEnum getStatus() {
        return status;
    }
}
