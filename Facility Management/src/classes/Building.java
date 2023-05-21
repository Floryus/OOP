package classes;

import java.util.ArrayList;

public class Building implements Comparable<Building> {
    String name;
    private int maxLevels;
    ArrayList<Level> levels = new ArrayList<Level>();
    private String address;

    Building(String name, int maxLevels, String address) {
        this.name = name;
        this.maxLevels = maxLevels;
        this.address = address;
    }

    public Level createLevel(int maxRooms) throws InvalidException {
        if (levels.size() < maxLevels) {
            Level lvl = new Level(levels.size(), this, maxRooms);
            levels.add(lvl);
            return lvl;
        } else {
            throw new InvalidException("Maximum levels reached!");
        }
    }

    public Level getLevelByLevelNumber(int number) throws InvalidException {
        if (number < 0 || number >= levels.size()) {
            throw new InvalidException("Ungültiger Level-Index: " + number);
        }
        return levels.get(number);
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
        return this.name.compareTo(other.name);
    }

}
