package classes;

import java.util.ArrayList;

import enums.GroupEnum;
import enums.PriorityEnum;
import ticketSystem.Ticket;

/**
 * Die Klasse GlobalData stellt globale Daten und Funktionen für die Facility Management Software bereit.
 * Sie enthält statische Methoden zum Abrufen und Hinzufügen von Gebäuden, Tickets und Mitarbeitern.
 */
public class GlobalData {

    String name;
    private static ArrayList<Building> buildings = new ArrayList<>();
    private static ArrayList<Ticket> tickets = new ArrayList<>();
    private static ArrayList<Employee> employees = new ArrayList<>();

    /**
     * Konstruktor für die GlobalData-Klasse.
     *
     * @param name Der Name der globalen Daten.
     */
    public GlobalData(String name) {
        this.name = name;
    }

    /**
     * Gibt eine Liste aller Gebäude zurück.
     *
     * @return Eine Liste aller Gebäude.
     */
    public static ArrayList<Building> getBuildings() {
        return buildings;
    }

    /**
     * Gibt eine Liste aller Tickets zurück.
     *
     * @return Eine Liste aller Tickets.
     */
    public static ArrayList<Ticket> getTickets() {
        return tickets;
    }

    /**
     * Gibt eine Liste aller Mitarbeiter zurück.
     *
     * @return Eine Liste aller Mitarbeiter.
     */
    public static ArrayList<Employee> getEmployees() {
        return employees;
    }

    /**
     * Fügt einen neuen Mitarbeiter hinzu.
     *
     * @param name  Der Name des Mitarbeiters.
     * @param group Die Gruppe, der der Mitarbeiter angehört.
     * @param id    Die ID des Mitarbeiters.
     * @return Der hinzugefügte Mitarbeiter.
     */
    public static Employee addEmployee(String name, GroupEnum group, String id) {
        Employee employee = new Employee(name, group, id);
        employees.add(employee);
        return employee;
    }

    /**
     * Fügt ein neues Ticket hinzu.
     *
     * @param title       Der Titel des Tickets.
     * @param description Die Beschreibung des Tickets.
     * @param prio        Die Priorität des Tickets.
     * @param item        Das zugehörige Equipment oder Gebäude.
     * @param group       Die Gruppe, der das Ticket zugewiesen ist.
     * @return Das hinzugefügte Ticket.
     */
    public static Ticket addTicket(String title, String description, PriorityEnum prio, maintainable item,
                                   GroupEnum group) {
        Ticket ticket = new Ticket(title, description, prio, item, group);
        tickets.add(ticket);
        return ticket;
    }

    /**
     * Erstellt ein neues Gebäude.
     *
     * @param name       Der Name des Gebäudes.
     * @param maxLevels  Die maximale Anzahl von Ebenen im Gebäude.
     * @param address    Die Adresse des Gebäudes.
     * @return Das erstellte Gebäude.
     */
    public static Building createBuilding(String name, int maxLevels, String address) {
        Building building = new Building(name, maxLevels, address);
        addBuilding(building);
        return building;
    }

    /**
     * Fügt ein Gebäude zur Liste der Gebäude hinzu.
     *
     * @param building Das hinzuzufügende Gebäude.
     */
    private static void addBuilding(Building building) {
        buildings.add(building);
    }

    /**
     * Gibt eine Zeichenfolgendarstellung der globalen Daten zurück.
     *
     * @return Eine Zeichenfolgendarstellung der globalen Daten.
     */
    public String toString() {
        String message = "Buildings:\n";
        for (Building building : buildings) {
            message += building.getName() + "\n";
        }
        message += "\nTickets:\n";
        for (Ticket ticket : tickets) {
            message += ticket.getTitle();
        }
        return message;
    }

}
