package classes;

import java.util.ArrayList;

import enums.GroupEnum;
import enums.PriorityEnum;
import ticketSystem.Ticket;

public class GlobalData {

    String name;
    private static ArrayList<Building> buildings = new ArrayList<>();
    private static ArrayList<Ticket> tickets = new ArrayList<>();
    private static ArrayList<Employee> employees = new ArrayList<>();

    public GlobalData(String name) {
        this.name = name;
    }

    public static ArrayList<Building> getBuildings() {
        return buildings;
    }

    public static ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public static ArrayList<Employee> getEmployees() {
        return employees;
    }

    public static Employee addEmployee(String name, GroupEnum group, String id) {
        Employee employee = new Employee(name, group, id);
        employees.add(employee);
        return employee;
    }

    public static Ticket addTicket(String title, String description, PriorityEnum prio, maintainable item,
            GroupEnum group) {
        Ticket ticket = new Ticket(title, description, prio, item, group);
        tickets.add(ticket);
        return ticket;
    }

    public static Building createBuilding(String name, int maxLevels, String address) {
        Building building = new Building(name, maxLevels, address);
        addBuilding(building);
        return building;
    }

    private static void addBuilding(Building building) {
        buildings.add(building);
    }

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
