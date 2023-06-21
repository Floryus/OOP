package test;

public class TestManager {

    public static int testCount = 0;
    public static int failedTests = 0;

    public static void testMethods() {
        TestAddress.testAddressMethods();
        TestBuilding.testBuildingMethods();
        TestEmployee.testEmployeeMethods();
        TestEquipment.testEquipmentMethods();
        TestLevel.testLevelMethods();
        TestRoom.testRoomMethods();
        // TODO: rework next maintenance of class task
        // TestTask.testTaskMethods();
        TestTicket.testTicketMethods();
        if (failedTests > 0) {
            System.out.println("failed tests: " + failedTests + " of " + testCount);
        } else {
            System.out.println("all tests passed");
        }
    }

}
