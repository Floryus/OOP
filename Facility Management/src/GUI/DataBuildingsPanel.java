package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import classes.Building;
import classes.Equipment;
import classes.Level;
import classes.Maintainable;
import classes.Room;

public class DataBuildingsPanel extends JPanel {

    private JLabel dataLabel;
    private JButton buttonTicket;
    private JButton buttonSave;
    private BuildingsPanel bp;

    public DataBuildingsPanel(BuildingsPanel bp) {
        bp = this.bp;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800, getPreferredSize().height));

        dataLabel = new JLabel("Wähle eine Objektinfo zum Anzeigen von Daten");
        add(dataLabel, BorderLayout.NORTH);

    }

    private void initButtons(Maintainable item) {

        buttonTicket = new JButton("Ticket erstellen");
        add(buttonTicket);

        buttonTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TicketForm ticketForm = new TicketForm();
                ticketForm.setVisible(true);
            }
        });

        buttonSave = new JButton("Speichern");
        add(buttonSave);
    }

    public void updateData(Maintainable item) {
        removeAll();
        if (item instanceof Building) {
            setupBuilding((Building) item);
        }
    }

    private void setup(Level lvl) {

    }

    private void setup(Room room) {

    }

    private void setup(Equipment equip) {

    }

    private void setupBuilding(Building building) {

        JTextField nameField;
        JTextField streetField;
        JTextField houseNumberField;
        JTextField zipCodeField;
        JTextField cityField;
        JTextField yearBuiltField;
        JTextField employeeCountField;
        JTextField ownerField;
        JTextField parkingCountField;

        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel nameLabel = new JLabel("Name:");
        add(nameLabel, gbc);

        gbc.gridy++;
        JLabel streetLabel = new JLabel("Straße:");
        add(streetLabel, gbc);

        gbc.gridy++;
        JLabel houseNumberLabel = new JLabel("Hausnummer:");
        add(houseNumberLabel, gbc);

        gbc.gridy++;
        JLabel zipCodeLabel = new JLabel("PLZ:");
        add(zipCodeLabel, gbc);

        gbc.gridy++;
        JLabel cityLabel = new JLabel("Stadt:");
        add(cityLabel, gbc);

        gbc.gridy++;
        JLabel yearBuiltLabel = new JLabel("Baujahr:");
        add(yearBuiltLabel, gbc);

        gbc.gridy++;
        JLabel employeeCountLabel = new JLabel("Mitarbeiteranzahl:");
        add(employeeCountLabel, gbc);

        gbc.gridy++;
        JLabel ownerLabel = new JLabel("Besitzer:");
        add(ownerLabel, gbc);

        gbc.gridy++;
        JLabel parkingCountLabel = new JLabel("Parkplatzanzahl:");
        add(parkingCountLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        nameField = new JTextField();
        nameField.setEditable(true);
        add(nameField, gbc);

        gbc.gridy++;
        streetField = new JTextField();
        streetField.setEditable(true);
        add(streetField, gbc);

        gbc.gridy++;
        houseNumberField = new JTextField();
        houseNumberField.setEditable(true);
        add(houseNumberField, gbc);

        gbc.gridy++;
        zipCodeField = new JTextField();
        zipCodeField.setEditable(true);
        add(zipCodeField, gbc);

        gbc.gridy++;
        cityField = new JTextField();
        cityField.setEditable(true);
        add(cityField, gbc);

        gbc.gridy++;
        yearBuiltField = new JTextField();
        yearBuiltField.setEditable(true);
        add(yearBuiltField, gbc);

        gbc.gridy++;
        employeeCountField = new JTextField();
        employeeCountField.setEditable(true);
        add(employeeCountField, gbc);

        gbc.gridy++;
        ownerField = new JTextField();
        ownerField.setEditable(true);
        add(ownerField, gbc);

        gbc.gridy++;
        parkingCountField = new JTextField();
        parkingCountField.setEditable(true);
        add(parkingCountField, gbc);

        initButtons(building);

    }
}
