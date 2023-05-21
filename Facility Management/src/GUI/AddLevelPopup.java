package GUI;

import javax.swing.*;

import classes.Building;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddLevelPopup extends JFrame {
    private JTextField maxRoomsField;

    private Building building;
    private BuildingsPanel bp;

    public AddLevelPopup(BuildingsPanel bp, Building building) {
        this.bp = bp;
        this.building = building;
        initComponents();
    }

    private void initComponents() {
        setTitle("Neue Etage hinzufügen");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Erzeuge Eingabefelder
        maxRoomsField = new JTextField(5);

        // Erzeuge den "Gebäude erstellen" Button
        JButton createButton = new JButton("Etage erstellen");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // createLevel
                int maxRooms = Integer.parseInt(maxRoomsField.getText());
                building.createLevel(maxRooms);
                bp.reloadTree();

                // Schließe das Popup-Fenster
                dispose();
            }
        });

        // Erzeuge Panel für die Komponenten
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.add(new JLabel("Maximale Anzahl an Räumen:"));
        panel.add(maxRoomsField);
        panel.add(createButton);

        // Setze das Panel als Inhalt des Popups
        setContentPane(panel);
        pack();
    }
}
