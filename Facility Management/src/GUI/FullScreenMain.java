package GUI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import classes.Portfolio;
import ticketSystem.Ticket;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class FullScreenMain extends JFrame {

    private ArrayList<Ticket> tickets;
    private Portfolio portfolio;

    public FullScreenMain(ArrayList<Ticket> tickets, Portfolio portfolio) {
        this.tickets = tickets;
        this.portfolio = portfolio;
        initComponents();
    }

    private void initComponents() {
        setTitle("Facility Management Software");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panels
        BuildingsPanel bp = new BuildingsPanel(portfolio);
        CleaningPanel cp = new CleaningPanel(tickets);
        ITPanel ip = new ITPanel(tickets);
        FacilityPanel fp = new FacilityPanel(tickets);

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

        pack();

    }
}
