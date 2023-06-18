package classes;

import enums.EquipStatusEnum;
import enums.EquipTypeEnum;

import java.util.GregorianCalendar;

public class Equipment extends Maintainable implements Comparable<Equipment> {
    private String name;
    private EquipTypeEnum equipType;
    private EquipStatusEnum equipStatus;
    private GregorianCalendar acquisitionDate;
    private GregorianCalendar lastMaintenanceDate;
    private int maintenanceInterval;
    private Room room;

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
     * @return String
     */
    public String getName() {
        return name;
    }

    public EquipTypeEnum getEquipType() {
        return equipType;
    }

    public void setEquipType(EquipTypeEnum equipType) {
        this.equipType = equipType;
    }

    public EquipStatusEnum getEquipStatus() {
        return equipStatus;
    }

    public void setEquipStatus(EquipStatusEnum equipStatus) {
        this.equipStatus = equipStatus;
    }

    public GregorianCalendar getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(GregorianCalendar acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public GregorianCalendar getLastMaintenanceDate() {
        return lastMaintenanceDate;
    }

    public void setLastMaintenanceDate(GregorianCalendar lastMaintenanceDate) {
        this.lastMaintenanceDate = lastMaintenanceDate;
    }

    public int getMaintenanceInterval() {
        return maintenanceInterval;
    }

    public void setMaintenanceInterval(int maintenanceInterval) {
        this.maintenanceInterval = maintenanceInterval;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    @Override
    public void delete() {
        room.removeEquipment(this);
    }

    @Override
    public int compareTo(Equipment other) {
        return this.name.compareTo(other.name);
    }
}
