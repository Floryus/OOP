package classes.verwaltungsklassen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import classes.Equipment;
import classes.Room;

/**
 * Die Klasse EquipmentVerwaltung verwaltet eine Liste von Geräten.
 */
public class EquipmentVerwaltung {
    private ArrayList<Equipment> equipmentList;

    /**
     * Konstruktor der EquipmentVerwaltung-Klasse.
     * Erzeugt eine leere Liste von Geräten.
     */
    public EquipmentVerwaltung() {
        equipmentList = new ArrayList<>();
    }

    /**
     * Gibt die Liste aller Geräte zurück.
     *
     * @return Die Liste aller Geräte.
     */
    public ArrayList<Equipment> getEquipmentList() {
        return equipmentList;
    }

    /**
     * Fügt ein Gerät zur Liste hinzu.
     *
     * @param equipment Das hinzuzufügende Gerät.
     */
    public void addEquipment(Equipment equipment) {
        equipmentList.add(equipment);
    }

    /**
     * Entfernt ein Gerät aus der Liste.
     *
     * @param equipment Das zu entfernende Gerät.
     */
    public void removeEquipment(Equipment equipment) {
        equipmentList.remove(equipment);
    }

    /**
     * Sucht ein Gerät anhand seines Namens in der Liste.
     *
     * @param name Der Name des gesuchten Geräts.
     * @return Das Gerät mit dem angegebenen Namen oder null, wenn kein Gerät gefunden wurde.
     */
    public Equipment findEquipmentByName(String name) {
        for (Equipment equipment : equipmentList) {
            if (equipment.getName().equalsIgnoreCase(name)) {
                return equipment;
            }
        }
        return null;
    }

    /**
     * Gibt eine Liste von Geräten zurück, die sich in einem bestimmten Raum befinden.
     *
     * @param room Der Raum, nach dem gesucht werden soll.
     * @return Eine Liste von Geräten, die sich in dem angegebenen Raum befinden.
     */
    public ArrayList<Equipment> getEquipmentByRoom(Room room) {
        ArrayList<Equipment> result = new ArrayList<>();
        for (Equipment equipment : equipmentList) {
            if (equipment.getRoom() == room) {
                result.add(equipment);
            }
        }
        return result;
    }

    /**
     * Sortiert die Liste der Geräte nach ihrem Namen.
     *
     * @return Eine sortierte Liste der Geräte nach ihrem Namen.
     */
    public ArrayList<Equipment> sortEquipmentByName() {
        ArrayList<Equipment> sortedEquipment = new ArrayList<>(equipmentList);
        Collections.sort(sortedEquipment);
        return sortedEquipment;
    }

    // Weitere Sortier- und Suchmethoden können nach Bedarf hinzugefügt werden
}
