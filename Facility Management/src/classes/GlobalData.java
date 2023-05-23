package classes;

import java.util.ArrayList;

import enums.GroupEnum;
import enums.PriorityEnum;
import ticketSystem.Ticket;

public class GlobalData {

    private static ArrayList<Building> buildings = new ArrayList<>();
    private static ArrayList<Ticket> tickets = new ArrayList<>();
    private static ArrayList<Task> tasks = new ArrayList<>();

    public static ArrayList<Building> getBuildings() {
        return buildings;
    }

    public static ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public static Ticket addTicket(String title, String description, PriorityEnum prio, Maintainable item,
            GroupEnum group) {
        Ticket ticket = new Ticket(title, description, prio, null, item, group);
        tickets.add(ticket);
        return ticket;
    }

    public static Building createBuilding(String name, int maxLevels, Address address, int employeeCount,
            int constructionYear, int parkingSpaces) {
        Building building = new Building(name, maxLevels, address, employeeCount, constructionYear, parkingSpaces);

        addBuilding(building);
        return building;
    }

    public static void deleteBuilding(Building building) {
        GlobalData.buildings.remove(building);
    }

    private static void addBuilding(Building building) {
        buildings.add(building);
    }

    public static Task createTask(String title, String description, PriorityEnum prio, int maintenanceInterval) {
        Task task = new Task(title, description, prio, maintenanceInterval);
        tasks.add(task);
        return task;
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
