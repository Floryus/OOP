package classes;

/**
 * Die Klasse Room repräsentiert einen Raum in einem Gebäude und auf einer Ebene in der Facility Management Software.
 * Sie erbt von der Klasse `maintainable` und implementiert das `Comparable`-Interface.
 */
public class Room extends maintainable implements Comparable<Room> {
    Building building;
    Level level;
    private String name;

    /**
     * Konstruktor für die Room-Klasse.
     *
     * @param building Das Gebäude, zu dem der Raum gehört.
     * @param level    Die Ebene, auf der sich der Raum befindet.
     */
    public Room(Building building, Level level) {
        this.building = building;
        this.level = level;
        name = this.level.createRoomNumber();
    }

    /**
     * Gibt den Namen des Raums zurück.
     *
     * @return Der Name des Raums.
     */
    public String getName() {
        return name;
    }

    /**
     * Gibt eine Zeichenfolgendarstellung des Raums zurück.
     *
     * @return Eine Zeichenfolgendarstellung des Raums.
     */
    public String toString() {
        return this.name + " on level " + this.level.levelNumber + " in " + this.building.getName();
    }

    @Override
    public int compareTo(Room other) {
        return this.name.compareTo(other.name);
    }
}
