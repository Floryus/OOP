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

public class GlobalData {

    private static BuildingVerwaltung buildingVerwaltung = new BuildingVerwaltung();
    private static TicketVerwaltung ticketVerwaltung = new TicketVerwaltung();
    private static TaskVerwaltung taskVerwaltung = new TaskVerwaltung();
    private static EmployeeVerwaltung employeeVerwaltung = new EmployeeVerwaltung();

    /**
     * @return ArrayList<Building>
     */
    public static ArrayList<Building> getBuildings() {
        return buildingVerwaltung.getBuildings();
    }

    public static ArrayList<Ticket> getTickets() {
        return ticketVerwaltung.getTickets();
    }

    public static Ticket addTicket(String title, String description, PriorityEnum prio, Maintainable item,
            GroupEnum group) {
        Ticket ticket = new Ticket(title, description, prio, null, item, group);
        ticketVerwaltung.addTicket(ticket);
        return ticket;
    }

    public static Building createBuilding(String name, int maxLevels, Address address, int employeeCount,
            int constructionYear, int parkingSpaces) {
        Building building = new Building(name, maxLevels, address, employeeCount, constructionYear, parkingSpaces);

        addBuilding(building);
        return building;
    }

    public static void deleteBuilding(Building building) {
        GlobalData.buildingVerwaltung.removeBuilding(building);
    }

    private static void addBuilding(Building building) {
        GlobalData.buildingVerwaltung.addBuilding(building);
    }

    public static ArrayList<Employee> getEmployees() {
        return employeeVerwaltung.getEmployees();
    }

    public static Employee addEmployee(String name, GroupEnum group) {
        Employee employee = new Employee(name, group);
        employeeVerwaltung.addEmployee(employee);
        return employee;
    }

    public static Task createTask(String title, String description, PriorityEnum prio, int maintenanceInterval) {
        Task task = new Task(title, description, prio, maintenanceInterval);
        taskVerwaltung.addTask(task);
        return task;
    }

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
