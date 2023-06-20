package test;
import classes.*;


public class TestBuilding {
    public static void testBuildingMethods() {
        Building building = new Building("Building A");

        // Test getName() method
        try {
            String name = building.getName();
            if (!"Building A".equals(name)) {
                throw new Error("getName() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test getMaxLevels() method
        try {
            int expectedMaxLevels = 0;
            int actualMaxLevels = building.getMaxLevels();
            if (expectedMaxLevels != actualMaxLevels) {
                throw new Error("getMaxLevels() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test getAddress() method
        try {
            if (building.getAddress() != null) {
                throw new Error("getAddress() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test getEmployeeCount() method
        try {
            int expectedEmployeeCount = 0;
            int actualEmployeeCount = building.getEmployeeCount();
            if (expectedEmployeeCount != actualEmployeeCount) {
                throw new Error("getEmployeeCount() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test getConstructionYear() method
        try {
            int expectedConstructionYear = 0;
            int actualConstructionYear = building.getConstructionYear();
            if (expectedConstructionYear != actualConstructionYear) {
                throw new Error("getConstructionYear() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test getParkingSpaces() method
        try {
            int expectedParkingSpaces = 0;
            int actualParkingSpaces = building.getParkingSpaces();
            if (expectedParkingSpaces != actualParkingSpaces) {
                throw new Error("getParkingSpaces() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test createLevel() method
        try {
            Level level = building.createLevel(5);
            if (!building.getLevels().contains(level)) {
                throw new Error("createLevel() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test deleteLevel() method
        try {
            Level level = building.createLevel(5);
            building.deleteLevel(level);
            if (building.getLevels().contains(level)) {
                throw new Error("deleteLevel() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test toString() method
        try {
            String expectedToString = "Building Building A";
            String actualToString = building.toString();
            if (!expectedToString.equals(actualToString)) {
                throw new Error("toString() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test compareTo() method
        try {
            Building otherBuilding = new Building("Building B");
            int compareToResult = building.compareTo(otherBuilding);
            if (compareToResult >= 0) {
                throw new Error("compareTo() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
