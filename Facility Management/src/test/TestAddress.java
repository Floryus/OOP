package test;
import classes.*;

public class TestAddress {

    public static void testAddressMethods() {
        Address address = new Address("Main Street", 123, 45678, "Cityville");

        // Test getStreet() method
        if (!"Main Street".equals(address.getStreet())) {
            System.err.println("getStreet() method failed!");
        }

        // Test setStreet() method
        address.setStreet("New Street");
        if (!"New Street".equals(address.getStreet())) {
            System.err.println("setStreet() method failed!");
        }

        // Test getHouseNumber() method
        if (123 != address.getHouseNumber()) {
            System.err.println("getHouseNumber() method failed!");
        }

        // Test setHouseNumber() method
        address.setHouseNumber(456);
        if (456 != address.getHouseNumber()) {
            System.err.println("setHouseNumber() method failed!");
        }

        // Test getPostalCode() method
        if (45678 != address.getPostalCode()) {
            System.err.println("getPostalCode() method failed!");
        }

        // Test setPostalCode() method
        address.setPostalCode(78901);
        if (78901 != address.getPostalCode()) {
            System.err.println("setPostalCode() method failed!");
        }

        // Test getCity() method
        if (!"Cityville".equals(address.getCity())) {
            System.err.println("getCity() method failed!");
        }

        // Test setCity() method
        address.setCity("Townville");
        if (!"Townville".equals(address.getCity())) {
            System.err.println("setCity() method failed!");
        }

        // Test toString() method
        if (!"456 New Street, 78901 Townville".equals(address.toString())) {
            System.err.println("toString() method failed!");
        }
    }
}
