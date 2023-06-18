package classes.verwaltungsklassen;

import java.util.ArrayList;
import java.util.Collections;

import classes.Employee;
import enums.GroupEnum;

public class EmployeeVerwaltung {
    private ArrayList<Employee> employees;

    public EmployeeVerwaltung() {
        employees = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public Employee findEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public ArrayList<Employee> getEmployeesByGroup(GroupEnum group) {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getGroup() == group) {
                result.add(employee);
            }
        }
        return result;
    }

    public ArrayList<Employee> sortEmployeesById() {
        ArrayList<Employee> sortedEmployees = new ArrayList<>(employees);
        Collections.sort(sortedEmployees);
        return sortedEmployees;
    }

    // Weitere Sortier- und Suchmethoden können nach Bedarf hinzugefügt werden
}
