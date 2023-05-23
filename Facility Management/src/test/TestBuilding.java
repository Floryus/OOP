package test;
import classes.*;


public class TestBuilding {
    public static void testBuildingMethods() {
        Building building = new Building("Building A");

        // Test getName() method
        if (!"Building A".equals(building.getName())) {
            System.err.println("getName() method failed!");
        }

        // Test getMaxLevels() method
        int expectedMaxLevels = 0;
        int actualMaxLevels = building.getMaxLevels();
        if (expectedMaxLevels != actualMaxLevels) {
            System.err.println("getMaxLevels() method failed!");
        }

        // Test getAddress() method
        if (building.getAddress() != null) {
            System.err.println("getAddress() method failed!");
        }

        // Test getEmployeeCount() method
        int expectedEmployeeCount = 0;
        int actualEmployeeCount = building.getEmployeeCount();
        if (expectedEmployeeCount != actualEmployeeCount) {
            System.err.println("getEmployeeCount() method failed!");
        }

        // Test getConstructionYear() method
        int expectedConstructionYear = 0;
        int actualConstructionYear = building.getConstructionYear();
        if (expectedConstructionYear != actualConstructionYear) {
            System.err.println("getConstructionYear() method failed!");
        }

        // Test getParkingSpaces() method
        int expectedParkingSpaces = 0;
        int actualParkingSpaces = building.getParkingSpaces();
        if (expectedParkingSpaces != actualParkingSpaces) {
            System.err.println("getParkingSpaces() method failed!");
        }

        // Test createLevel() method
        Level level = building.createLevel(5);
        if (!building.getLevels().contains(level)) {
            System.err.println("createLevel() method failed!");
        }

        // Test getLevelByLevelNumber() method
        try {
            Level retrievedLevel = building.getLevelByLevelNumber(0);
            if (retrievedLevel != level) {
                System.err.println("getLevelByLevelNumber() method failed!");
            }
        } catch (InvalidException e) {
            System.err.println("getLevelByLevelNumber() method failed!");
        }

        // Test deleteLevel() method
        building.deleteLevel(level);
        if (building.getLevels().contains(level)) {
            System.err.println("deleteLevel() method failed!");
        }

        // Test toString() method
        String expectedToString = "Building Building A with 0 levels. Address: null";
        String actualToString = building.toString();
        if (!expectedToString.equals(actualToString)) {
            System.err.println("toString() method failed!");
        }

        // Test compareTo() method
        Building otherBuilding = new Building("Building B");
        int compareToResult = building.compareTo(otherBuilding);
        if (compareToResult >= 0) {
            System.err.println("compareTo() method failed!");
        }
    }
}
