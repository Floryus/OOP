package classes;

import enums.EquipStatusEnum;
import enums.EquipTypeEnum;

import java.util.GregorianCalendar;

/**
 * Die Klasse Equipment repräsentiert ein Ausrüstungsgegenstand, der
 * instandgehalten werden kann.
 * Sie implementiert das Comparable-Interface, um eine Vergleichsmethode für die
 * Sortierung bereitzustellen.
 * 
 * @author Florian Schmidt
 * 
 * @version 1.0
 */
public class Equipment extends Maintainable implements Comparable<Equipment> {
    private String name;
    private EquipTypeEnum equipType;
    private EquipStatusEnum equipStatus;
    private GregorianCalendar acquisitionDate;
    private GregorianCalendar lastMaintenanceDate;
    private int maintenanceInterval;
    private Room room;

    /**
     * Konstruktor der Equipment-Klasse.
     * Erzeugt ein Ausrüstungsgegenstand mit dem angegebenen Namen, Ausrüstungstyp,
     * Erwerbsdatum,
     * Wartungsintervall und Raum.
     *
     * @param name                Der Name des Ausrüstungsgegenstands.
     * @param equipType           Der Ausrüstungstyp des Ausrüstungsgegenstands.
     * @param acquisitionDate     Das Erwerbsdatum des Ausrüstungsgegenstands.
     * @param maintenanceInterval Das Wartungsintervall des Ausrüstungsgegenstands
     *                            in Monaten.
     * @param room                Der Raum, in dem sich der Ausrüstungsgegenstand
     *                            befindet.
     */
    public Equipment(String name, EquipTypeEnum equipType, GregorianCalendar acquisitionDate, int maintenanceInterval,
            Room room) {
        this.name = name;
        this.equipType = equipType;
        this.equipStatus = EquipStatusEnum.ACTIVE;
        this.acquisitionDate = acquisitionDate;
        // lastMaintenanceDate.add(GregorianCalendar.MONTH, -maintenanceInterval);
        this.maintenanceInterval = maintenanceInterval;
        this.room = room;
    }

    /**
     * Gibt den Namen des Ausrüstungsgegenstands zurück.
     *
     * @return Der Name des Ausrüstungsgegenstands.
     */
    public String getName() {
        return name;
    }

    /**
     * Gibt den Ausrüstungstyp des Ausrüstungsgegenstands zurück.
     *
     * @return Der Ausrüstungstyp des Ausrüstungsgegenstands.
     */
    public EquipTypeEnum getEquipType() {
        return equipType;
    }

    /**
     * Setzt den Ausrüstungstyp des Ausrüstungsgegenstands.
     *
     * @param equipType Der Ausrüstungstyp des Ausrüstungsgegenstands.
     */
    public void setEquipType(EquipTypeEnum equipType) {
        this.equipType = equipType;
    }

    /**
     * Gibt den Ausrüstungsstatus des Ausrüstungsgegenstands zurück.
     *
     * @return Der Ausrüstungsstatus des Ausrüstungsgegenstands.
     */
    public EquipStatusEnum getEquipStatus() {
        return equipStatus;
    }

    /**
     * Setzt den Ausrüstungsstatus des Ausrüstungsgegenstands.
     *
     * @param equipStatus Der Ausrüstungsstatus des Ausrüstungsgegenstands.
     */
    public void setEquipStatus(EquipStatusEnum equipStatus) {
        this.equipStatus = equipStatus;
    }

    /**
     * Gibt das Erwerbsdatum des Ausrüstungsgegenstands zurück.
     *
     * @return Das Erwerbsdatum des Ausrüstungsgegenstands.
     */
    public GregorianCalendar getAcquisitionDate() {
        return acquisitionDate;
    }

    /**
     * Setzt das Erwerbsdatum des Ausrüstungsgegenstands.
     *
     * @param acquisitionDate Das Erwerbsdatum des Ausrüstungsgegenstands.
     */
    public void setAcquisitionDate(GregorianCalendar acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    /**
     * Gibt das Datum der letzten Wartung des Ausrüstungsgegenstands zurück.
     *
     * @return Das Datum der letzten Wartung des Ausrüstungsgegenstands.
     */
    public GregorianCalendar getLastMaintenanceDate() {
        return lastMaintenanceDate;
    }

    /**
     * Setzt das Datum der letzten Wartung des Ausrüstungsgegenstands.
     *
     * @param lastMaintenanceDate Das Datum der letzten Wartung des
     *                            Ausrüstungsgegenstands.
     */
    public void setLastMaintenanceDate(GregorianCalendar lastMaintenanceDate) {
        this.lastMaintenanceDate = lastMaintenanceDate;
    }

    /**
     * Gibt das Wartungsintervall des Ausrüstungsgegenstands zurück.
     *
     * @return Das Wartungsintervall des Ausrüstungsgegenstands in Monaten.
     */
    public int getMaintenanceInterval() {
        return maintenanceInterval;
    }

    /**
     * Setzt das Wartungsintervall des Ausrüstungsgegenstands.
     *
     * @param maintenanceInterval Das Wartungsintervall des Ausrüstungsgegenstands
     *                            in Monaten.
     */
    public void setMaintenanceInterval(int maintenanceInterval) {
        this.maintenanceInterval = maintenanceInterval;
    }

    /**
     * Gibt den Raum zurück, in dem sich der Ausrüstungsgegenstand befindet.
     *
     * @return Der Raum, in dem sich der Ausrüstungsgegenstand befindet.
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Setzt den Raum, in dem sich der Ausrüstungsgegenstand befindet.
     *
     * @param room Der Raum, in dem sich der Ausrüstungsgegenstand befindet.
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * Setzt den Namen des Ausrüstungsgegenstands.
     *
     * @param name Der Name des Ausrüstungsgegenstands.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gibt eine textuelle Repräsentation des Ausrüstungsgegenstands zurück.
     *
     * @return Eine textuelle Repräsentation des Ausrüstungsgegenstands.
     */
    public String toString() {
        return this.name;
    }

    /**
     * Überschreibt die Löschmethode der Oberklasse.
     * Entfernt das Ausrüstungsgegenstand aus dem Raum.
     */
    @Override
    public void delete() {
        room.removeEquipment(this);
    }

    /**
     * Vergleicht den Ausrüstungsgegenstand mit einem anderen Ausrüstungsgegenstand
     * anhand des Namens.
     * Wird für die Sortierung verwendet.
     *
     * @param other Der andere Ausrüstungsgegenstand, mit dem verglichen werden
     *              soll.
     * @return Eine negative ganze Zahl, wenn der Ausrüstungsgegenstand vor dem
     *         anderen Ausrüstungsgegenstand kommt,
     *         eine positive ganze Zahl, wenn der Ausrüstungsgegenstand nach dem
     *         anderen Ausrüstungsgegenstand kommt,
     *         oder 0, wenn beide Ausrüstungsgegenstände gleich sind.
     */
    @Override
    public int compareTo(Equipment other) {
        return this.name.compareTo(other.name);
    }
}
