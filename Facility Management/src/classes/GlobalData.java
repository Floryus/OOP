package classes;

import java.util.ArrayList;

import classes.verwaltungsklassen.BuildingVerwaltung;
import classes.verwaltungsklassen.EmployeeVerwaltung;
import classes.verwaltungsklassen.TaskVerwaltung;
import classes.verwaltungsklassen.TicketVerwaltung;
import enums.GroupEnum;
import enums.PriorityEnum;

/***
 * Diese Klasse ist eine Art Datenbank, in der alle Daten gespeichert werden.
 * Sie ist das zentrale Schaltwerk für alle Klassen, welche von vielen Orten der
 * Anwendung genutzt werden aber nur einmal im gesamten Programm existieren
 * sollen.
 * 
 * @author Florian Schmidt
 * 
 * @version 1.0
 */

/**
 * Die Klasse GlobalData stellt statische Methoden und Daten für den Zugriff auf verschiedene Verwaltungen bereit.
 */
public class GlobalData {

    private static BuildingVerwaltung buildingVerwaltung = new BuildingVerwaltung();
    private static TicketVerwaltung ticketVerwaltung = new TicketVerwaltung();
    private static TaskVerwaltung taskVerwaltung = new TaskVerwaltung();
    private static EmployeeVerwaltung employeeVerwaltung = new EmployeeVerwaltung();

    /**
     * Gibt eine Liste der vorhandenen Gebäude zurück.
     *
     * @return Eine ArrayList mit den vorhandenen Gebäuden.
     */
    public static ArrayList<Building> getBuildings() {
        return buildingVerwaltung.getBuildings();
    }

    /**
     * Gibt eine Liste der vorhandenen Tickets zurück.
     *
     * @return Eine ArrayList mit den vorhandenen Tickets.
     */
    public static ArrayList<Ticket> getTickets() {
        return ticketVerwaltung.getTickets();
    }

    /**
     * Erzeugt ein neues Ticket mit den angegebenen Informationen und fügt es der Ticket-Verwaltung hinzu.
     *
     * @param title       Der Titel des Tickets.
     * @param description Die Beschreibung des Tickets.
     * @param prio        Die Priorität des Tickets.
     * @param item        Das Objekt, auf das sich das Ticket bezieht.
     * @param group       Die Gruppe, der das Ticket zugeordnet ist.
     * @return Das erstellte Ticket.
     */
    public static Ticket addTicket(String title, String description, PriorityEnum prio, Maintainable item,
                                   GroupEnum group) {
        Ticket ticket = new Ticket(title, description, prio, null, item, group);
        ticketVerwaltung.addTicket(ticket);
        return ticket;
    }

    /**
     * Erzeugt ein neues Gebäude mit den angegebenen Informationen und fügt es der Building-Verwaltung hinzu.
     *
     * @param name              Der Name des Gebäudes.
     * @param maxLevels         Die maximale Anzahl von Etagen im Gebäude.
     * @param address           Die Adresse des Gebäudes.
     * @param employeeCount     Die Anzahl der Mitarbeiter im Gebäude.
     * @param constructionYear  Das Baujahr des Gebäudes.
     * @param parkingSpaces     Die Anzahl der Parkplätze am Gebäude.
     * @return Das erstellte Gebäude.
     */
    public static Building createBuilding(String name, int maxLevels, Address address, int employeeCount,
                                          int constructionYear, int parkingSpaces) {
        Building building = new Building(name, maxLevels, address, employeeCount, constructionYear, parkingSpaces);

        addBuilding(building);
        return building;
    }

    /**
     * Löscht das angegebene Gebäude aus der Building-Verwaltung.
     *
     * @param building Das zu löschende Gebäude.
     */
    public static void deleteBuilding(Building building) {
        GlobalData.buildingVerwaltung.removeBuilding(building);
    }

    private static void addBuilding(Building building) {
        GlobalData.buildingVerwaltung.addBuilding(building);
    }

    /**
     * Gibt eine Liste der vorhandenen Mitarbeiter zurück.
     *
     * @return Eine ArrayList mit den vorhandenen Mitarbeitern.
     */
    public static ArrayList<Employee> getEmployees() {
        return employeeVerwaltung.getEmployees();
    }

    /**
     * Erzeugt einen neuen Mitarbeiter mit dem angegebenen Namen und der Gruppe und fügt ihn der Employee-Verwaltung hinzu.
     *
     * @param name  Der Name des Mitarbeiters.
     * @param group Die Gruppe, zu der der Mitarbeiter gehört.
     * @return Der erstellte Mitarbeiter.
     */
    public static Employee addEmployee(String name, GroupEnum group) {
        Employee employee = new Employee(name, group);
        employeeVerwaltung.addEmployee(employee);
        return employee;
    }

    /**
     * Erzeugt eine neue Aufgabe mit den angegebenen Informationen und fügt sie der Task-Verwaltung hinzu.
     *
     * @param title               Der Titel der Aufgabe.
     * @param description         Die Beschreibung der Aufgabe.
     * @param prio                Die Priorität der Aufgabe.
     * @param maintenanceInterval Das Wartungsintervall der Aufgabe.
     * @return Die erstellte Aufgabe.
     */
    public static Task createTask(String title, String description, PriorityEnum prio, int maintenanceInterval) {
        Task task = new Task(title, description, prio, maintenanceInterval);
        taskVerwaltung.addTask(task);
        return task;
    }

    /**
     * Gibt eine textuelle Repräsentation der GlobalData-Daten zurück.
     *
     * @return Eine textuelle Repräsentation der GlobalData-Daten.
     */
    public String toString() {
        String message = "Buildings:\n";
        for (Building building : buildingVerwaltung.getBuildings()) {
            message += building.getName() + "\n";
        }
        message += "\nTickets:\n";
        for (Ticket ticket : ticketVerwaltung.getTickets()) {
            message += ticket.getTitle();
        }
        return message;
    }

}
