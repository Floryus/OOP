package classes;

import java.util.ArrayList;

/**
 * Die Klasse Building repräsentiert ein Gebäude in der Facility Management Software.
 * Sie implementiert das Comparable-Interface, um die Vergleichbarkeit von Gebäuden zu ermöglichen.
 */
public class Building implements Comparable<Building> {
    String name;
    private int maxLevels;
    ArrayList<Level> levels = new ArrayList<Level>();
    private String address;

    /**
     * Konstruktor für die Building-Klasse.
     *
     * @param name       Der Name des Gebäudes.
     * @param maxLevels  Die maximale Anzahl von Ebenen im Gebäude.
     * @param address    Die Adresse des Gebäudes.
     */
    Building(String name, int maxLevels, String address) {
        this.name = name;
        this.maxLevels = maxLevels;
        this.address = address;
    }

    /**
     * Erstellt eine neue Ebene im Gebäude mit der angegebenen maximalen Anzahl von Räumen.
     *
     * @param maxRooms Die maximale Anzahl von Räumen auf der Ebene.
     * @return Die erstellte Ebene.
     */
    public Level createLevel(int maxRooms) {
        Level lvl = new Level(levels.size(), this, maxRooms);
        levels.add(lvl);
        return lvl;
    }

    /**
     * Gibt die Ebene mit der angegebenen Ebenennummer zurück.
     *
     * @param number Die Ebenennummer.
     * @return Die entsprechende Ebene.
     * @throws InvalidException Wenn der angegebene Ebenenindex ungültig ist.
     */
    public Level getLevelByLevelNumber(int number) throws InvalidException {
        if (number < 0 || number >= levels.size()) {
            throw new InvalidException("Ungültiger Level-Index: " + number);
        }
        return levels.get(number);
    }

    /**
     * Gibt eine Liste aller Ebenen im Gebäude zurück.
     *
     * @return Eine Liste aller Ebenen im Gebäude.
     */
    public ArrayList<Level> getLevels() {
        return levels;
    }

    /**
     * Gibt den Namen des Gebäudes zurück.
     *
     * @return Der Name des Gebäudes.
     */
    public String getName() {
        return name;
    }

    /**
     * Gibt die Adresse des Gebäudes zurück.
     *
     * @return Die Adresse des Gebäudes.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gibt die maximale Anzahl von Ebenen im Gebäude zurück.
     *
     * @return Die maximale Anzahl von Ebenen im Gebäude.
     */
    public int getMaxLevels() {
        return maxLevels;
    }

    /**
     * Gibt eine Zeichenfolgendarstellung des Gebäudes zurück.
     *
     * @return Eine Zeichenfolgendarstellung des Gebäudes.
     */
    public String toString() {
        return "Building " + this.name + " with " + this.levels.size() + " levels.";
    }

    /**
     * Vergleicht dieses Gebäude mit einem anderen Gebäude anhand ihrer Namen (case-insensitiv).
     *
     * @param other Das andere Gebäude, mit dem verglichen werden soll.
     * @return Ein negativer Integer, null oder ein positiver Integer, je nachdem, ob dieses Gebäude
     *         vor, gleich oder nach dem anderen Gebäude liegt.
     */
    @Override
    public int compareTo(Building other) {
        return this.name.toLowerCase().compareTo(other.name.toLowerCase());
    }
}
