package classes;

/**
 * Die Klasse Equipment repräsentiert ein Equipment, das in der Facility Management Software verwendet wird.
 * Es erbt von der Klasse `maintainable` und implementiert das `Comparable`-Interface.
 */
public class Equipment extends maintainable implements Comparable<Equipment> {
    String name;
    boolean hasTicket;

    /**
     * Konstruktor für die Equipment-Klasse.
     *
     * @param name Der Name des Equipments.
     */
    public Equipment(String name) {
        this.name = name;
    }

    /**
     * Gibt den Namen des Equipments zurück.
     *
     * @return Der Name des Equipments.
     */
    public String toString() {
        return this.name;
    }

    /**
     * Vergleicht dieses Equipment mit einem anderen Equipment anhand ihres Namens.
     *
     * @param other Das andere Equipment, mit dem verglichen werden soll.
     * @return Ein negativer Integer, null oder ein positiver Integer, je nachdem, ob dieses Equipment
     *         vor, gleich oder nach dem anderen Equipment liegt.
     */
    public int compareTo(Equipment other) {
        return this.name.compareTo(other.name);
    }
}
