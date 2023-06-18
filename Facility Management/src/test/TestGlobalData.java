package test;

import classes.Address;
import classes.Building;
import classes.GlobalData;
import classes.Ticket;
import enums.GroupEnum;
import enums.PriorityEnum;

public class TestGlobalData {
    public static void testGlobalDataMethods() {
        // Create test objects
        Address address = new Address("Street", 123, 12345, "City");
        Building building = GlobalData.createBuilding("Building A", 5, address, 100, 2020, 50);
        PriorityEnum priority = PriorityEnum.HIGH;
        GroupEnum group = GroupEnum.CLEANING;
        String title = "Ticket A";
        String description = "Ticket A Description";

        // Test getBuildings() method
        if (!GlobalData.getBuildings().contains(building)) {
            System.err.println("getBuildings() method failed!");
        }

        // Test getTickets() method
        if (!GlobalData.getTickets().isEmpty()) {
            System.err.println("getTickets() method failed!");
        }

        // Test addTicket() method
        Ticket ticket = GlobalData.addTicket(title, description, priority, building, group);
        if (!GlobalData.getTickets().contains(ticket)) {
            System.err.println("addTicket() method failed!");
        }

        // Test deleteBuilding() method
        GlobalData.deleteBuilding(building);
        if (GlobalData.getBuildings().contains(building)) {
            System.err.println("deleteBuilding() method failed!");
        }

        // // Test createTask() method
        // int maintenanceInterval = 12;
        // GlobalData.createTask("Task A", "Task A Description", priority,
        // maintenanceInterval);
        // if (GlobalData.getTasks().isEmpty()) {
        // System.err.println("createTask() method failed!");
        // }

        // // Test toString() method
        // String expectedToString = "Buildings:\n" +
        // "Building A\n" +
        // "\n" +
        // "Tickets:\n" +
        // "Ticket A";
        // String actualToString = GlobalData.toString();
        // if (!expectedToString.equals(actualToString)) {
        // System.err.println("toString() method failed!");
        // }
    }
}
