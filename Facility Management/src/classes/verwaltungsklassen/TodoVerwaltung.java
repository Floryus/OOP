package classes.verwaltungsklassen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import classes.Todo;

public class TodoVerwaltung {
    private ArrayList<Todo> todos;

    public TodoVerwaltung() {
        todos = new ArrayList<>();
    }

    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    public void removeTodo(Todo todo) {
        todos.remove(todo);
    }

    public ArrayList<Todo> getTodos() {
        return todos;
    }

    public Todo findTodoById(String id) {
        for (Todo todo : todos) {
            if (todo.getId().equals(id)) {
                return todo;
            }
        }
        return null;
    }

    public ArrayList<Todo> sortTodosByPriority() {
        ArrayList<Todo> sortedTodos = new ArrayList<>(todos);
        Collections.sort(sortedTodos, Comparator.comparing(Todo::getPriority));
        return sortedTodos;
    }

    public ArrayList<Todo> sortTodosByDueDate() {
        ArrayList<Todo> sortedTodos = new ArrayList<>(todos);
        Collections.sort(sortedTodos, Comparator.comparing(Todo::getDueDate));
        return sortedTodos;
    }

}
