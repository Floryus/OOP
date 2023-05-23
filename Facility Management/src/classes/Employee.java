package classes;

import java.util.ArrayList;

import enums.GroupEnum;

public class Employee implements Comparable<Employee> {
    String name;
    GroupEnum group;
    String id; 
    ArrayList<Todo> todos = new ArrayList<>();

    Employee(String name, GroupEnum group, String id) {
        this.name = name;
        this.group = group;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public GroupEnum getGroup() {
        return this.group;
    }

    @Override
    public String toString() {
        String message = this.name + " as " + this.group + " with tasks\n";
        for (Todo todo : todos) {
            message += todo.toString() + "\n";
        }
        return message;
    }

    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.name);
    }

    public void addTodo(Todo todo) {
        todos.add(todo);
    }
}
