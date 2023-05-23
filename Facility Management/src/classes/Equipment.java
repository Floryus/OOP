package classes;

import enums.EquipStatusEnum;
import enums.EquipTypeEnum;

import java.time.LocalDate;

public class Equipment implements Comparable<Equipment> {
    private String name;
    private EquipTypeEnum equipType;
    private EquipStatusEnum equipStatus;
    private LocalDate acquisitionDate;
    private LocalDate lastMaintenanceDate;
    private MaintenanceInterval maintenanceInterval;
    private Room room;

    public Equipment(String name, EquipTypeEnum equipType, LocalDate acquisitionDate, MaintenanceInterval maintenanceInterval, Room room) {
        this.name = name;
        this.equipType = equipType;
        this.equipStatus = EquipStatusEnum.ACTIVE;
        this.acquisitionDate = acquisitionDate;
        this.lastMaintenanceDate = acquisitionDate;
        this.maintenanceInterval = maintenanceInterval;
        this.room = room;
    }

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

    public LocalDate getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(LocalDate acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public LocalDate getLastMaintenanceDate() {
        return lastMaintenanceDate;
    }

    public void setLastMaintenanceDate(LocalDate lastMaintenanceDate) {
        this.lastMaintenanceDate = lastMaintenanceDate;
    }

    public MaintenanceInterval getMaintenanceInterval() {
        return maintenanceInterval;
    }

    public void setMaintenanceInterval(MaintenanceInterval maintenanceInterval) {
        this.maintenanceInterval = maintenanceInterval;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(Equipment other) {
        return this.name.compareTo(other.name);
    }
}
