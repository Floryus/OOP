package classes;

import java.util.ArrayList;
import ticketSystem.Ticket;
import enums.GroupEnum;

/**
 * Die Klasse Employee repräsentiert einen Mitarbeiter in der Facility Management Software.
 * Sie implementiert das Comparable-Interface, um die Vergleichbarkeit von Mitarbeitern zu ermöglichen.
 */
public class Employee implements Comparable<Employee> {
    String name;
    GroupEnum group;
    String id;
    ArrayList<Todo> todos = new ArrayList<>();

    /**
     * Konstruktor für die Employee-Klasse.
     *
     * @param name  Der Name des Mitarbeiters.
     * @param group Die Gruppe, der der Mitarbeiter angehört.
     * @param id    Die ID des Mitarbeiters.
     */
    Employee(String name, GroupEnum group, String id) {
        this.name = name;
        this.group = group;
        this.id = id;
    }

    /**
     * Gibt den Namen des Mitarbeiters zurück.
     *
     * @return Der Name des Mitarbeiters.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gibt die ID des Mitarbeiters zurück.
     *
     * @return Die ID des Mitarbeiters.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Gibt die Gruppe zurück, der der Mitarbeiter angehört.
     *
     * @return Die Gruppe, der der Mitarbeiter angehört.
     */
    public GroupEnum getGroup() {
        return this.group;
    }

    /**
     * Gibt eine Zeichenfolgendarstellung des Mitarbeiters zurück (nur der Name).
     *
     * @return Eine Zeichenfolgendarstellung des Mitarbeiters.
     */
    @Override
    public String toString() {
        return getName();
    }

    /**
     * Vergleicht diesen Mitarbeiter mit einem anderen Mitarbeiter anhand ihrer Namen.
     *
     * @param o Der andere Mitarbeiter, mit dem verglichen werden soll.
     * @return Ein negativer Integer, null oder ein positiver Integer, je nachdem, ob dieser Mitarbeiter
     *         vor, gleich oder nach dem anderen Mitarbeiter liegt.
     */
    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.name);
    }

    /**
     * Fügt dem Mitarbeiter eine neue Aufgabe (Todo) hinzu.
     *
     * @param todo Die hinzuzufügende Aufgabe (Todo).
     */
    public void addTodo(Todo todo) {
        todos.add(todo);
    }
}
