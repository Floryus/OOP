package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import classes.Building;
import classes.GlobalData;

public class DataBuildingsPanel extends JPanel {

    private JLabel dataLabel;
    private JButton buttonTicket;
    private JButton buttonSave;

    public DataBuildingsPanel() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800, getPreferredSize().height));

        dataLabel = new JLabel("Hier werden Daten angezeigt");
        add(dataLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();

        buttonTicket = new JButton("Ticket erstellen");
        buttonPanel.add(buttonTicket, BorderLayout.EAST);

        buttonTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TicketForm ticketForm = new TicketForm();
                ticketForm.setVisible(true);
            }
        });

        buttonSave = new JButton("Speichern");
        buttonPanel.add(buttonSave, BorderLayout.EAST);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void updateData(String data) {
        dataLabel.setText(data);
    }

    public void updateData(Building building) {
        dataLabel.setText("Es klappt: " + building.getAddress());
    }

}
