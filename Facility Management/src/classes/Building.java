package classes;

import java.util.ArrayList;

import classes.verwaltungsklassen.LevelVerwaltung;

/**
 * Die Klasse Building repräsentiert ein Gebäude, das instandgehalten werden kann.
 * Sie implementiert das Comparable-Interface, um eine Vergleichsmethode für die Sortierung bereitzustellen.
 */
public class Building extends Maintainable implements Comparable<Building> {
    private String name;
    private int maxLevels;
    private LevelVerwaltung levelVerwaltung = new LevelVerwaltung();
    private Address address;
    private int employeeCount;
    private int constructionYear;
    private int parkingSpaces;

    /**
     * Konstruktor der Building-Klasse.
     * Erzeugt ein Gebäude mit dem angegebenen Namen.
     *
     * @param name Der Name des Gebäudes.
     */
    public Building(String name) {
        this.name = name;
    }

    /**
     * Konstruktor der Building-Klasse.
     * Erzeugt ein Gebäude mit dem angegebenen Namen, der maximalen Anzahl von Ebenen, Adresse, Mitarbeiterzahl,
     * Baujahr und Parkplätzen.
     *
     * @param name            Der Name des Gebäudes.
     * @param maxLevels       Die maximale Anzahl von Ebenen des Gebäudes.
     * @param address         Die Adresse des Gebäudes.
     * @param employeeCount   Die Anzahl der Mitarbeiter im Gebäude.
     * @param constructionYear Das Baujahr des Gebäudes.
     * @param parkingSpaces   Die Anzahl der Parkplätze des Gebäudes.
     */
    public Building(String name, int maxLevels, Address address, int employeeCount, int constructionYear,
                    int parkingSpaces) {
        this.name = name;
        this.maxLevels = maxLevels;
        this.address = address;
        this.employeeCount = employeeCount;
        this.constructionYear = constructionYear;
        this.parkingSpaces = parkingSpaces;
    }

    /**
     * Erzeugt eine neue Ebene mit der angegebenen maximalen Anzahl von Räumen und fügt sie dem Gebäude hinzu.
     *
     * @param maxRooms Die maximale Anzahl von Räumen für die neue Ebene.
     * @return Die erstellte Ebene.
     */
    public Level createLevel(int maxRooms) {
        Level lvl = new Level(levelVerwaltung.getLevels().size(), this, maxRooms);
        levelVerwaltung.addLevel(lvl);
        return lvl;
    }

    /**
     * Gibt die Ebene mit der angegebenen Ebenennummer zurück.
     *
     * @param number Die Ebenennummer der gesuchten Ebene.
     * @return Die Ebene mit der angegebenen Ebenennummer.
     * @throws InvalidException Wenn die Ebenennummer ungültig ist.
     */
    public Level getLevelByLevelNumber(int number) throws InvalidException {
        if (number < 0 || number >= levelVerwaltung.getLevels().size()) {
            throw new InvalidException("Ungültiger Level-Index: " + number);
        }
        return levelVerwaltung.getLevels().get(number);
    }

    /**
     * Überschreibt die Löschmethode der Oberklasse.
     * Löscht das Gebäude aus den globalen Daten und gibt eine Meldung aus.
     */
    @Override
    public void delete() {
        GlobalData.deleteBuilding(this);
        System.out.println("aus building: delete " + this.name);
    }

    /**
     * Entfernt eine Ebene aus dem Gebäude.
     *
     * @param level Die zu entfernende Ebene.
     */
    public void deleteLevel(Level level) {
        this.levelVerwaltung.removeLevel(level);
    }

    /**
     * Gibt eine Liste aller Ebenen des Gebäudes zurück.
     *
     * @return Eine Liste aller Ebenen des Gebäudes.
     */
    public ArrayList<Level> getLevels() {
        return levelVerwaltung.getLevels();
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
     * Setzt den Namen des Gebäudes.
     *
     * @param name Der Name des Gebäudes.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gibt die Adresse des Gebäudes zurück.
     *
     * @return Die Adresse des Gebäudes.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Setzt die Adresse des Gebäudes.
     *
     * @param address Die Adresse des Gebäudes.
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Gibt die maximale Anzahl von Ebenen des Gebäudes zurück.
     *
     * @return Die maximale Anzahl von Ebenen des Gebäudes.
     */
    public int getMaxLevels() {
        return maxLevels;
    }

    /**
     * Setzt die maximale Anzahl von Ebenen des Gebäudes.
     *
     * @param maxLevels Die maximale Anzahl von Ebenen des Gebäudes.
     */
    public void setMaxLevels(int maxLevels) {
        this.maxLevels = maxLevels;
    }

    /**
     * Gibt die Anzahl der Mitarbeiter im Gebäude zurück.
     *
     * @return Die Anzahl der Mitarbeiter im Gebäude.
     */
    public int getEmployeeCount() {
        return employeeCount;
    }

    /**
     * Setzt die Anzahl der Mitarbeiter im Gebäude.
     *
     * @param employeeCount Die Anzahl der Mitarbeiter im Gebäude.
     */
    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    /**
     * Gibt das Baujahr des Gebäudes zurück.
     *
     * @return Das Baujahr des Gebäudes.
     */
    public int getConstructionYear() {
        return constructionYear;
    }

    /**
     * Setzt das Baujahr des Gebäudes.
     *
     * @param constructionYear Das Baujahr des Gebäudes.
     */
    public void setConstructionYear(int constructionYear) {
        this.constructionYear = constructionYear;
    }

    /**
     * Gibt die Anzahl der Parkplätze des Gebäudes zurück.
     *
     * @return Die Anzahl der Parkplätze des Gebäudes.
     */
    public int getParkingSpaces() {
        return parkingSpaces;
    }

    /**
     * Setzt die Anzahl der Parkplätze des Gebäudes.
     *
     * @param parkingSpaces Die Anzahl der Parkplätze des Gebäudes.
     */
    public void setParkingSpaces(int parkingSpaces) {
        this.parkingSpaces = parkingSpaces;
    }

    /**
     * Gibt eine textuelle Repräsentation des Gebäudes zurück.
     *
     * @return Eine textuelle Repräsentation des Gebäudes.
     */
    public String toString() {
        return "Building " + this.name;
    }

    /**
     * Vergleicht das Gebäude mit einem anderen Gebäude anhand des Namens.
     * Wird für die Sortierung verwendet.
     *
     * @param other Das andere Gebäude, mit dem verglichen werden soll.
     * @return Eine negative ganze Zahl, wenn das Gebäude vor dem anderen Gebäude kommt,
     *         eine positive ganze Zahl, wenn das Gebäude nach dem anderen Gebäude kommt,
     *         oder 0, wenn beide Gebäude gleich sind.
     */
    @Override
    public int compareTo(Building other) {
        return this.name.toLowerCase().compareTo(other.name.toLowerCase());
    }
}
