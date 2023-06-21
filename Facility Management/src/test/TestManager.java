package test;

public class TestManager {
    public static void testMethods(){
        TestAddress.testAddressMethods();
        TestBuilding.testBuildingMethods();
        TestEmployee.testEmployeeMethods();
        TestEquipment.testEquipmentMethods();
        TestLevel.testLevelMethods();
        TestRoom.testRoomMethods();
        //TODO: rework next maintenance of class task
        //TestTask.testTaskMethods();
        TestTicket.testTicketMethods();
        System.out.println("all classes successfully tested");
    }
    
}
