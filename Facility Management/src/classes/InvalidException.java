package classes;

/**
 * Die Klasse InvalidException ist eine benutzerdefinierte Ausnahme (Exception), die verwendet wird,
 * um eine ungültige Aktion oder einen ungültigen Zustand in der Facility Management Software darzustellen.
 * Sie erbt von der Klasse `Exception`.
 */
public class InvalidException extends Exception {
    /**
     * Konstruktor für die InvalidException-Klasse.
     *
     * @param message Die Fehlermeldung, die die ungültige Aktion oder den ungültigen Zustand beschreibt.
     */
    public InvalidException(String message) {
        super(message);
    }
}
