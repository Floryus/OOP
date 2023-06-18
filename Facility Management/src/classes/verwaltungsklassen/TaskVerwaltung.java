package classes.verwaltungsklassen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import classes.Task;

public class TaskVerwaltung {
    private ArrayList<Task> tasks;

    public TaskVerwaltung() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public Task findTaskByTitle(String title) {
        for (Task task : tasks) {
            if (task.getTitle().equals(title)) {
                return task;
            }
        }
        return null;
    }

    public ArrayList<Task> sortTasksByPriority() {
        ArrayList<Task> sortedTasks = new ArrayList<>(tasks);
        Collections.sort(sortedTasks, Comparator.comparing(Task::getPriority));
        return sortedTasks;
    }

    public ArrayList<Task> sortTasksByNextMaintenance() {
        ArrayList<Task> sortedTasks = new ArrayList<>(tasks);
        Collections.sort(sortedTasks, Comparator.comparing(Task::getNextMaintenance));
        return sortedTasks;
    }

}
