package test;

import classes.Ticket;
import enums.GroupEnum;
import enums.PriorityEnum;
import enums.StatusEnum;

public class TestTicket {
    public static void testTicketMethods() {
        // Create test objects
        String title = "Ticket 1";
        String description = "Fix the issue";
        PriorityEnum priority = PriorityEnum.HIGH;
        GroupEnum group = GroupEnum.CLEANING;
        Ticket ticket = new Ticket(title, description, priority, null, null, group);

        // Test getTitle() method
        try {
            String ticketTitle = ticket.getTitle();
            if (!ticketTitle.equals(title)) {
                throw new Error("getTitle() method failed!");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // Test getDescription() method
        try {
            String ticketDescription = ticket.getDescription();
            if (!ticketDescription.equals(description)) {
                throw new Error("getDescription() method failed!");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // Test getGroup() method
        try {
            GroupEnum ticketGroup = ticket.getGroup();
            if (ticketGroup != group) {
                throw new Error("getGroup() method failed!");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // Test getPrio() method
        try {
            PriorityEnum ticketPriority = ticket.getPrio();
            if (ticketPriority != priority) {
                throw new Error("getPrio() method failed!");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
