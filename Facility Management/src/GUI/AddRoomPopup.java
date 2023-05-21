package GUI;

import javax.swing.*;

import classes.Level;
import enums.RoomTypesEnum;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRoomPopup extends JFrame {

    private JComboBox<RoomTypesEnum> rteComboBox;

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
        rteComboBox = new JComboBox<>(RoomTypesEnum.values());

        // Erzeuge den "Gebäude erstellen" Button
        JButton createButton = new JButton("Raum erstellen");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // createLevel
                RoomTypesEnum rte = (RoomTypesEnum) rteComboBox.getSelectedItem();
                level.createRoom(rte);
                bp.reloadTree();

                // Schließe das Popup-Fenster
                dispose();
            }
        });

        // Erzeuge Panel für die Komponenten
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.add(new JLabel("Raumtyp:"));
        panel.add(rteComboBox);
        panel.add(createButton);

        // Setze das Panel als Inhalt des Popups
        setContentPane(panel);
        pack();
    }
}
