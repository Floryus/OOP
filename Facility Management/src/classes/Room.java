package classes;

import enums.RoomFlooringEnum;
import enums.RoomTypesEnum;

import java.util.ArrayList;
import java.util.List;

import classes.verwaltungsklassen.EquipmentVerwaltung;

public class Room extends Maintainable implements Comparable<Room> {
    private Building building;
    private Level level;

    private String name;
    private double length;
    private double width;
    private double height;
    private RoomFlooringEnum flooring;
    private RoomTypesEnum type;
    private EquipmentVerwaltung equipmentVerwaltung = new EquipmentVerwaltung();
    private int seatCount;

    public Room(Building building, Level level, RoomTypesEnum type, String name) {
        this.building = building;
        this.level = level;
        this.type = type;
        this.name = name;
    }

    @Override
    public void delete() {
        level.deleteRoom(this);
    }

    /**
     * @return String
     */
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

    public RoomTypesEnum getRoomType() {
        return type;
    }

    public void setType(RoomTypesEnum type) {
        this.type = type;
    }

    public ArrayList<Equipment> getEquipmentList() {
        return equipmentVerwaltung.getEquipmentList();
    }

    public void addEquipment(Equipment equipment) {
        equipmentVerwaltung.addEquipment(equipment);
    }

    public void removeEquipment(Equipment equipment) {
        equipmentVerwaltung.removeEquipment(equipment);
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public String toString() {
        return "Room " + this.getName();
    }

    @Override
    public int compareTo(Room other) {
        return this.name.compareTo(other.name);
    }
}
