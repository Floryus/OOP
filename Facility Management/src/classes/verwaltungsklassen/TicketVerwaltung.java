package classes.verwaltungsklassen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import classes.Ticket;

/**
 * Die Klasse TicketVerwaltung verwaltet eine Liste von Tickets.
 */
public class TicketVerwaltung {
    private ArrayList<Ticket> tickets;

    /**
     * Konstruktor der TicketVerwaltung-Klasse.
     * Erzeugt eine leere Liste von Tickets.
     */
    public TicketVerwaltung() {
        tickets = new ArrayList<>();
    }

    /**
     * Fügt ein Ticket zur Liste hinzu.
     *
     * @param ticket Das hinzuzufügende Ticket.
     */
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    /**
     * Entfernt ein Ticket aus der Liste.
     *
     * @param ticket Das zu entfernende Ticket.
     */
    public void removeTicket(Ticket ticket) {
        tickets.remove(ticket);
    }

    /**
     * Gibt die Liste aller Tickets zurück.
     *
     * @return Die Liste aller Tickets.
     */
    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    /**
     * Sucht ein Ticket anhand seines Titels in der Liste.
     *
     * @param title Der Titel des gesuchten Tickets.
     * @return Das Ticket mit dem angegebenen Titel oder null, wenn kein Ticket gefunden wurde.
     */
    public Ticket findTicketByTitle(String title) {
        for (Ticket ticket : tickets) {
            if (ticket.getTitle().equals(title)) {
                return ticket;
            }
        }
        return null;
    }

    /**
     * Sortiert die Liste der Tickets nach Priorität.
     *
     * @return Eine sortierte Liste der Tickets nach Priorität.
     */
    public ArrayList<Ticket> sortTicketsByPriority() {
        ArrayList<Ticket> sortedTickets = new ArrayList<>(tickets);
        Collections.sort(sortedTickets);
        return sortedTickets;
    }

    /**
     * Sortiert die Liste der Tickets nach dem Fälligkeitsdatum.
     *
     * @return Eine sortierte Liste der Tickets nach dem Fälligkeitsdatum.
     */
    public ArrayList<Ticket> sortTicketsByDueDate() {
        ArrayList<Ticket> sortedTickets = new ArrayList<>(tickets);
        Collections.sort(sortedTickets, Comparator.comparing(Ticket::getDueDate));
        return sortedTickets;
    }

    // Weitere Sortier- und Suchmethoden können nach Bedarf hinzugefügt werden
}
