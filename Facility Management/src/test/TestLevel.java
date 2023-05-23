package test;

import classes.Building;
import classes.Level;
import enums.RoomTypesEnum;

public class TestLevel {
    public static void testLevelMethods() {
        // Create test objects
        Building building = new Building("Building A");
        int levelNumber = 1;
        int maxRooms = 10;
        Level level = new Level(levelNumber, building, maxRooms);
        RoomTypesEnum roomType = RoomTypesEnum.BREAK_ROOM;

        // Test createRoom() method
        int initialRoomCount = level.getRooms().size();
        level.createRoom(roomType);
        if (level.getRooms().size() != initialRoomCount + 1) {
            System.err.println("createRoom() method failed!");
        }

        // Test createRoomNumber() method
        String roomNumber = level.createRoomNumber();
        if (!roomNumber.equals(levelNumber + "." + initialRoomCount)) {
            System.err.println("createRoomNumber() method failed!");
        }

        // Test delete() method
        level.delete();
        if (building.getLevels().contains(level)) {
            System.err.println("delete() method failed!");
        }

        // Test deleteRoom() method
        level.createRoom(roomType);
        int initialRoomCountAfterCreate = level.getRooms().size();
        level.deleteRoom(level.getRooms().get(0));
        if (level.getRooms().size() != initialRoomCountAfterCreate - 1) {
            System.err.println("deleteRoom() method failed!");
        }

        // Test toString() method
        String expectedToString = "This level is number " + levelNumber + " of " + (initialRoomCountAfterCreate - 1)
                + " in " + building.toString();
        String actualToString = level.toString();
        if (!expectedToString.equals(actualToString)) {
            System.err.println("toString() method failed!");
        }

        // Test compareTo() method
        Level otherLevel = new Level(2, building, maxRooms);
        int compareToResult = level.compareTo(otherLevel);
        if (compareToResult >= 0) {
            System.err.println("compareTo() method failed!");
        }
    }
}
