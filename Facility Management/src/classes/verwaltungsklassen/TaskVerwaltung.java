package classes.verwaltungsklassen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import classes.Task;

/**
 * Die Klasse TaskVerwaltung verwaltet eine Liste von Aufgaben.
 */
public class TaskVerwaltung {
    private ArrayList<Task> tasks;

    /**
     * Konstruktor der TaskVerwaltung-Klasse.
     * Erzeugt eine leere Liste von Aufgaben.
     */
    public TaskVerwaltung() {
        tasks = new ArrayList<>();
    }

    /**
     * Fügt eine Aufgabe zur Liste hinzu.
     *
     * @param task Die hinzuzufügende Aufgabe.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Entfernt eine Aufgabe aus der Liste.
     *
     * @param task Die zu entfernende Aufgabe.
     */
    public void removeTask(Task task) {
        tasks.remove(task);
    }

    /**
     * Gibt die Liste aller Aufgaben zurück.
     *
     * @return Die Liste aller Aufgaben.
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Sucht eine Aufgabe anhand ihres Titels in der Liste.
     *
     * @param title Der Titel der gesuchten Aufgabe.
     * @return Die Aufgabe mit dem angegebenen Titel oder null, wenn keine Aufgabe gefunden wurde.
     */
    public Task findTaskByTitle(String title) {
        for (Task task : tasks) {
            if (task.getTitle().equals(title)) {
                return task;
            }
        }
        return null;
    }

    /**
     * Sortiert die Liste der Aufgaben nach Priorität.
     *
     * @return Eine sortierte Liste der Aufgaben nach Priorität.
     */
    public ArrayList<Task> sortTasksByPriority() {
        ArrayList<Task> sortedTasks = new ArrayList<>(tasks);
        Collections.sort(sortedTasks, Comparator.comparing(Task::getPriority));
        return sortedTasks;
    }

    /**
     * Sortiert die Liste der Aufgaben nach dem nächsten Wartungstermin.
     *
     * @return Eine sortierte Liste der Aufgaben nach dem nächsten Wartungstermin.
     */
    public ArrayList<Task> sortTasksByNextMaintenance() {
        ArrayList<Task> sortedTasks = new ArrayList<>(tasks);
        Collections.sort(sortedTasks, Comparator.comparing(Task::getNextMaintenance));
        return sortedTasks;
    }

}
