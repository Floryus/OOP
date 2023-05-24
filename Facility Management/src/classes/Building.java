package classes;

import java.util.ArrayList;

public class Building extends Maintainable implements Comparable<Building> {
    private String name;
    private int maxLevels;
    private ArrayList<Level> levels = new ArrayList<Level>();
    private Address address;
    private int employeeCount;
    private int constructionYear;
    private int parkingSpaces;

    public Building(String name) {
        this.name = name;
    }

    public Building(String name, int maxLevels, Address address, int employeeCount, int constructionYear,
            int parkingSpaces) {
        this.name = name;
        this.maxLevels = maxLevels;
        this.address = address;
        this.employeeCount = employeeCount;
        this.constructionYear = constructionYear;
        this.parkingSpaces = parkingSpaces;
    }

    /**
     * @param maxRooms
     * @return Level
     */
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

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getMaxLevels() {
        return maxLevels;
    }

    public void setMaxLevels(int maxLevels) {
        this.maxLevels = maxLevels;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public int getConstructionYear() {
        return constructionYear;
    }

    public void setConstructionYear(int constructionYear) {
        this.constructionYear = constructionYear;
    }

    public int getParkingSpaces() {
        return parkingSpaces;
    }

    public void setParkingSpaces(int parkingSpaces) {
        this.parkingSpaces = parkingSpaces;
    }

    public String toString() {
        return "Building " + this.name + " with " + this.levels.size() + " levels. Address: " + address.toString();
    }

    @Override
    public int compareTo(Building other) {
        return this.name.toLowerCase().compareTo(other.name.toLowerCase());
    }
}
