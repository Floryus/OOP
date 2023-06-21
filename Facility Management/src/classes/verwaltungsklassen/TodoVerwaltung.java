package classes.verwaltungsklassen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import classes.Todo;

/**
 * Die Klasse TodoVerwaltung verwaltet eine Liste von Todos.
 */
public class TodoVerwaltung {
    private ArrayList<Todo> todos;

    /**
     * Konstruktor der TodoVerwaltung-Klasse.
     * Erzeugt eine leere Liste von Todos.
     */
    public TodoVerwaltung() {
        todos = new ArrayList<>();
    }

    /**
     * Fügt ein Todo zur Liste hinzu.
     *
     * @param todo Das hinzuzufügende Todo.
     */
    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    /**
     * Entfernt ein Todo aus der Liste.
     *
     * @param todo Das zu entfernende Todo.
     */
    public void removeTodo(Todo todo) {
        todos.remove(todo);
    }

    /**
     * Gibt die Liste aller Todos zurück.
     *
     * @return Die Liste aller Todos.
     */
    public ArrayList<Todo> getTodos() {
        return todos;
    }

    /**
     * Sucht ein Todo anhand seiner ID in der Liste.
     *
     * @param id Die ID des gesuchten Todos.
     * @return Das Todo mit der angegebenen ID oder null, wenn kein Todo gefunden wurde.
     */
    public Todo findTodoById(String id) {
        for (Todo todo : todos) {
            if (todo.getId().equals(id)) {
                return todo;
            }
        }
        return null;
    }

    /**
     * Sortiert die Liste der Todos nach Priorität.
     *
     * @return Eine sortierte Liste der Todos nach Priorität.
     */
    public ArrayList<Todo> sortTodosByPriority() {
        ArrayList<Todo> sortedTodos = new ArrayList<>(todos);
        Collections.sort(sortedTodos, Comparator.comparing(Todo::getPriority));
        return sortedTodos;
    }

    /**
     * Sortiert die Liste der Todos nach dem Fälligkeitsdatum.
     *
     * @return Eine sortierte Liste der Todos nach dem Fälligkeitsdatum.
     */
    public ArrayList<Todo> sortTodosByDueDate() {
        ArrayList<Todo> sortedTodos = new ArrayList<>(todos);
        Collections.sort(sortedTodos, Comparator.comparing(Todo::getDueDate));
        return sortedTodos;
    }

}
