package classes;

import enums.GroupEnum;

public class Employee implements Comparable<Employee> {
    String name;
    GroupEnum group;
    int id;

    public Employee(String name, GroupEnum group) {
        this.name = name;
        this.group = group;
        this.id = GlobalData.getEmployees().size();
    }

    /**
     * @return String
     */
    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public GroupEnum getGroup() {
        return this.group;
    }

    @Override
    public String toString() {
        String message = this.id + " " + this.name;
        return message;
    }

    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.id, other.id);
    }
}
