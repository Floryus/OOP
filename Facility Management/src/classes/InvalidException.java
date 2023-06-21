package classes;

/**
 * Eine benutzerdefinierte Ausnahme, die ausgelöst wird, wenn ein ungültiger
 * Zustand oder eine ungültige Operation erkannt wird.
 * 
 * @author Florian Schmidt
 * 
 * @version 1.0
 */
public class InvalidException extends Exception {
    /**
     * Konstruktor der InvalidException-Klasse.
     *
     * @param message Die Fehlermeldung, die die Ausnahme beschreibt.
     */
    public InvalidException(String message) {
        super(message);
    }
}
