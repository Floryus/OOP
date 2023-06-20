package test;

import classes.Building;
import classes.Level;

public class TestLevel {
    public static void testLevelMethods() {
        // Create test objects
        Building building = new Building("Building A");
        int levelNumber = 1;
        int maxRooms = 10;
        Level level = new Level(levelNumber, building, maxRooms);

        // Test delete() method
        try {
            level.delete();
            if (building.getLevels().contains(level)) {
                throw new Error("delete() method failed!");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // Test toString() method
        try {
            String expectedToString = "This level is number " + levelNumber + " of " + (level.getRooms().size())
                    + " in " + building.toString();
            String actualToString = level.toString();
            if (!expectedToString.equals(actualToString)) {
                throw new Error("toString() method failed!");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // Test compareTo() method
        try {
            Level otherLevel = new Level(2, building, maxRooms);
            int compareToResult = level.compareTo(otherLevel);
            if (compareToResult >= 0) {
                throw new Error("compareTo() method failed!");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
