package GUI;

import java.util.ArrayList;

import classes.Ticket;
import enums.GroupEnum;

public class TicketManager {
    private ArrayList<Ticket> tickets;
    private String[] columnNames = { "Titel", "description", "Priority" };
    private ArrayList<Ticket> cleaningTickets = new ArrayList<Ticket>();

    public TicketManager(GroupEnum group, ArrayList<Ticket> tickets) {
        this.tickets = tickets;
        // Filter tickets by group

        for (Ticket ticket : this.tickets) {
            if (ticket.getGroup() == group) {
                cleaningTickets.add(ticket);
            }
        }
        cleaningTickets.sort(null);
    }

    /**
     * @return String[]
     */
    public String[] getColumnNames() {
        return columnNames;
    }

    public String[][] getData() {
        String[][] data = new String[cleaningTickets.size()][3];
        int i = 0;
        for (Ticket ticket : cleaningTickets) {
            data[i][0] = ticket.getTitle();
            data[i][1] = ticket.getDescription();
            data[i][2] = ticket.getPrio().toString();
            i++;
        }
        return data;
    }

}
