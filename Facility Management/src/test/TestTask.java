package test;

import classes.Task;
import enums.PriorityEnum;

import java.util.GregorianCalendar;

public class TestTask {
    public static void testTaskMethods() {
        // Create test objects
        String title = "Task 1";
        String description = "Perform maintenance";
        PriorityEnum priority = PriorityEnum.HIGH;
        int maintenanceInterval = 6;
        Task task = new Task(title, description, priority, maintenanceInterval);

        // Test getTitle() method
        String taskTitle = task.getTitle();
        if (!taskTitle.equals(title)) {
            System.err.println("getTitle() method failed!");
        }

        // Test getDescription() method
        String taskDescription = task.getDescription();
        if (!taskDescription.equals(description)) {
            System.err.println("getDescription() method failed!");
        }

        // Test getPriority() method
        PriorityEnum taskPriority = task.getPriority();
        if (taskPriority != priority) {
            System.err.println("getPriority() method failed!");
        }

        // Test getMaintenanceInterval() method
        int taskMaintenanceInterval = task.getMaintenanceInterval();
        if (taskMaintenanceInterval != maintenanceInterval) {
            System.err.println("getMaintenanceInterval() method failed!");
        }

        // Test getNextMaintenance() method
        GregorianCalendar nextMaintenance = task.getNextMaintenance();
        GregorianCalendar expectedNextMaintenance = new GregorianCalendar();
        expectedNextMaintenance.add(GregorianCalendar.MONTH, maintenanceInterval);
        if (!nextMaintenance.equals(expectedNextMaintenance)) {
            System.err.println("getNextMaintenance() method failed!");
        }

        // Test getLastMaintenance() method
        GregorianCalendar lastMaintenance = task.getLastMaintenance();
        if (lastMaintenance != null) {
            System.err.println("getLastMaintenance() method failed!");
        }

        // Test setMaintenanceInterval() method
        int newMaintenanceInterval = 12;
        task.setMaintenanceInterval(newMaintenanceInterval);
        int updatedMaintenanceInterval = task.getMaintenanceInterval();
        if (updatedMaintenanceInterval != newMaintenanceInterval) {
            System.err.println("setMaintenanceInterval() method failed!");
        }

        // Test getNextMaintenance() method after updating maintenance interval
        GregorianCalendar updatedNextMaintenance = task.getNextMaintenance();
        GregorianCalendar expectedUpdatedNextMaintenance = new GregorianCalendar();
        expectedUpdatedNextMaintenance.add(GregorianCalendar.MONTH, newMaintenanceInterval);
        if (!updatedNextMaintenance.equals(expectedUpdatedNextMaintenance)) {
            System.err.println("getNextMaintenance() method failed after updating maintenance interval!");
        }
    }
}
