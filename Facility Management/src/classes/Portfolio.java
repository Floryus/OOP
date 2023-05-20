package classes;

import java.util.ArrayList;

public class Portfolio implements Comparable<Portfolio> {

    String name;
    public static ArrayList<Building> buildings = new ArrayList<>();

    public Portfolio(String name) {
        this.name = name;
    }

    public static ArrayList<Building> getBuildings() {
        return buildings;
    }

    public static void addBuilding(Building building) {
        buildings.add(building);
    }

    public String toString() {
        String message = "Portfolio " + this.name + " contains:\n";
        for (Building building : buildings) {
            message += building.name + "\n";
        }
        return message;
    }

    // Das Portfolio mit den meisten buildings zuerst
    @Override
    public int compareTo(Portfolio other) {
        if (this.buildings.size() > other.buildings.size()) {
            return -1;
        } else if (this.buildings.size() > other.buildings.size()) {
            return 1;
        } else {
            return 0;
        }
    }

}
