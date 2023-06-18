package classes.verwaltungsklassen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import classes.Building;

/*
 * Diese Klasse ist die Verwaltungsklasse für die Klasse Building.
 * Sie implementiert diese als Collection, macht CRUD-Operationen, Sortierung und Suche möglich.
 * 
 * @author Florian Schmidt
 * 
 * @version 1.0
 */
public class BuildingVerwaltung {
    private ArrayList<Building> buildings;

    public BuildingVerwaltung() {
        buildings = new ArrayList<>();
    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    public void addBuilding(Building building) {
        buildings.add(building);
    }

    public void removeBuilding(Building building) {
        buildings.remove(building);
    }

    public Building findBuildingByName(String name) {
        for (Building building : buildings) {
            if (building.getName().equalsIgnoreCase(name)) {
                return building;
            }
        }
        return null;
    }

    public ArrayList<Building> searchBuildingsByAddress(String address) {
        ArrayList<Building> result = new ArrayList<>();
        for (Building building : buildings) {
            if (building.getAddress().toString().contains(address)) {
                result.add(building);
            }
        }
        return result;
    }

    public ArrayList<Building> sortBuildingsByName() {
        ArrayList<Building> sortedBuildings = new ArrayList<>(buildings);
        Collections.sort(sortedBuildings);
        return sortedBuildings;
    }

    public ArrayList<Building> sortBuildingsByConstructionYear() {
        ArrayList<Building> sortedBuildings = new ArrayList<>(buildings);
        Collections.sort(sortedBuildings, Comparator.comparingInt(Building::getConstructionYear));
        return sortedBuildings;
    }

}
