package GUI;

import javax.swing.*;

import classes.Level;
import classes.Room;
import enums.RoomFlooringEnum;
import enums.RoomTypesEnum;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRoomPopup extends JFrame {

    private JTextField lengthField;
    private JTextField widthField;
    private JTextField heightField;
    private JComboBox<RoomFlooringEnum> flooringComboBox;
    private JComboBox<RoomTypesEnum> roomTypeComboBox;
    private JTextField seatCountField;

    private Level level;
    private BuildingsPanel bp;

    public AddRoomPopup(BuildingsPanel bp, Level level) {
        this.bp = bp;
        this.level = level;
        initComponents();
    }

    private void initComponents() {
        setTitle("Neuen Raum hinzufügen");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Erzeuge Eingabefelder
        lengthField = new JTextField(10);
        widthField = new JTextField(10);
        heightField = new JTextField(10);
        flooringComboBox = new JComboBox<>(RoomFlooringEnum.values());
        roomTypeComboBox = new JComboBox<>(RoomTypesEnum.values());
        seatCountField = new JTextField(10);

        // Erzeuge den "Raum erstellen" Button
        JButton createButton = new JButton("Raum erstellen");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // createRoom
                double length = Double.parseDouble(lengthField.getText());
                double width = Double.parseDouble(widthField.getText());
                double height = Double.parseDouble(heightField.getText());
                RoomFlooringEnum flooring = (RoomFlooringEnum) flooringComboBox.getSelectedItem();
                RoomTypesEnum type = (RoomTypesEnum) roomTypeComboBox.getSelectedItem();
                int seatCount = Integer.parseInt(seatCountField.getText());

                Room room = level.createRoom(type);
                room.setLength(length);
                room.setWidth(width);
                room.setHeight(height);
                room.setFlooring(flooring);
                room.setSeatCount(seatCount);

                bp.reloadTree();

                // Schließe das Popup-Fenster
                dispose();
            }
        });

        // Erzeuge Panel für die Komponenten
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));
        panel.add(new JLabel("Länge:"));
        panel.add(lengthField);
        panel.add(new JLabel("Breite:"));
        panel.add(widthField);
        panel.add(new JLabel("Höhe:"));
        panel.add(heightField);
        panel.add(new JLabel("Bodenbelag:"));
        panel.add(flooringComboBox);
        panel.add(new JLabel("Type:"));
        panel.add(roomTypeComboBox);
        panel.add(new JLabel("Sitzplätze:"));
        panel.add(seatCountField);
        panel.add(createButton);

        // Setze das Panel als Inhalt des Popups
        setContentPane(panel);
        pack();
    }
}
