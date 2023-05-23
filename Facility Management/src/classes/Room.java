package classes;

public class Room extends Maintainable implements Comparable<Room> {
    Building building;
    Level level;
    private String name;

    public Room(Building building, Level level) {
        this.building = building;
        this.level = level;
        name = this.level.createRoomNumber();
    }

    @Override
    public void delete() {
        level.deleteRoom(this);
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return this.name + " on level " + this.level.levelNumber + " in " + this.building.getName();
    }

    @Override
    public int compareTo(Room other) {
        return this.name.compareTo(other.name);
    }

}
