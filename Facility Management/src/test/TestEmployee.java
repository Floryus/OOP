package test;

import classes.Employee;
import enums.GroupEnum;

public class TestEmployee {
    public static void testEmployeeMethods() {
        Employee employee = new Employee("John Doe", GroupEnum.CLEANING);

        // Test getName() method
        if (!"John Doe".equals(employee.getName())) {
            System.err.println("getName() method failed!");
        }

        // Test getId() method
        if (!"12345".equals(employee.getId())) {
            System.err.println("getId() method failed!");
        }

        // Test getGroup() method
        if (GroupEnum.CLEANING != employee.getGroup()) {
            System.err.println("getGroup() method failed!");
        }

        String expectedToString = "John Doe as ADMIN with tasks\n" +
                "Task 1\n" +
                "Task 2\n";
        String actualToString = employee.toString();
        if (!expectedToString.equals(actualToString)) {
            System.err.println("toString() method failed!");
        }

        // Test compareTo() method
        Employee otherEmployee = new Employee("Jane Smith", GroupEnum.CLEANING);
        int compareToResult = employee.compareTo(otherEmployee);
        if (compareToResult <= 0) {
            System.err.println("compareTo() method failed!");
        }
    }
}
