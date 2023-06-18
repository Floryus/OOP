package classes.verwaltungsklassen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import classes.Ticket;

public class TicketVerwaltung {
    private ArrayList<Ticket> tickets;

    public TicketVerwaltung() {
        tickets = new ArrayList<>();
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void removeTicket(Ticket ticket) {
        tickets.remove(ticket);
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public Ticket findTicketByTitle(String title) {
        for (Ticket ticket : tickets) {
            if (ticket.getTitle().equals(title)) {
                return ticket;
            }
        }
        return null;
    }

    public ArrayList<Ticket> sortTicketsByPriority() {
        ArrayList<Ticket> sortedTickets = new ArrayList<>(tickets);
        Collections.sort(sortedTickets);
        return sortedTickets;
    }

    public ArrayList<Ticket> sortTicketsByDueDate() {
        ArrayList<Ticket> sortedTickets = new ArrayList<>(tickets);
        Collections.sort(sortedTickets, Comparator.comparing(Ticket::getDueDate));
        return sortedTickets;
    }

    // Weitere Sortier- und Suchmethoden können nach Bedarf hinzugefügt werden
}
