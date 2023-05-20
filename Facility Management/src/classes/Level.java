package classes;

import java.util.ArrayList;

import enums.RoomTypesEnum;

public class Level {
    int levelNumber;
    int maxRooms;
    Building building;
    ArrayList<Room> rooms = new ArrayList<Room>();
    private int currRoomNumber = 0;

    Level(int levelNumber, Building building, int maxRooms) {
        this.levelNumber = levelNumber;
        this.building = building;
        this.maxRooms = maxRooms;
    }

    public Room createRoom(RoomTypesEnum rte) throws InvalidException {

        if (rooms.size() < maxRooms) {
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

        } else {
            throw new InvalidException("Maximum rooms reached!");
        }
    }

    public String createRoomNumber() {
        currRoomNumber++;
        return String.valueOf(this.levelNumber) + "." + String.valueOf(currRoomNumber - 1);
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

}
