package classes;

import java.util.ArrayList;

import enums.GroupEnum;

public class Employee implements Comparable<Employee> {
    String name;
    GroupEnum group;
    ArrayList<doable> todos = new ArrayList<>();

    Employee(String name, GroupEnum group) {
        this.name = name;
        this.group = group;
    }

    @Override
    public String toString() {
        String message = this.name + " as " + this.group + " with tasks\n";
        for (doable todo : todos) {
            message += todo.toString() + "\n";
        }
        return message;
    }

    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.name);
    }
}
