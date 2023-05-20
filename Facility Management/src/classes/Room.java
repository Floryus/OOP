package classes;

public class Room extends maintainable implements cleanable, Comparable<Room> {
    Building building;
    Level level;
    private String name;

    public Room(Building building, Level level) {
        this.building = building;
        this.level = level;
        name = this.level.createRoomNumber();
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
