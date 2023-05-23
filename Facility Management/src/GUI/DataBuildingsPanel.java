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
        System.out.println("Update Panel data");
        if (item instanceof Building) {
            System.out.println(" | with " + item);
            setupBuilding((Building) item);
            repaint();
            revalidate();
            repaint();
        }
    }

    private void setupBuilding(Building building) {

        JTextField nameField;
        JTextField streetField;
        JTextField houseNumberField;
        JTextField zipCodeField;
        JTextField cityField;
        JTextField yearBuiltField;
        JTextField employeeCountField;
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
        JLabel parkingCountLabel = new JLabel("Parkplatzanzahl:");
        add(parkingCountLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        nameField = new JTextField();
        nameField.setEditable(true);
        nameField.setText(building.getName());
        add(nameField, gbc);

        gbc.gridy++;
        streetField = new JTextField();
        streetField.setEditable(true);
        streetField.setText(building.getAddress().getStreet());
        add(streetField, gbc);

        gbc.gridy++;
        houseNumberField = new JTextField();
        houseNumberField.setEditable(true);
        houseNumberField.setText(String.valueOf(building.getAddress().getHouseNumber()));
        add(houseNumberField, gbc);

        gbc.gridy++;
        zipCodeField = new JTextField();
        zipCodeField.setEditable(true);
        zipCodeField.setText(String.valueOf(building.getAddress().getPostalCode()));
        add(zipCodeField, gbc);

        gbc.gridy++;
        cityField = new JTextField();
        cityField.setEditable(true);
        cityField.setText(String.valueOf(building.getAddress().getCity()));
        add(cityField, gbc);

        gbc.gridy++;
        yearBuiltField = new JTextField();
        yearBuiltField.setEditable(true);
        yearBuiltField.setText(String.valueOf(building.getConstructionYear()));
        add(yearBuiltField, gbc);

        gbc.gridy++;
        employeeCountField = new JTextField();
        employeeCountField.setEditable(true);
        employeeCountField.setText(String.valueOf(building.getEmployeeCount()));
        add(employeeCountField, gbc);

        gbc.gridy++;
        parkingCountField = new JTextField();
        parkingCountField.setEditable(true);
        parkingCountField.setText(String.valueOf(building.getParkingSpaces()));
        add(parkingCountField, gbc);

        initButtons(building);

    }
}
