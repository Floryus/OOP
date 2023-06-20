package test;

import classes.Employee;
import enums.GroupEnum;

public class TestEmployee {
    public static void testEmployeeMethods() {
        Employee employee = new Employee("John Doe", GroupEnum.CLEANING);

        // Test getName() method
        try {
            String name = employee.getName();
            if (!"John Doe".equals(name)) {
                throw new Error("getName() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test getId() method
        try {
            int id = employee.getId();
            if (id != 7) {
                throw new Error("getId() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test getGroup() method
        try {
            GroupEnum group = employee.getGroup();
            if (group != GroupEnum.CLEANING) {
                throw new Error("getGroup() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test toString() method
        try {
            String expectedToString = "7 John Doe";
            String actualToString = employee.toString();
            if (!expectedToString.equals(actualToString)) {
                throw new Error("toString() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test compareTo() method
        try {
            Employee otherEmployee = new Employee("Jane Smith", GroupEnum.CLEANING);
            int compareToResult = employee.compareTo(otherEmployee);
            if (compareToResult < 0) {
                throw new Error("compareTo() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
