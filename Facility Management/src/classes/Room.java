package classes;

public class Room {
    Building building;
    int level;
    private String name;

    public Room(Building building, int level) {
        this.building = building;
        this.level = level;
        name = this.building.createRoomNumber(level);
    }

    public String getName() {
        return name;
    }
}
