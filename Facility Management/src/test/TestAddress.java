package test;
import classes.*;

public class TestAddress {

    public static void testAddressMethods() {
        Address address = new Address("Main Street", 123, 45678, "Cityville");

        // Test getStreet() method
        try {
            String street = address.getStreet();
            if (!"Main Street".equals(street)) {
                throw new Error("getStreet() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test setStreet() method
        try {
            address.setStreet("New Street");
            String street = address.getStreet();
            if (!"New Street".equals(street)) {
                throw new Error("setStreet() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test getHouseNumber() method
        try {
            int houseNumber = address.getHouseNumber();
            if (123 != houseNumber) {
                throw new Error("getHouseNumber() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test setHouseNumber() method
        try {
            address.setHouseNumber(456);
            int houseNumber = address.getHouseNumber();
            if (456 != houseNumber) {
                throw new Error("setHouseNumber() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test getPostalCode() method
        try {
            int postalCode = address.getPostalCode();
            if (45678 != postalCode) {
                throw new Error("getPostalCode() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test setPostalCode() method
        try {
            address.setPostalCode(78901);
            int postalCode = address.getPostalCode();
            if (78901 != postalCode) {
                throw new Error("setPostalCode() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test getCity() method
        try {
            String city = address.getCity();
            if (!"Cityville".equals(city)) {
                throw new Error("getCity() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test setCity() method
        try {
            address.setCity("Townville");
            String city = address.getCity();
            if (!"Townville".equals(city)) {
                throw new Error("setCity() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test toString() method
        try {
            String addressString = address.toString();
            if (!"456 New Street, 78901 Townville".equals(addressString)) {
                throw new Error("toString() method failed!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
