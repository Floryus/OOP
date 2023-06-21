package classes;

/**
 * Die abstrakte Klasse Maintainable definiert eine grundlegende Schnittstelle
 * für Objekte, die verwaltet und gelöscht werden können.
 * 
 * @author Florian Schmidt
 * 
 * @version 1.0
 */
public abstract class Maintainable {
    /**
     * Diese Methode wird aufgerufen, um das Objekt zu löschen.
     * Sie kann in den Unterklassen überschrieben werden, um spezifisches
     * Löschverhalten zu implementieren.
     */
    public void delete() {
        // Standardimplementierung: Keine Aktion erforderlich
    };
}
