package classes.verwaltungsklassen;

import java.util.ArrayList;
import java.util.Collections;

import classes.Building;
import classes.Level;

/*
 * Diese Klasse ist die Verwaltungsklasse für die Klasse Level.
 * Sie implementiert diese als Collection, macht CRUD-Operationen, Sortierung und Suche möglich.
 * 
 * @version 1.0
 * 
 * @author Florian Schmidt
 */


/**
 * Die Klasse LevelVerwaltung verwaltet eine Liste von Ebenen.
 */
public class LevelVerwaltung {
    private ArrayList<Level> levels;

    /**
     * Konstruktor der LevelVerwaltung-Klasse.
     * Erzeugt eine leere Liste von Ebenen.
     */
    public LevelVerwaltung() {
        levels = new ArrayList<>();
    }

    /**
     * Gibt die Liste aller Ebenen zurück.
     *
     * @return Die Liste aller Ebenen.
     */
    public ArrayList<Level> getLevels() {
        return levels;
    }

    /**
     * Fügt eine Ebene zur Liste hinzu.
     *
     * @param level Die hinzuzufügende Ebene.
     */
    public void addLevel(Level level) {
        levels.add(level);
    }

    /**
     * Entfernt eine Ebene aus der Liste.
     *
     * @param level Die zu entfernende Ebene.
     */
    public void removeLevel(Level level) {
        levels.remove(level);
    }

    /**
     * Sucht eine Ebene anhand ihrer Ebenennummer in der Liste.
     *
     * @param levelNumber Die Ebenennummer der gesuchten Ebene.
     * @return Die Ebene mit der angegebenen Ebenennummer oder null, wenn keine Ebene gefunden wurde.
     */
    public Level findLevelByNumber(int levelNumber) {
        for (Level level : levels) {
            if (level.getLevelNumber() == levelNumber) {
                return level;
            }
        }
        return null;
    }

    /**
     * Gibt eine Liste von Ebenen zurück, die zu einem bestimmten Gebäude gehören.
     *
     * @param building Das Gebäude, nach dem gesucht werden soll.
     * @return Eine Liste von Ebenen, die zu dem angegebenen Gebäude gehören.
     */
    public ArrayList<Level> getLevelsByBuilding(Building building) {
        ArrayList<Level> result = new ArrayList<>();
        for (Level level : levels) {
            if (level.getBuilding() == building) {
                result.add(level);
            }
        }
        return result;
    }

    /**
     * Sortiert die Liste der Ebenen nach Gebäude und Ebenennummer.
     *
     * @return Eine sortierte Liste der Ebenen nach Gebäude und Ebenennummer.
     */
    public ArrayList<Level> sortLevelsByBuildingAndNumber() {
        ArrayList<Level> sortedLevels = new ArrayList<>(levels);
        Collections.sort(sortedLevels);
        return sortedLevels;
    }
}
