package GUI;

import javax.swing.*;

import classes.Address;
import classes.GlobalData;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Diese Klasse ist das GUI für das Hinzufügen eines Gebäudes innerhalb eines Popups
 * 
 * @author Florian Schmidt
 * 
 * @version 1.0
 */

public class AddBuildingPopup extends JFrame {
    private JTextField nameField;
    private JTextField streetField;
    private JTextField houseNumberField;
    private JTextField zipCodeField;
    private JTextField cityField;
    private JTextField maxLevelsField;
    private JTextField employeeField;
    private JTextField constructionField;
    private JTextField parkingField;

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
        streetField = new JTextField(20);
        houseNumberField = new JTextField(5);
        zipCodeField = new JTextField(5);
        cityField = new JTextField(20);
        maxLevelsField = new JTextField(5);
        employeeField = new JTextField(10);
        constructionField = new JTextField(10);
        parkingField = new JTextField(10);

        // Erzeuge den "Gebäude erstellen" Button
        JButton createButton = new JButton("Gebäude erstellen");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // createBuilding
                String name = nameField.getText();
                String street = streetField.getText();
                int houseNumber = Integer.valueOf(houseNumberField.getText());
                int zipCode = Integer.valueOf(zipCodeField.getText());
                String city = cityField.getText();
                int employeeCount = Integer.valueOf(employeeField.getText());
                int constructionYear = Integer.valueOf(constructionField.getText());
                int parkingSpaces = Integer.valueOf(parkingField.getText());

                int maxLevels = Integer.parseInt(maxLevelsField.getText());
                GlobalData.createBuilding(name, maxLevels, new Address(street, houseNumber, zipCode, city),
                        employeeCount, constructionYear, parkingSpaces);
                bp.reloadTree();

                // Schließe das Popup-Fenster
                dispose();
            }
        });

        // Erzeuge Panel für die Komponenten
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 2));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Straße:"));
        panel.add(streetField);
        panel.add(new JLabel("Hausnummer:"));
        panel.add(houseNumberField);
        panel.add(new JLabel("PLZ:"));
        panel.add(zipCodeField);
        panel.add(new JLabel("Stadt:"));
        panel.add(cityField);
        panel.add(new JLabel("Maximale Anzahl an Etagen:"));
        panel.add(maxLevelsField);
        panel.add(new JLabel("Mitarbeiteranzahl:"));
        panel.add(employeeField);
        panel.add(new JLabel("Baujahr:"));
        panel.add(constructionField);
        panel.add(new JLabel("Parkplatzanzahl:"));
        panel.add(parkingField);
        panel.add(createButton);

        // Setze das Panel als Inhalt des Popups
        setContentPane(panel);
        pack();
    }
}
