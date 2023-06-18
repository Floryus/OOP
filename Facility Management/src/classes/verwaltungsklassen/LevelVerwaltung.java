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
public class LevelVerwaltung {
    private ArrayList<Level> levels;

    public LevelVerwaltung() {
        levels = new ArrayList<>();
    }

    public ArrayList<Level> getLevels() {
        return levels;
    }

    public void addLevel(Level level) {
        levels.add(level);
    }

    public void removeLevel(Level level) {
        levels.remove(level);
    }

    public Level findLevelByNumber(int levelNumber) {
        for (Level level : levels) {
            if (level.getLevelNumber() == levelNumber) {
                return level;
            }
        }
        return null;
    }

    public ArrayList<Level> getLevelsByBuilding(Building building) {
        ArrayList<Level> result = new ArrayList<>();
        for (Level level : levels) {
            if (level.getBuilding() == building) {
                result.add(level);
            }
        }
        return result;
    }

    public ArrayList<Level> sortLevelsByBuildingAndNumber() {
        ArrayList<Level> sortedLevels = new ArrayList<>(levels);
        Collections.sort(sortedLevels);
        return sortedLevels;
    }
}
