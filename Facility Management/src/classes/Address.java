package classes;

/**
 * Die Klasse Address repräsentiert eine Adresse mit Straße, Hausnummer, Postleitzahl und Stadt.
 */
public class Address {
    private String street;
    private int houseNumber;
    private int postalCode;
    private String city;

    /**
     * Konstruktor der Address-Klasse.
     * Erzeugt eine Adresse mit den angegebenen Werten für Straße, Hausnummer, Postleitzahl und Stadt.
     *
     * @param street      Die Straße der Adresse.
     * @param houseNumber Die Hausnummer der Adresse.
     * @param postalCode  Die Postleitzahl der Adresse.
     * @param city        Die Stadt der Adresse.
     */
    public Address(String street, int houseNumber, int postalCode, String city) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.city = city;
    }

    /**
     * Gibt die Straße der Adresse zurück.
     *
     * @return Die Straße der Adresse.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Setzt die Straße der Adresse.
     *
     * @param street Die Straße der Adresse.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Gibt die Hausnummer der Adresse zurück.
     *
     * @return Die Hausnummer der Adresse.
     */
    public int getHouseNumber() {
        return houseNumber;
    }

    /**
     * Setzt die Hausnummer der Adresse.
     *
     * @param houseNumber Die Hausnummer der Adresse.
     */
    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     * Gibt die Postleitzahl der Adresse zurück.
     *
     * @return Die Postleitzahl der Adresse.
     */
    public int getPostalCode() {
        return postalCode;
    }

    /**
     * Setzt die Postleitzahl der Adresse.
     *
     * @param postalCode Die Postleitzahl der Adresse.
     */
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Gibt die Stadt der Adresse zurück.
     *
     * @return Die Stadt der Adresse.
     */
    public String getCity() {
        return city;
    }

    /**
     * Setzt die Stadt der Adresse.
     *
     * @param city Die Stadt der Adresse.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gibt eine textuelle Repräsentation der Adresse zurück.
     *
     * @return Eine textuelle Repräsentation der Adresse im Format: Hausnummer Straße, Postleitzahl Stadt.
     */
    @Override
    public String toString() {
        return houseNumber + " " + street + ", " + postalCode + " " + city;
    }
}
