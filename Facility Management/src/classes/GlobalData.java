package classes;

import java.util.ArrayList;

import enums.GroupEnum;
import enums.PriorityEnum;
import ticketSystem.Ticket;

public class GlobalData {

    String name;
    private static ArrayList<Building> buildings = new ArrayList<>();
    private static ArrayList<Ticket> tickets = new ArrayList<>();
    private static ArrayList<Task> tasks = new ArrayList<>();

    public GlobalData(String name) {
        this.name = name;
    }

    public static ArrayList<Building> getBuildings() {
        return buildings;
    }

    public static ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public static Ticket addTicket(String title, String description, PriorityEnum prio, maintainable item,
            GroupEnum group) {
        Ticket ticket = new Ticket(title, description, prio, null, item, group);
        tickets.add(ticket);
        return ticket;
    }

    public static Building createBuilding(String name, int maxLevels, String address) {
        Building building = new Building(name, maxLevels, address);
        buildings.add(building);
        return building;
    }

    public static Task createTask(String title, String description, PriorityEnum prio, int maintenanceInterval){
        Task task = new Task(title, description, prio,maintenanceInterval);
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
