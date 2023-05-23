package classes;

import java.util.ArrayList;

import enums.RoomTypesEnum;

public class Level extends Maintainable implements Comparable<Level> {
    int levelNumber;
    int maxRooms;
    Building building;
    ArrayList<Room> rooms = new ArrayList<Room>();
    private int currRoomNumber = 0;

   public Level(int levelNumber, Building building, int maxRooms) {
        this.levelNumber = levelNumber;
        this.building = building;
        this.maxRooms = maxRooms;
    }

    public Room createRoom(RoomTypesEnum rte) {

        /*
         * TODO: add rooms with Classes who inherit from Room master class
         * switch (rte) {
         * case FOOD:
         * break;
         * case CLOSETS:
         * break;
         * case FLOOR:
         * break;
         * case LABS:
         * break;
         * case OTHER:
         * break;
         * case STUDY:
         * break;
         * default:
         * Room r = new Room(this.building, this);
         * }
         */
        Room r = new Room(this.building, this);
        rooms.add(r);
        return r;
    }

    public String createRoomNumber() {
        currRoomNumber++;
        return String.valueOf(this.levelNumber) + "." + String.valueOf(currRoomNumber - 1);
    }

    @Override
    public void delete() {
        building.deleteLevel(this);
    }

    public void deleteRoom(Room room) {
        this.rooms.remove(room);
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public int getMaxRooms() {
        return maxRooms;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

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
