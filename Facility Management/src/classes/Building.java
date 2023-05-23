package classes;

import java.util.ArrayList;

public class Building extends Maintainable implements Comparable<Building> {
    String name;
    private int maxLevels;
    ArrayList<Level> levels = new ArrayList<Level>();
    private String address;

    Building(String name, int maxLevels, String address) {
        this.name = name;
        this.maxLevels = maxLevels;
        this.address = address;
    }

    public Level createLevel(int maxRooms) {
        Level lvl = new Level(levels.size(), this, maxRooms);
        levels.add(lvl);
        return lvl;
    }

    public Level getLevelByLevelNumber(int number) throws InvalidException {
        if (number < 0 || number >= levels.size()) {
            throw new InvalidException("Ungültiger Level-Index: " + number);
        }
        return levels.get(number);
    }

    @Override
    public void delete() {
        GlobalData.deleteBuilding(this);
        System.out.println("aus building: delete " + this.name);
    }

    public void deleteLevel(Level level) {
        this.levels.remove(level);
    }

    public ArrayList<Level> getLevels() {
        return levels;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getMaxLevels() {
        return maxLevels;
    }

    public String toString() {
        return "Building " + this.name + " with " + this.levels.size() + " levels.";
    }

    @Override
    public int compareTo(Building other) {
        return this.name.toLowerCase().compareTo(other.name.toLowerCase());
    }

}
