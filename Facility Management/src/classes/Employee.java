package classes;

import enums.GroupEnum;

/**
 * Die Klasse Employee repräsentiert einen Mitarbeiter.
 * Sie implementiert das Comparable-Interface, um eine Vergleichsmethode für die Sortierung bereitzustellen.
 */
public class Employee implements Comparable<Employee> {
    String name;
    GroupEnum group;
    int id;

    /**
     * Konstruktor der Employee-Klasse.
     * Erzeugt einen Mitarbeiter mit dem angegebenen Namen und der Gruppe.
     * Die ID wird automatisch generiert.
     *
     * @param name  Der Name des Mitarbeiters.
     * @param group Die Gruppe, zu der der Mitarbeiter gehört.
     */
    public Employee(String name, GroupEnum group) {
        this.name = name;
        this.group = group;
        this.id = GlobalData.getEmployees().size();
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
    public int getId() {
        return this.id;
    }

    /**
     * Gibt die Gruppe des Mitarbeiters zurück.
     *
     * @return Die Gruppe des Mitarbeiters.
     */
    public GroupEnum getGroup() {
        return this.group;
    }

    /**
     * Gibt eine textuelle Repräsentation des Mitarbeiters zurück.
     *
     * @return Eine textuelle Repräsentation des Mitarbeiters.
     */
    @Override
    public String toString() {
        String message = this.id + " " + this.name;
        return message;
    }

    /**
     * Vergleicht den Mitarbeiter mit einem anderen Mitarbeiter anhand der ID.
     * Wird für die Sortierung verwendet.
     *
     * @param other Der andere Mitarbeiter, mit dem verglichen werden soll.
     * @return Eine negative ganze Zahl, wenn der Mitarbeiter vor dem anderen Mitarbeiter kommt,
     *         eine positive ganze Zahl, wenn der Mitarbeiter nach dem anderen Mitarbeiter kommt,
     *         oder 0, wenn beide Mitarbeiter gleich sind.
     */
    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.id, other.id);
    }
}
