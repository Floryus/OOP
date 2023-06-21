package classes.verwaltungsklassen;

import java.util.ArrayList;
import java.util.Collections;

import classes.Employee;
import enums.GroupEnum;

/**
 * Die Klasse EmployeeVerwaltung verwaltet eine Liste von Mitarbeitern.
 * 
 * @author Florian Schmidt
 * 
 * @version 1.0
 */
public class EmployeeVerwaltung {
    private ArrayList<Employee> employees;

    /**
     * Konstruktor der EmployeeVerwaltung-Klasse.
     * Erzeugt eine leere Liste von Mitarbeitern.
     */
    public EmployeeVerwaltung() {
        employees = new ArrayList<>();
    }

    /**
     * Gibt die Liste aller Mitarbeiter zurück.
     *
     * @return Die Liste aller Mitarbeiter.
     */
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    /**
     * Fügt einen Mitarbeiter zur Liste hinzu.
     *
     * @param employee Der hinzuzufügende Mitarbeiter.
     */
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    /**
     * Entfernt einen Mitarbeiter aus der Liste.
     *
     * @param employee Der zu entfernende Mitarbeiter.
     */
    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    /**
     * Sucht einen Mitarbeiter anhand seiner ID in der Liste.
     *
     * @param id Die ID des gesuchten Mitarbeiters.
     * @return Der Mitarbeiter mit der angegebenen ID oder null, wenn kein
     *         Mitarbeiter gefunden wurde.
     */
    public Employee findEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    /**
     * Gibt eine Liste von Mitarbeitern zurück, die der angegebenen Gruppe
     * entsprechen.
     *
     * @param group Die Gruppe, nach der gesucht werden soll.
     * @return Eine Liste von Mitarbeitern, die der angegebenen Gruppe entsprechen.
     */
    public ArrayList<Employee> getEmployeesByGroup(GroupEnum group) {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getGroup() == group) {
                result.add(employee);
            }
        }
        return result;
    }

    /**
     * Sortiert die Liste der Mitarbeiter nach ihrer ID.
     *
     * @return Eine sortierte Liste der Mitarbeiter nach ihrer ID.
     */
    public ArrayList<Employee> sortEmployeesById() {
        ArrayList<Employee> sortedEmployees = new ArrayList<>(employees);
        Collections.sort(sortedEmployees);
        return sortedEmployees;
    }

    // Weitere Sortier- und Suchmethoden können nach Bedarf hinzugefügt werden
}
