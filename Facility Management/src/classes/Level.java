package classes;

import java.util.ArrayList;

import classes.verwaltungsklassen.RoomVerwaltung;
import enums.RoomTypesEnum;

public class Level extends Maintainable implements Comparable<Level> {
    int levelNumber;
    int maxRooms;
    Building building;
    private RoomVerwaltung roomVerwaltung = new RoomVerwaltung();

    public Level(int levelNumber, Building building, int maxRooms) {
        this.levelNumber = levelNumber;
        this.building = building;
        this.maxRooms = maxRooms;
    }

    /**
     * @param rte
     * @return Room
     */
    public Room createRoom(String name, RoomTypesEnum rte) {

        Room r = new Room(this.building, this, rte, name);
        roomVerwaltung.addRoom(r);
        return r;
    }

    @Override
    public void delete() {
        building.deleteLevel(this);
    }

    public void deleteRoom(Room room) {
        this.roomVerwaltung.removeRoom(room);
    }

    public ArrayList<Room> getRooms() {
        return roomVerwaltung.getRooms();
    }

    public int getMaxRooms() {
        return maxRooms;
    }

    public void setMaxRooms(int maxRooms) {
        this.maxRooms = maxRooms;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public Building getBuilding() {
        return building;
    }

    public String toString() {
        return "This level is number " + this.levelNumber + " of " + roomVerwaltung.getRooms().size() + " in "
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
