package classes.verwaltungsklassen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import classes.Equipment;
import classes.Room;

public class EquipmentVerwaltung {
    private ArrayList<Equipment> equipmentList;

    public EquipmentVerwaltung() {
        equipmentList = new ArrayList<>();
    }

    public ArrayList<Equipment> getEquipmentList() {
        return equipmentList;
    }

    public void addEquipment(Equipment equipment) {
        equipmentList.add(equipment);
    }

    public void removeEquipment(Equipment equipment) {
        equipmentList.remove(equipment);
    }

    public Equipment findEquipmentByName(String name) {
        for (Equipment equipment : equipmentList) {
            if (equipment.getName().equalsIgnoreCase(name)) {
                return equipment;
            }
        }
        return null;
    }

    public ArrayList<Equipment> getEquipmentByRoom(Room room) {
        ArrayList<Equipment> result = new ArrayList<>();
        for (Equipment equipment : equipmentList) {
            if (equipment.getRoom() == room) {
                result.add(equipment);
            }
        }
        return result;
    }

    public ArrayList<Equipment> sortEquipmentByName() {
        ArrayList<Equipment> sortedEquipment = new ArrayList<>(equipmentList);
        Collections.sort(sortedEquipment);
        return sortedEquipment;
    }

    // Weitere Sortier- und Suchmethoden können nach Bedarf hinzugefügt werden
}
