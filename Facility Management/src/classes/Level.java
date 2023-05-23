package classes;

import java.util.ArrayList;

import enums.RoomTypesEnum;

/**
 * Die Klasse Level repräsentiert eine Ebene in einem Gebäude in der Facility Management Software.
 * Sie implementiert das `Comparable`-Interface.
 */
public class Level implements Comparable<Level> {
    int levelNumber;
    int maxRooms;
    Building building;
    ArrayList<Room> rooms = new ArrayList<Room>();
    private int currRoomNumber = 0;

    /**
     * Konstruktor für die Level-Klasse.
     *
     * @param levelNumber Die Nummer der Ebene.
     * @param building    Das Gebäude, zu dem die Ebene gehört.
     * @param maxRooms    Die maximale Anzahl von Räumen auf der Ebene.
     */
    Level(int levelNumber, Building building, int maxRooms) {
        this.levelNumber = levelNumber;
        this.building = building;
        this.maxRooms = maxRooms;
    }

    /**
     * Erstellt einen Raum mit dem angegebenen Raumtyp auf dieser Ebene.
     *
     * @param rte Der Raumtyp des zu erstellenden Raums.
     * @return Der erstellte Raum.
     */
    public Room createRoom(RoomTypesEnum rte) {
        /*
         * TODO: Räume mit Klassen erstellen, die von der Basisklasse Room erben
         * switch (rte) {
         *     case FOOD:
         *         break;
         *     case CLOSETS:
         *         break;
         *     case FLOOR:
         *         break;
         *     case LABS:
         *         break;
         *     case OTHER:
         *         break;
         *     case STUDY:
         *         break;
         *     default:
         *         Room r = new Room(this.building, this);
         * }
         */
        Room r = new Room(this.building, this);
        rooms.add(r);
        return r;
    }

    /**
     * Erzeugt eine Raumnummer für einen neuen Raum auf dieser Ebene.
     *
     * @return Die erzeugte Raumnummer.
     */
    public String createRoomNumber() {
        currRoomNumber++;
        return String.valueOf(this.levelNumber) + "." + String.valueOf(currRoomNumber - 1);
    }

    /**
     * Gibt eine Liste aller Räume auf dieser Ebene zurück.
     *
     * @return Eine Liste aller Räume auf dieser Ebene.
     */
    public ArrayList<Room> getRooms() {
        return rooms;
    }

    /**
     * Gibt die maximale Anzahl von Räumen auf dieser Ebene zurück.
     *
     * @return Die maximale Anzahl von Räumen auf dieser Ebene.
     */
    public int getMaxRooms() {
        return maxRooms;
    }

    /**
     * Gibt die Nummer dieser Ebene zurück.
     *
     * @return Die Nummer dieser Ebene.
     */
    public int getLevelNumber() {
        return levelNumber;
    }

    /**
     * Gibt eine Zeichenfolgendarstellung dieser Ebene zurück.
     *
     * @return Eine Zeichenfolgendarstellung dieser Ebene.
     */
    public String toString() {
        return "This level is number " + this.levelNumber + " of " + this.currRoomNumber + " in "
                + this.building.toString();
    }

    @Override
    public int compareTo(Level other) {
        int result = this.building.getName().compareTo(other.building.getName());
        if (result == 0) {
            return Integer.compare(this.levelNumber, other.levelNumber);
        }
        return result;
    }

}
