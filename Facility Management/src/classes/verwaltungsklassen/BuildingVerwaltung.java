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

/**
 * Die Klasse BuildingVerwaltung verwaltet eine Liste von Gebäuden.
 */
public class BuildingVerwaltung {
    private ArrayList<Building> buildings;

    /**
     * Konstruktor der BuildingVerwaltung-Klasse.
     * Erzeugt eine leere Liste von Gebäuden.
     */
    public BuildingVerwaltung() {
        buildings = new ArrayList<>();
    }

    /**
     * Gibt die Liste aller Gebäude zurück.
     *
     * @return Die Liste aller Gebäude.
     */
    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    /**
     * Fügt ein Gebäude zur Liste hinzu.
     *
     * @param building Das hinzuzufügende Gebäude.
     */
    public void addBuilding(Building building) {
        buildings.add(building);
    }

    /**
     * Entfernt ein Gebäude aus der Liste.
     *
     * @param building Das zu entfernende Gebäude.
     */
    public void removeBuilding(Building building) {
        buildings.remove(building);
    }

    /**
     * Sucht ein Gebäude anhand seines Namens in der Liste.
     *
     * @param name Der Name des gesuchten Gebäudes.
     * @return Das Gebäude mit dem angegebenen Namen oder null, wenn kein Gebäude gefunden wurde.
     */
    public Building findBuildingByName(String name) {
        for (Building building : buildings) {
            if (building.getName().equalsIgnoreCase(name)) {
                return building;
            }
        }
        return null;
    }

    /**
     * Sucht Gebäude anhand ihrer Adresse in der Liste.
     *
     * @param address Die Adresse, nach der gesucht werden soll.
     * @return Eine Liste von Gebäuden, deren Adresse den angegebenen Suchkriterien entspricht.
     */
    public ArrayList<Building> searchBuildingsByAddress(String address) {
        ArrayList<Building> result = new ArrayList<>();
        for (Building building : buildings) {
            if (building.getAddress().toString().contains(address)) {
                result.add(building);
            }
        }
        return result;
    }

    /**
     * Sortiert die Liste der Gebäude nach ihrem Namen.
     *
     * @return Eine sortierte Liste der Gebäude nach ihrem Namen.
     */
    public ArrayList<Building> sortBuildingsByName() {
        ArrayList<Building> sortedBuildings = new ArrayList<>(buildings);
        Collections.sort(sortedBuildings);
        return sortedBuildings;
    }

    /**
     * Sortiert die Liste der Gebäude nach ihrem Baujahr.
     *
     * @return Eine sortierte Liste der Gebäude nach ihrem Baujahr.
     */
    public ArrayList<Building> sortBuildingsByConstructionYear() {
        ArrayList<Building> sortedBuildings = new ArrayList<>(buildings);
        Collections.sort(sortedBuildings, Comparator.comparingInt(Building::getConstructionYear));
        return sortedBuildings;
    }

}
