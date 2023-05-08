package classes;

public class Building {
    String name;
    int roomNumber = 1;

    public Building(String name) {
        this.name = name;
    }

    public String createRoomNumber(int level) {
        roomNumber++;
        return this.name + ":" + String.valueOf(level) + "." + String.valueOf(roomNumber - 1);
    }

}
