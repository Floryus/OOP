package test;

import java.util.GregorianCalendar;
import java.util.List;

import classes.Building;
import classes.Level;
import classes.Room;
import classes.Equipment;
import enums.EquipTypeEnum;
import enums.RoomFlooringEnum;
import enums.RoomTypesEnum;

public class TestRoom {
    public static void testRoomMethods() {
        // Create test objects
        Building building = new Building("Building A");
        Level level = new Level(1, building, 10);
        Room room = new Room(building, level, null, "Room 1");
        RoomFlooringEnum flooring = RoomFlooringEnum.CARPET;
        double length = 10.0;
        double width = 8.0;
        double height = 3.0;
        int seatCount = 20;

        // Test getName() method
        try {
            String name = room.getName();
            if (name == null) {
                throw new Error("getName() method failed!");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // Test getBuilding() method
        try {
            Building roomBuilding = room.getBuilding();
            if (roomBuilding != building) {
                throw new Error("getBuilding() method failed!");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // Test getLevel() method
        try {
            Level roomLevel = room.getLevel();
            if (roomLevel != level) {
                throw new Error("getLevel() method failed!");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // Test setLength() and getLength() methods
        try {
            room.setLength(length);
            double roomLength = room.getLength();
            if (roomLength != length) {
                throw new Error("setLength() or getLength() methods failed!");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // Test setWidth() and getWidth() methods
        try {
            room.setWidth(width);
            double roomWidth = room.getWidth();
            if (roomWidth != width) {
                throw new Error("setWidth() or getWidth() methods failed!");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // Test setHeight() and getHeight() methods
        try {
            room.setHeight(height);
            double roomHeight = room.getHeight();
            if (roomHeight != height) {
                throw new Error("setHeight() or getHeight() methods failed!");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // Test setFlooring() and getFlooring() methods
        try {
            room.setFlooring(flooring);
            RoomFlooringEnum roomFlooring = room.getFlooring();
            if (roomFlooring != flooring) {
                throw new Error("setFlooring() or getFlooring() methods failed!");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // Test getEquipmentList(), addEquipment(), and removeEquipment() methods
        try {
            Equipment equipment = new Equipment("Equipment 1", EquipTypeEnum.CAMERA, new GregorianCalendar(), 6, room);
            room.addEquipment(equipment);
            List<Equipment> equipmentList = room.getEquipmentList();
            if (!equipmentList.contains(equipment)) {
                throw new Error("getEquipmentList(), addEquipment(), or removeEquipment() methods failed!");
            }
            room.removeEquipment(equipment);
            if (equipmentList.contains(equipment)) {
                throw new Error("getEquipmentList(), addEquipment(), or removeEquipment() methods failed!");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // Test setSeatCount() and getSeatCount() methods
        try {
            room.setSeatCount(seatCount);
            int roomSeatCount = room.getSeatCount();
            if (roomSeatCount != seatCount) {
                throw new Error("setSeatCount() or getSeatCount() methods failed!");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // Test toString() method
        try {
            String expectedToString = "Room "+room.getName();
            String actualToString = room.toString();
            if (!expectedToString.equals(actualToString)) {
                throw new Error("toString() method failed!");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // Test compareTo() method
        try {
            Room otherRoom = new Room(building, level, RoomTypesEnum.TECH_ROOM, "Room 2");
            int compareToResult = room.compareTo(otherRoom);
            if (compareToResult >= 0) {
                throw new Error("compareTo() method failed!");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
