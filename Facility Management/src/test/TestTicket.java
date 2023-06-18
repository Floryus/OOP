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
        String ticketTitle = ticket.getTitle();
        if (!ticketTitle.equals(title)) {
            System.err.println("getTitle() method failed!");
        }

        // Test getDescription() method
        String ticketDescription = ticket.getDescription();
        if (!ticketDescription.equals(description)) {
            System.err.println("getDescription() method failed!");
        }

        // Test getGroup() method
        GroupEnum ticketGroup = ticket.getGroup();
        if (ticketGroup != group) {
            System.err.println("getGroup() method failed!");
        }

        // Test getPrio() method
        PriorityEnum ticketPriority = ticket.getPrio();
        if (ticketPriority != priority) {
            System.err.println("getPrio() method failed!");
        }

        // Test updateStatus() method
        StatusEnum initialStatus = ticket.getStatus();
        ticket.updateStatus();
        StatusEnum updatedStatus = ticket.getStatus();
        if (updatedStatus != initialStatus.getNextStatus()) {
            System.err.println("updateStatus() method failed!");
        }
    }
}
