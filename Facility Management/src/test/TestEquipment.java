package test;

import classes.Equipment;
import classes.Room;
import enums.EquipStatusEnum;
import enums.EquipTypeEnum;

import java.util.GregorianCalendar;

public class TestEquipment {
    public static void testEquipmentMethods() {
        GregorianCalendar acquisitionDate = new GregorianCalendar(2021, 0, 1);
        Room room = new Room(null, null, null);
        Equipment equipment = new Equipment("Equipment A", EquipTypeEnum.PRINTER, acquisitionDate, 6, room);

        // Test getName() method
        if (!"Equipment A".equals(equipment.getName())) {
            System.err.println("getName() method failed!");
        }

        // Test getEquipType() method
        if (EquipTypeEnum.PRINTER != equipment.getEquipType()) {
            System.err.println("getEquipType() method failed!");
        }

        // Test setEquipType() method
        equipment.setEquipType(EquipTypeEnum.PRINTER);
        if (EquipTypeEnum.PRINTER != equipment.getEquipType()) {
            System.err.println("setEquipType() method failed!");
        }

        // Test getEquipStatus() method
        if (EquipStatusEnum.ACTIVE != equipment.getEquipStatus()) {
            System.err.println("getEquipStatus() method failed!");
        }

        // Test setEquipStatus() method
        equipment.setEquipStatus(EquipStatusEnum.INACTIVE);
        if (EquipStatusEnum.INACTIVE != equipment.getEquipStatus()) {
            System.err.println("setEquipStatus() method failed!");
        }

        // Test getAcquisitionDate() method
        if (!acquisitionDate.equals(equipment.getAcquisitionDate())) {
            System.err.println("getAcquisitionDate() method failed!");
        }

        // Test setAcquisitionDate() method
        GregorianCalendar newAcquisitionDate = new GregorianCalendar(2022, 0, 1);
        equipment.setAcquisitionDate(newAcquisitionDate);
        if (!newAcquisitionDate.equals(equipment.getAcquisitionDate())) {
            System.err.println("setAcquisitionDate() method failed!");
        }

        // Test getLastMaintenanceDate() method
        GregorianCalendar expectedLastMaintenanceDate = new GregorianCalendar(2021, 6, 1);
        GregorianCalendar actualLastMaintenanceDate = equipment.getLastMaintenanceDate();
        if (!expectedLastMaintenanceDate.equals(actualLastMaintenanceDate)) {
            System.err.println("getLastMaintenanceDate() method failed!");
        }

        // Test setLastMaintenanceDate() method
        GregorianCalendar newLastMaintenanceDate = new GregorianCalendar(2022, 6, 1);
        equipment.setLastMaintenanceDate(newLastMaintenanceDate);
        if (!newLastMaintenanceDate.equals(equipment.getLastMaintenanceDate())) {
            System.err.println("setLastMaintenanceDate() method failed!");
        }

        // Test getMaintenanceInterval() method
        int expectedMaintenanceInterval = 6;
        int actualMaintenanceInterval = equipment.getMaintenanceInterval();
        if (expectedMaintenanceInterval != actualMaintenanceInterval) {
            System.err.println("getMaintenanceInterval() method failed!");
        }

        // Test setMaintenanceInterval() method
        int newMaintenanceInterval = 12;
        equipment.setMaintenanceInterval(newMaintenanceInterval);
        if (newMaintenanceInterval != equipment.getMaintenanceInterval()) {
            System.err.println("setMaintenanceInterval() method failed!");
        }

        // Test getRoom() method
        if (room != equipment.getRoom()) {
            System.err.println("getRoom() method failed!");
        }

        // Test setRoom() method
        Room newRoom = new Room(null, null, null);
        equipment.setRoom(newRoom);
        if (newRoom != equipment.getRoom()) {
            System.err.println("setRoom() method failed!");
        }

        // Test toString() method
        String expectedToString = "Equipment A";
        String actualToString = equipment.toString();
        if (!expectedToString.equals(actualToString)) {
            System.err.println("toString() method failed!");
        }

        // Test compareTo() method
        Equipment otherEquipment = new Equipment("Equipment B", EquipTypeEnum.PRINTER, acquisitionDate, 6, room);
        int compareToResult = equipment.compareTo(otherEquipment);
        if (compareToResult <= 0) {
            System.err.println("compareTo() method failed!");
        }
    }
}
