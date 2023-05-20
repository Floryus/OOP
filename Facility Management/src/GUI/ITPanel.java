package GUI;

import java.util.ArrayList;
import javax.swing.JList;

import enums.GroupEnum;

import javax.swing.*;
import ticketSystem.Ticket;

public class ITPanel extends JPanel {

    public JList<Ticket> ticketList;
    ArrayList<Ticket> ticketArrayList;

    public ITPanel(ArrayList<Ticket> tickets) {
        initComponents(tickets);
        this.ticketArrayList = tickets;
    }

    public void updateContent(ArrayList<Ticket> tickets) {
        TicketManager tm = new TicketManager(GroupEnum.IT, tickets);
        JTable j = new JTable(tm.getData(), tm.getColumnNames());
        removeAll();
        add(j);
    }

    private void initComponents(ArrayList<Ticket> tickets) {
        updateContent(tickets);
    }
}
