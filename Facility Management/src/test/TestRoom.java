package test;

import java.util.GregorianCalendar;
import java.util.List;

import classes.Building;
import classes.Level;
import classes.Room;
import classes.Equipment;
import enums.EquipTypeEnum;
import enums.RoomFlooringEnum;

public class TestRoom {
    public static void testRoomMethods() {
        // Create test objects
        Building building = new Building("Building A");
        Level level = new Level(1, building, 10);
        Room room = new Room(building, level);
        RoomFlooringEnum flooring = RoomFlooringEnum.CARPET;
        double length = 10.0;
        double width = 8.0;
        double height = 3.0;
        int seatCount = 20;

        // Test getName() method
        String name = room.getName();
        if (name == null) {
            System.err.println("getName() method failed!");
        }

        // Test getBuilding() method
        Building roomBuilding = room.getBuilding();
        if (roomBuilding != building) {
            System.err.println("getBuilding() method failed!");
        }

        // Test getLevel() method
        Level roomLevel = room.getLevel();
        if (roomLevel != level) {
            System.err.println("getLevel() method failed!");
        }

        // Test setLength() and getLength() methods
        room.setLength(length);
        double roomLength = room.getLength();
        if (roomLength != length) {
            System.err.println("setLength() or getLength() methods failed!");
        }

        // Test setWidth() and getWidth() methods
        room.setWidth(width);
        double roomWidth = room.getWidth();
        if (roomWidth != width) {
            System.err.println("setWidth() or getWidth() methods failed!");
        }

        // Test setHeight() and getHeight() methods
        room.setHeight(height);
        double roomHeight = room.getHeight();
        if (roomHeight != height) {
            System.err.println("setHeight() or getHeight() methods failed!");
        }

        // Test setFlooring() and getFlooring() methods
        room.setFlooring(flooring);
        RoomFlooringEnum roomFlooring = room.getFlooring();
        if (roomFlooring != flooring) {
            System.err.println("setFlooring() or getFlooring() methods failed!");
        }

        // Test getEquipmentList(), addEquipment(), and removeEquipment() methods
        Equipment equipment = new Equipment("Equipment 1", EquipTypeEnum.CAMERA, new GregorianCalendar(), 6, room);
        room.addEquipment(equipment);
        List<Equipment> equipmentList = room.getEquipmentList();
        if (!equipmentList.contains(equipment)) {
            System.err.println("getEquipmentList(), addEquipment(), or removeEquipment() methods failed!");
        }
        room.removeEquipment(equipment);
        if (equipmentList.contains(equipment)) {
            System.err.println("getEquipmentList(), addEquipment(), or removeEquipment() methods failed!");
        }

        // Test setSeatCount() and getSeatCount() methods
        room.setSeatCount(seatCount);
        int roomSeatCount = room.getSeatCount();
        if (roomSeatCount != seatCount) {
            System.err.println("setSeatCount() or getSeatCount() methods failed!");
        }

        // Test toString() method
        String expectedToString = room.getName() + " on level " + room.getLevel().getLevelNumber() + " in "
                + room.getBuilding().getName();
        String actualToString = room.toString();
        if (!expectedToString.equals(actualToString)) {
            System.err.println("toString() method failed!");
        }

        // Test compareTo() method
        Room otherRoom = new Room(building, level);
        int compareToResult = room.compareTo(otherRoom);
        if (compareToResult != 0) {
            System.err.println("compareTo() method failed!");
        }
    }
}
