package classes;

import java.util.ArrayList;

public class Building {
    String name;
    private int maxLevels;
    ArrayList<Level> levels = new ArrayList<Level>();
    private String address;

    public Building(String name, int maxLevels, String address) {
        this.name = name;
        this.maxLevels = maxLevels;
        this.address = address;
    }

    public void createLevel() throws InvalidException {
        if (levels.size() < maxLevels) {
            Level lvl = new Level(levels.size(), this);
            levels.add(lvl);
        } else {
            throw new InvalidException("Maximum levels reached!");
        }
    }

    public Level getLevelByLevelNumber(int number) throws InvalidException {
        if (number < 0 || number >= levels.size()) {
            throw new InvalidException("Ungültiger Level-Index: " + number);
        }
        return levels.get(number);
    }

}
