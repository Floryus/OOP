package classes;

import enums.RoomFlooringEnum;

import java.util.ArrayList;
import java.util.List;

public class Room extends Maintainable implements Comparable<Room> {
    private Building building;
    private Level level;
    private String name;
    private double length;
    private double width;
    private double height;
    private RoomFlooringEnum flooring;
    private List<Equipment> equipmentList;
    private int seatCount;

    public Room(Building building, Level level) {
        this.building = building;
        this.level = level;
        name = this.level.createRoomNumber();
        equipmentList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Building getBuilding() {
        return building;
    }

    public Level getLevel() {
        return level;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public RoomFlooringEnum getFlooring() {
        return flooring;
    }

    public void setFlooring(RoomFlooringEnum flooring) {
        this.flooring = flooring;
    }

    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }

    public void addEquipment(Equipment equipment) {
        equipmentList.add(equipment);
    }

    public void removeEquipment(Equipment equipment) {
        equipmentList.remove(equipment);
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public String toString() {
        return this.name + " on level " + this.level.getLevelNumber() + " in " + this.building.getName();
    }

    @Override
    public int compareTo(Room other) {
        return this.name.compareTo(other.name);
    }
}
