package classes;

import java.util.GregorianCalendar;

import enums.PriorityEnum;

/**
 * Die Klasse Task erbt von der Klasse Todo und repräsentiert eine Aufgabe mit Wartungsaspekt.
 */
public class Task extends Todo {
    private int maintenanceInterval;
    private GregorianCalendar nextMaintenance;
    private GregorianCalendar lastMaintenance;

    /**
     * Konstruktor der Task-Klasse.
     *
     * @param title              Der Titel der Aufgabe.
     * @param description        Die Beschreibung der Aufgabe.
     * @param prio               Die Priorität der Aufgabe.
     * @param maintenanceInterval Das Wartungsintervall der Aufgabe in Monaten.
     */
    public Task(String title, String description, PriorityEnum prio, int maintenanceInterval) {
        super(title, description, prio);
        this.maintenanceInterval = maintenanceInterval;
        this.nextMaintenance = new GregorianCalendar();
        this.nextMaintenance.add(GregorianCalendar.MONTH, maintenanceInterval);
    }

    /**
     * Gibt das Datum der nächsten Wartung für die Aufgabe zurück.
     *
     * @return Das Datum der nächsten Wartung als GregorianCalendar-Objekt.
     */
    public GregorianCalendar getNextMaintenance() {
        return nextMaintenance;
    }

    /**
     * Gibt das Datum der letzten Wartung für die Aufgabe zurück.
     *
     * @return Das Datum der letzten Wartung als GregorianCalendar-Objekt.
     */
    public GregorianCalendar getLastMaintenance() {
        return lastMaintenance;
    }

    /**
     * Setzt das Wartungsintervall der Aufgabe.
     * Aktualisiert das Datum der nächsten Wartung entsprechend.
     *
     * @param maintenanceInterval Das Wartungsintervall der Aufgabe in Monaten.
     */
    public void setMaintenanceInterval(int maintenanceInterval) {
        this.maintenanceInterval = maintenanceInterval;
        this.nextMaintenance = new GregorianCalendar();
        this.nextMaintenance.add(GregorianCalendar.MONTH, maintenanceInterval);
    }

    /**
     * Gibt das Wartungsintervall der Aufgabe zurück.
     *
     * @return Das Wartungsintervall der Aufgabe in Monaten.
     */
    public int getMaintenanceInterval() {
        return maintenanceInterval;
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
     * Gibt die Priorität der Aufgabe zurück.
     *
     * @return Die Priorität der Aufgabe.
     */
    public PriorityEnum getPriority() {
        return prio;
    }
}
