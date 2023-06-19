package classes;

import java.util.ArrayList;

import classes.verwaltungsklassen.RoomVerwaltung;
import enums.RoomTypesEnum;

/**
 * Die Klasse Level repräsentiert eine Etage eines Gebäudes und erbt von der Maintainable-Klasse.
 */
public class Level extends Maintainable implements Comparable<Level> {
    private int levelNumber;
    private int maxRooms;
    private Building building;
    private RoomVerwaltung roomVerwaltung = new RoomVerwaltung();

    /**
     * Konstruktor der Level-Klasse.
     *
     * @param levelNumber Die Nummer der Etage.
     * @param building    Das Gebäude, zu dem die Etage gehört.
     * @param maxRooms    Die maximale Anzahl von Räumen auf der Etage.
     */
    public Level(int levelNumber, Building building, int maxRooms) {
        this.levelNumber = levelNumber;
        this.building = building;
        this.maxRooms = maxRooms;
    }

    /**
     * Erzeugt einen neuen Raum auf der Etage mit dem angegebenen Namen und Typ und fügt ihn der Room-Verwaltung hinzu.
     *
     * @param name Der Name des Raums.
     * @param rte  Der Typ des Raums.
     * @return Der erstellte Raum.
     */
    public Room createRoom(String name, RoomTypesEnum rte) {
        Room r = new Room(this.building, this, rte, name);
        roomVerwaltung.addRoom(r);
        return r;
    }

    /**
     * Überschreibt die Löschmethode der Oberklasse.
     * Entfernt die Etage aus dem Gebäude.
     */
    @Override
    public void delete() {
        building.deleteLevel(this);
    }

    /**
     * Entfernt den angegebenen Raum von der Etage.
     *
     * @param room Der zu entfernende Raum.
     */
    public void deleteRoom(Room room) {
        this.roomVerwaltung.removeRoom(room);
    }

    /**
     * Gibt eine Liste der Räume auf der Etage zurück.
     *
     * @return Eine ArrayList mit den Räumen auf der Etage.
     */
    public ArrayList<Room> getRooms() {
        return roomVerwaltung.getRooms();
    }

    /**
     * Gibt die maximale Anzahl von Räumen auf der Etage zurück.
     *
     * @return Die maximale Anzahl von Räumen auf der Etage.
     */
    public int getMaxRooms() {
        return maxRooms;
    }

    /**
     * Setzt die maximale Anzahl von Räumen auf der Etage.
     *
     * @param maxRooms Die maximale Anzahl von Räumen auf der Etage.
     */
    public void setMaxRooms(int maxRooms) {
        this.maxRooms = maxRooms;
    }

    /**
     * Gibt die Nummer der Etage zurück.
     *
     * @return Die Nummer der Etage.
     */
    public int getLevelNumber() {
        return levelNumber;
    }

    /**
     * Gibt das Gebäude zurück, zu dem die Etage gehört.
     *
     * @return Das Gebäude, zu dem die Etage gehört.
     */
    public Building getBuilding() {
        return building;
    }

    /**
     * Gibt eine textuelle Repräsentation der Etage zurück.
     *
     * @return Eine textuelle Repräsentation der Etage.
     */
    public String toString() {
        return "This level is number " + this.levelNumber + " of " + roomVerwaltung.getRooms().size() + " in "
                + this.building.toString();
    }

    /**
     * Vergleicht diese Etage mit einer anderen Etage.
     * Die Etage wird zuerst nach dem Namen des zugehörigen Gebäudes und dann nach der Etagennummer sortiert.
     *
     * @param other Die andere Etage, mit der diese Etage verglichen wird.
     * @return Eine negative ganze Zahl, wenn diese Etage vor der anderen Etage kommt,
     *         eine positive ganze Zahl, wenn diese Etage nach der anderen Etage kommt,
     *         oder 0, wenn beide Etagen gleich sind.
     */
    @Override
    public int compareTo(Level other) {
        int result = this.building.getName().compareTo(other.building.getName());
        if (result == 0) {
            return Integer.compare(this.levelNumber, other.levelNumber);
        }
        return result;
    }
}
