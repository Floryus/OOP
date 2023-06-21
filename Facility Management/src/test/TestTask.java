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
        try {
            String taskTitle = task.getTitle();
            if (!taskTitle.equals(title)) {
                throw new Error("getTitle() method failed!");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // Test getDescription() method
        try {
            String taskDescription = task.getDescription();
            if (!taskDescription.equals(description)) {
                throw new Error("getDescription() method failed!");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // Test getPriority() method
        try {
            PriorityEnum taskPriority = task.getPriority();
            if (taskPriority != priority) {
                throw new Error("getPriority() method failed!");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // Test getMaintenanceInterval() method
        try {
            int taskMaintenanceInterval = task.getMaintenanceInterval();
            if (taskMaintenanceInterval != maintenanceInterval) {
                throw new Error("getMaintenanceInterval() method failed!");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // Test getNextMaintenance() method
        try {
            GregorianCalendar nextMaintenance = task.getNextMaintenance();
            GregorianCalendar expectedNextMaintenance = new GregorianCalendar();
            expectedNextMaintenance.add(GregorianCalendar.MONTH, maintenanceInterval);
            if (!nextMaintenance.equals(expectedNextMaintenance)) {
                throw new Error("getNextMaintenance() method failed!");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // Test getLastMaintenance() method
        try {
            GregorianCalendar lastMaintenance = task.getLastMaintenance();
            if (lastMaintenance != null) {
                throw new Error("getLastMaintenance() method failed!");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // Test setMaintenanceInterval() method
        try {
            int newMaintenanceInterval = 12;
            task.setMaintenanceInterval(newMaintenanceInterval);
            int updatedMaintenanceInterval = task.getMaintenanceInterval();
            if (updatedMaintenanceInterval != newMaintenanceInterval) {
                throw new Error("setMaintenanceInterval() method failed!");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // Test getNextMaintenance() method after updating maintenance interval
        try {
            GregorianCalendar updatedNextMaintenance = task.getNextMaintenance();
            GregorianCalendar expectedUpdatedNextMaintenance = new GregorianCalendar();
            expectedUpdatedNextMaintenance.add(GregorianCalendar.MONTH, task.getMaintenanceInterval());
            if (!updatedNextMaintenance.equals(expectedUpdatedNextMaintenance)) {
                throw new Error("getNextMaintenance() method failed after updating maintenance interval!");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
