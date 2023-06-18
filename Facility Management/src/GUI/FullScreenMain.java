package GUI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ticketSystem.Ticket;

import java.awt.*;
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

        // Panels
        BuildingsPanel bp = new BuildingsPanel();
        CleaningPanel cp = new CleaningPanel(tickets);
        ITPanel ip = new ITPanel(tickets);
        FacilityPanel fp = new FacilityPanel(tickets);
        EmployeePanel ep = new EmployeePanel();

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Gebäude", bp);
        tabbedPane.addTab("Mitarbeiter", ep);
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
        add(tabbedPane, BorderLayout.NORTH);

        pack();

    }
}
