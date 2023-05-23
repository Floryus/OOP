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

import javax.swing.JComboBox;
import enums.RoomFlooringEnum;
import enums.RoomTypesEnum;

import javax.swing.JList;
import javax.swing.JScrollPane;

import javax.swing.DefaultListModel;


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
        } else if (item instanceof Room) {
            setupRoom((Room) item);
            repaint();
            revalidate();
            repaint();
        } else if (item instanceof Level) {
            setupLevel((Level) item);
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

    private void setupRoom(Room room) {

        JTextField nameField;
        JTextField lengthField;
        JTextField widthField;
        JTextField heightField;
        JComboBox<RoomFlooringEnum> flooringComboBox;
        JComboBox<RoomTypesEnum> roomTypeComboBox;
        JList<Equipment> equipmentList;
        JTextField seatCountField;

        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel nameLabel = new JLabel("Name:");
        add(nameLabel, gbc);

        gbc.gridy++;
        JLabel lengthLabel = new JLabel("Länge:");
        add(lengthLabel, gbc);

        gbc.gridy++;
        JLabel widthLabel = new JLabel("Breite:");
        add(widthLabel, gbc);

        gbc.gridy++;
        JLabel heightLabel = new JLabel("Höhe:");
        add(heightLabel, gbc);

        gbc.gridy++;
        JLabel flooringLabel = new JLabel("Bodenbelag:");
        add(flooringLabel, gbc);

        gbc.gridy++;
        JLabel typeLabel = new JLabel("Raumtyp:");
        add(typeLabel, gbc);

        gbc.gridy++;
        JLabel equipmentLabel = new JLabel("Ausstattung:");
        add(equipmentLabel, gbc);

        gbc.gridy++;
        JLabel seatCountLabel = new JLabel("Sitzplätze:");
        add(seatCountLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        nameField = new JTextField();
        nameField.setEditable(false);
        nameField.setText(room.getName());
        add(nameField, gbc);

        gbc.gridy++;
        lengthField = new JTextField();
        lengthField.setEditable(true);
        lengthField.setText(String.valueOf(room.getLength()));
        add(lengthField, gbc);

        gbc.gridy++;
        widthField = new JTextField();
        widthField.setEditable(true);
        widthField.setText(String.valueOf(room.getWidth()));
        add(widthField, gbc);

        gbc.gridy++;
        heightField = new JTextField();
        heightField.setEditable(true);
        heightField.setText(String.valueOf(room.getHeight()));
        add(heightField, gbc);

        gbc.gridy++;
        flooringComboBox = new JComboBox<>(RoomFlooringEnum.values());
        flooringComboBox.setSelectedItem(room.getFlooring());
        add(flooringComboBox, gbc);

        gbc.gridy++;
        roomTypeComboBox = new JComboBox<>(RoomTypesEnum.values());
        roomTypeComboBox.setSelectedItem(room.getFlooring());
        add(roomTypeComboBox, gbc);

        gbc.gridy++;
        equipmentList = new JList<>(room.getEquipmentList().toArray(new Equipment[0]));
        JScrollPane equipmentScrollPane = new JScrollPane(equipmentList);
        equipmentScrollPane.setPreferredSize(new Dimension(200, 100));
        add(equipmentScrollPane, gbc);

        gbc.gridy++;
        seatCountField = new JTextField();
        seatCountField.setEditable(true);
        seatCountField.setText(String.valueOf(room.getSeatCount()));
        add(seatCountField, gbc);

        initButtons(room);
    }


private void setupLevel(Level level) {

    JTextField levelNumberField;
    JTextField maxRoomsField;
    DefaultListModel<Room> roomListModel;
    JList<Room> roomList;

    setLayout(new GridBagLayout());

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.WEST;
    gbc.insets = new Insets(5, 5, 5, 5);

    JLabel levelNumberLabel = new JLabel("Ebenennummer:");
    add(levelNumberLabel, gbc);

    gbc.gridy++;
    JLabel maxRoomsLabel = new JLabel("Maximale Anzahl an Räumen:");
    add(maxRoomsLabel, gbc);

    gbc.gridy++;
    JLabel roomListLabel = new JLabel("Räume:");
    add(roomListLabel, gbc);

    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.weightx = 1.0;
    gbc.fill = GridBagConstraints.HORIZONTAL;

    levelNumberField = new JTextField();
    levelNumberField.setEditable(false);
    levelNumberField.setText(String.valueOf(level.getLevelNumber()));
    add(levelNumberField, gbc);

    gbc.gridy++;
    maxRoomsField = new JTextField();
    maxRoomsField.setEditable(false);
    maxRoomsField.setText(String.valueOf(level.getMaxRooms()));
    add(maxRoomsField, gbc);

    gbc.gridy++;
    roomListModel = new DefaultListModel<>();
    for (Room room : level.getRooms()) {
        roomListModel.addElement(room);
    }
    roomList = new JList<>(roomListModel);
    JScrollPane roomScrollPane = new JScrollPane(roomList);
    roomScrollPane.setPreferredSize(new Dimension(200, 100));
    add(roomScrollPane, gbc);

    initButtons(level);
    }
}
