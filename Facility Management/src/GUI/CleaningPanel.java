package GUI;

import java.util.ArrayList;

import javax.swing.JList;

import classes.GroupEnum;

import javax.swing.*;

import ticketSystem.Ticket;

public class CleaningPanel extends JPanel {

    public JList<Ticket> ticketList;
    ArrayList<Ticket> ticketArrayList;

    public CleaningPanel(ArrayList<Ticket> tickets) {
        initComponents(tickets);
        this.ticketArrayList = tickets;
    }

    public void updateContent(ArrayList<Ticket> tickets) {
        // Filter tickets by group
        ArrayList<Ticket> cleaningTickets = new ArrayList<Ticket>();
        for (Ticket ticket : tickets) {
            if (ticket.getGroup() == GroupEnum.CLEANING) {
                cleaningTickets.add(ticket);
            }
        }
        String[][] data = new String[cleaningTickets.size()][3];

        int i = 0;
        for (Ticket ticket : cleaningTickets) {
            data[i][0] = ticket.getTitle();
            data[i][1] = ticket.getDescription();
            data[i][2] = ticket.getPrio().toString();
            i++;
        }

        String[] columnNames = { "Titel", "description", "Priority" };
        // Initializing the JTable
        JTable j = new JTable(data, columnNames);
        removeAll();
        add(j);
    }

    private void initComponents(ArrayList<Ticket> tickets) {
        updateContent(tickets);
    }
}
