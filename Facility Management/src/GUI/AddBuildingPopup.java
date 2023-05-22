package GUI;

import javax.swing.*;

import classes.GlobalData;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBuildingPopup extends JFrame {
    private JTextField nameField;
    private JTextField addressField;
    private JTextField maxLevelsField;

    private BuildingsPanel bp;

    public AddBuildingPopup(BuildingsPanel bp) {
        this.bp = bp;
        initComponents();
    }

    private void initComponents() {
        setTitle("Neues Gebäude hinzufügen");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Erzeuge Eingabefelder
        nameField = new JTextField(20);
        addressField = new JTextField(20);
        maxLevelsField = new JTextField(5);

        // Erzeuge den "Gebäude erstellen" Button
        JButton createButton = new JButton("Gebäude erstellen");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // createBuilding
                String name = nameField.getText();
                String address = addressField.getText();
                int maxLevels = Integer.parseInt(maxLevelsField.getText());
                GlobalData.createBuilding(name, maxLevels, address);
                bp.reloadTree();

                // Schließe das Popup-Fenster
                dispose();
            }
        });

        // Erzeuge Panel für die Komponenten
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Adresse:"));
        panel.add(addressField);
        panel.add(new JLabel("Maximale Anzahl an Etagen:"));
        panel.add(maxLevelsField);
        panel.add(createButton);

        // Setze das Panel als Inhalt des Popups
        setContentPane(panel);
        pack();
    }
}
