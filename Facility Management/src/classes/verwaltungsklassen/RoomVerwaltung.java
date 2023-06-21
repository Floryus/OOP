package classes.verwaltungsklassen;

import java.util.ArrayList;
import java.util.Collections;

import classes.Building;
import classes.Room;

/*
 * Diese Klasse dient der Verwaltung von Räumen.
 * Sie implementiert diese als Collection, macht CRUD-Operationen, Sortierung und Suche möglich.
 * 
 * @autor Florian Schmidt
 * 
 * @version 1.0
 */

/**
 * Die Klasse RoomVerwaltung verwaltet eine Liste von Räumen.
 */
public class RoomVerwaltung {
    private ArrayList<Room> rooms;

    /**
     * Konstruktor der RoomVerwaltung-Klasse.
     * Erzeugt eine leere Liste von Räumen.
     */
    public RoomVerwaltung() {
        rooms = new ArrayList<>();
    }

    /**
     * Gibt die Liste aller Räume zurück.
     *
     * @return Die Liste aller Räume.
     */
    public ArrayList<Room> getRooms() {
        return rooms;
    }

    /**
     * Fügt einen Raum zur Liste hinzu.
     *
     * @param room Der hinzuzufügende Raum.
     */
    public void addRoom(Room room) {
        rooms.add(room);
    }

    /**
     * Entfernt einen Raum aus der Liste.
     *
     * @param room Der zu entfernende Raum.
     */
    public void removeRoom(Room room) {
        rooms.remove(room);
    }

    /**
     * Sucht einen Raum anhand seines Namens in der Liste.
     *
     * @param name Der Name des gesuchten Raums.
     * @return Der Raum mit dem angegebenen Namen oder null, wenn kein Raum gefunden wurde.
     */
    public Room findRoomByName(String name) {
        for (Room room : rooms) {
            if (room.getName().equalsIgnoreCase(name)) {
                return room;
            }
        }
        return null;
    }

    /**
     * Gibt eine Liste von Räumen zurück, die zu einem bestimmten Gebäude gehören.
     *
     * @param building Das Gebäude, nach dem gesucht werden soll.
     * @return Eine Liste von Räumen, die zu dem angegebenen Gebäude gehören.
     */
    public ArrayList<Room> getRoomsByBuilding(Building building) {
        ArrayList<Room> result = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getBuilding() == building) {
                result.add(room);
            }
        }
        return result;
    }

    /**
     * Sortiert die Liste der Räume nach ihrem Namen.
     *
     * @return Eine sortierte Liste der Räume nach ihrem Namen.
     */
    public ArrayList<Room> sortRoomsByName() {
        ArrayList<Room> sortedRooms = new ArrayList<>(rooms);
        Collections.sort(sortedRooms);
        return sortedRooms;
    }

    // Weitere Sortier- und Suchmethoden können nach Bedarf hinzugefügt werden
}
