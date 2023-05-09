package GUI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ticketSystem.Ticket;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class FullScreenMain extends JFrame {

    private ArrayList<Ticket> tickets;

    public FullScreenMain(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
        initComponents();
    }

    private void initComponents() {
        setTitle("Facility Management Software");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel buttonPanel = new JPanel();
        JButton createTicketButton = new JButton("Ticket erstellen");
        buttonPanel.add(createTicketButton);

        // Panels
        BuildingsPanel bp = new BuildingsPanel();
        CleaningPanel cp = new CleaningPanel(tickets);
        ITPanel ip = new ITPanel();
        FacilityPanel fp = new FacilityPanel();

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Buildings", bp);
        tabbedPane.addTab("Cleaning", cp);
        tabbedPane.addTab("IT", ip);
        tabbedPane.addTab("Facility", fp);

        ChangeListener changeListener = new ChangeListener() {
            public void stateChanged(ChangeEvent changeEvent) {
                JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
                int index = sourceTabbedPane.getSelectedIndex();
                System.out.println("Tab changed to: " + sourceTabbedPane.getTitleAt(index));
                cp.updateContent(tickets);
            }
        };
        tabbedPane.addChangeListener(changeListener);

        setLayout(new BorderLayout());
        add(tabbedPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();

        createTicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TicketForm ticketForm = new TicketForm(tickets);
                ticketForm.setVisible(true);
            }
        });
    }
}
