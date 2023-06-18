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

public class RoomVerwaltung {
    private ArrayList<Room> rooms;

    public RoomVerwaltung() {
        rooms = new ArrayList<>();
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void removeRoom(Room room) {
        rooms.remove(room);
    }

    public Room findRoomByName(String name) {
        for (Room room : rooms) {
            if (room.getName().equalsIgnoreCase(name)) {
                return room;
            }
        }
        return null;
    }

    public ArrayList<Room> getRoomsByBuilding(Building building) {
        ArrayList<Room> result = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getBuilding() == building) {
                result.add(room);
            }
        }
        return result;
    }

    public ArrayList<Room> sortRoomsByName() {
        ArrayList<Room> sortedRooms = new ArrayList<>(rooms);
        Collections.sort(sortedRooms);
        return sortedRooms;
    }

    // Weitere Sortier- und Suchmethoden können nach Bedarf hinzugefügt werden
}
