package classes;

import enums.RoomFlooringEnum;
import enums.RoomTypesEnum;

import java.util.ArrayList;
import java.util.List;

import classes.verwaltungsklassen.EquipmentVerwaltung;

/**
 * Die Klasse Room repräsentiert einen Raum in einem Gebäude und erbt von der
 * Maintainable-Klasse.
 * 
 * @author Florian Schmidt
 * 
 * @version 1.0
 */
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

    /**
     * Konstruktor der Room-Klasse.
     *
     * @param building Das Gebäude, zu dem der Raum gehört.
     * @param level    Die Etage, auf der sich der Raum befindet.
     * @param type     Der Typ des Raums.
     * @param name     Der Name des Raums.
     */
    public Room(Building building, Level level, RoomTypesEnum type, String name) {
        this.building = building;
        this.level = level;
        this.type = type;
        this.name = name;
    }

    /**
     * Überschreibt die Löschmethode der Oberklasse.
     * Entfernt den Raum von der Etage.
     */
    @Override
    public void delete() {
        level.deleteRoom(this);
    }

    /**
     * Gibt den Namen des Raums zurück.
     *
     * @return Der Name des Raums.
     */
    public String getName() {
        return name;
    }

    /**
     * Gibt das Gebäude zurück, zu dem der Raum gehört.
     *
     * @return Das Gebäude, zu dem der Raum gehört.
     */
    public Building getBuilding() {
        return building;
    }

    /**
     * Gibt die Etage zurück, auf der sich der Raum befindet.
     *
     * @return Die Etage, auf der sich der Raum befindet.
     */
    public Level getLevel() {
        return level;
    }

    /**
     * Gibt die Länge des Raums zurück.
     *
     * @return Die Länge des Raums.
     */
    public double getLength() {
        return length;
    }

    /**
     * Setzt die Länge des Raums.
     *
     * @param length Die Länge des Raums.
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Gibt die Breite des Raums zurück.
     *
     * @return Die Breite des Raums.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Setzt die Breite des Raums.
     *
     * @param width Die Breite des Raums.
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Gibt die Höhe des Raums zurück.
     *
     * @return Die Höhe des Raums.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Setzt die Höhe des Raums.
     *
     * @param height Die Höhe des Raums.
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Gibt den Bodenbelag des Raums zurück.
     *
     * @return Der Bodenbelag des Raums.
     */
    public RoomFlooringEnum getFlooring() {
        return flooring;
    }

    /**
     * Setzt den Bodenbelag des Raums.
     *
     * @param flooring Der Bodenbelag des Raums.
     */
    public void setFlooring(RoomFlooringEnum flooring) {
        this.flooring = flooring;
    }

    /**
     * Gibt den Typ des Raums zurück.
     *
     * @return Der Typ des Raums.
     */
    public RoomTypesEnum getRoomType() {
        return type;
    }

    /**
     * Setzt den Typ des Raums.
     *
     * @param type Der Typ des Raums.
     */
    public void setType(RoomTypesEnum type) {
        this.type = type;
    }

    /**
     * Gibt eine Liste der Geräte im Raum zurück.
     *
     * @return Eine ArrayList mit den Geräten im Raum.
     */
    public ArrayList<Equipment> getEquipmentList() {
        return equipmentVerwaltung.getEquipmentList();
    }

    /**
     * Fügt ein Gerät dem Raum hinzu.
     *
     * @param equipment Das hinzuzufügende Gerät.
     */
    public void addEquipment(Equipment equipment) {
        equipmentVerwaltung.addEquipment(equipment);
    }

    /**
     * Entfernt ein Gerät aus dem Raum.
     *
     * @param equipment Das zu entfernende Gerät.
     */
    public void removeEquipment(Equipment equipment) {
        equipmentVerwaltung.removeEquipment(equipment);
    }

    /**
     * Gibt die Anzahl der Sitzplätze im Raum zurück.
     *
     * @return Die Anzahl der Sitzplätze im Raum.
     */
    public int getSeatCount() {
        return seatCount;
    }

    /**
     * Setzt die Anzahl der Sitzplätze im Raum.
     *
     * @param seatCount Die Anzahl der Sitzplätze im Raum.
     */
    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    /**
     * Gibt eine textuelle Repräsentation des Raums zurück.
     *
     * @return Eine textuelle Repräsentation des Raums.
     */
    public String toString() {
        return "Raum" + this.getName();
    }

    /**
     * Vergleicht diesen Raum mit einem anderen Raum.
     * Die Räume werden nach ihren Namen sortiert.
     *
     * @param other Der andere Raum, mit dem dieser Raum verglichen wird.
     * @return Eine negative ganze Zahl, wenn dieser Raum vor dem anderen Raum
     *         kommt,
     *         eine positive ganze Zahl, wenn dieser Raum nach dem anderen Raum
     *         kommt,
     *         oder 0, wenn beide Räume gleich sind.
     */
    @Override
    public int compareTo(Room other) {
        return this.name.compareTo(other.name);
    }
}
