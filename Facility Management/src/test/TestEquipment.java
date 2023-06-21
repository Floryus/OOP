package test;

import classes.Building;
import classes.Equipment;
import classes.Room;
import enums.EquipStatusEnum;
import enums.EquipTypeEnum;

import java.util.GregorianCalendar;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class TestEquipment {
    public static void testEquipmentMethods() {
        GregorianCalendar acquisitionDate = new GregorianCalendar(2021, 0, 1);
        Room room = new Room(new Building("Building A"), null, null, null);
        Equipment equipment = new Equipment("Equipment A", EquipTypeEnum.PRINTER, acquisitionDate, 6, room);

        // Test getName() method
        try {
            if (!"Equipment A".equals(equipment.getName())) {
                throw new Error("getName() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test getEquipType() method
        try {
            if (EquipTypeEnum.PRINTER != equipment.getEquipType()) {
                throw new Error("getEquipType() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test setEquipType() method
        try {
            equipment.setEquipType(EquipTypeEnum.PRINTER);
            if (EquipTypeEnum.PRINTER != equipment.getEquipType()) {
                throw new Error("setEquipType() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test getEquipStatus() method
        try {
            if (EquipStatusEnum.ACTIVE != equipment.getEquipStatus()) {
                throw new Error("getEquipStatus() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test setEquipStatus() method
        try {
            equipment.setEquipStatus(EquipStatusEnum.INACTIVE);
            if (EquipStatusEnum.INACTIVE != equipment.getEquipStatus()) {
                throw new Error("setEquipStatus() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test getAcquisitionDate() method
        try {
            if (!acquisitionDate.equals(equipment.getAcquisitionDate())) {
                throw new Error("getAcquisitionDate() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test setAcquisitionDate() method
        try {
            GregorianCalendar newAcquisitionDate = new GregorianCalendar(2022, 0, 1);
            equipment.setAcquisitionDate(newAcquisitionDate);
            if (!newAcquisitionDate.equals(equipment.getAcquisitionDate())) {
                throw new Error("setAcquisitionDate() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test getMaintenanceInterval() method
        try {
            int expectedMaintenanceInterval = 6;
            int actualMaintenanceInterval = equipment.getMaintenanceInterval();
            if (expectedMaintenanceInterval != actualMaintenanceInterval) {
                throw new Error("getMaintenanceInterval() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test setMaintenanceInterval() method
        try {
            int newMaintenanceInterval = 12;
            equipment.setMaintenanceInterval(newMaintenanceInterval);
            if (newMaintenanceInterval != equipment.getMaintenanceInterval()) {
                throw new Error("setMaintenanceInterval() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test getRoom() method
        try {
            if (room != equipment.getRoom()) {
                throw new Error("getRoom() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test setRoom() method
        try {
            Room newRoom = new Room(new Building("Building A"), null, null, null);
            equipment.setRoom(newRoom);
            if (newRoom != equipment.getRoom()) {
                throw new Error("setRoom() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test toString() method
        try {
            String expectedToString = "Equipment A";
            String actualToString = equipment.toString();
            if (!expectedToString.equals(actualToString)) {
                throw new Error("toString() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test compareTo() method
        try {
            Equipment otherEquipment = new Equipment("Equipment B", EquipTypeEnum.PRINTER, acquisitionDate, 6, room);
            int compareToResult = equipment.compareTo(otherEquipment);
            if (compareToResult >= 0) {
                throw new Error("compareTo() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
