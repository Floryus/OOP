package classes;

import java.util.ArrayList;

public class Portfolio {
    public static ArrayList<Building> buildings = new ArrayList<>();

    public static ArrayList<Building> getBuildings() {
        return buildings;
    }

    public static void addBuilding(Building building) {
        buildings.add(building);
    }
}
