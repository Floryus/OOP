package GUI;

import javax.swing.*;

import enums.EquipStatusEnum;
import enums.EquipTypeEnum;
import classes.Equipment;
import classes.GlobalData;
import classes.Room;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

public class AddEquipmentPopup extends JFrame {
    private JTextField nameField;
    private JComboBox<EquipTypeEnum> typeComboBox;
    private JTextField acquisitionDateField;
    private JTextField maintenanceIntervalField;

    private BuildingsPanel bp;
    private Room room;

    public AddEquipmentPopup(BuildingsPanel bp, Room room) {
        this.room = room;
        this.bp = bp;
        initComponents();
    }

    private void initComponents() {
        setTitle("Neues Equipment hinzufügen");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Erzeuge Eingabefelder
        nameField = new JTextField(20);
        typeComboBox = new JComboBox<>(EquipTypeEnum.values());
        acquisitionDateField = new JTextField(10);
        maintenanceIntervalField = new JTextField(5);

        // Erzeuge den "Equipment erstellen" Button
        JButton createButton = new JButton("Equipment erstellen");
        createButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // createEquipment
                String name = nameField.getText();
                EquipTypeEnum equipType = (EquipTypeEnum) typeComboBox.getSelectedItem();
                GregorianCalendar acquisitionDate = parseDate(acquisitionDateField.getText());
                int maintenanceInterval = Integer.parseInt(maintenanceIntervalField.getText());

                Equipment equipment = new Equipment(name, equipType, acquisitionDate,
                        maintenanceInterval, room);
                room.addEquipment(equipment);
                bp.reloadTree();
                // Schließe das Popup-Fenster
                dispose();
            }

        });

        // Erzeuge Panel für die Komponenten
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Equipment-Typ:"));
        panel.add(typeComboBox);
        panel.add(new JLabel("Anschaffungsdatum (dd.MM.yyyy):"));
        panel.add(acquisitionDateField);
        panel.add(new JLabel("Wartungsintervall (in Monaten):"));
        panel.add(maintenanceIntervalField);
        panel.add(createButton);

        // Setze das Panel als Inhalt des Popups
        setContentPane(panel);
        pack();
    }

    private GregorianCalendar parseDate(String dateStr) {
        try {
            String[] parts = dateStr.split("\\.");
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]) - 1; // Month in Calendar is zero-based
            int year = Integer.parseInt(parts[2]);
            return new GregorianCalendar(year, month, day);
        } catch (Exception e) {
            // Fehler beim Parsen des Datums
            return null;
        }
    }
}
