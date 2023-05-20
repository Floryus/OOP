package classes;

public class Room extends maintainable implements cleanable {
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
}
