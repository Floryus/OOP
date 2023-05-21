package GUI;

import javax.swing.*;

import classes.Building;
import classes.Level;
import classes.Room;
import enums.GroupEnum;
import enums.PriorityEnum;
import enums.RoomTypesEnum;
import ticketSystem.Ticket;
import java.util.ArrayList;

import java.awt.*;
import java.awt.event.*;

public class TicketForm extends JFrame {

    private ArrayList<Ticket> tickets;

    private JTextField titleField;
    private JButton printButton;
    private JTextArea descriptionArea;
    private JComboBox<PriorityEnum> priorityComboBox;
    private JComboBox<GroupEnum> groupComboBox;

    public TicketForm(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
        initComponents();
        titleField.requestFocus();
    }

    private void initComponents() {
        setTitle("Ticket erstellen");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        titleField = new JTextField(20);
        descriptionArea = new JTextArea(5, 20);
        priorityComboBox = new JComboBox<>(PriorityEnum.values());
        groupComboBox = new JComboBox<>(GroupEnum.values());
        printButton = new JButton("Ticket erstellen");

        JPanel panel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);
        panel.add(createLabeledComponent("Titel:\t", titleField));
        panel.add(Box.createVerticalStrut(5));
        panel.add(createLabeledComponent("Beschreibung:", descriptionArea));
        panel.add(Box.createVerticalStrut(5));
        panel.add(createLabeledComponent("Priorität:", priorityComboBox));
        panel.add(Box.createVerticalStrut(5));
        panel.add(createLabeledComponent("Ticket-Gruppe:", groupComboBox));
        panel.add(Box.createVerticalStrut(5));
        panel.add(printButton);

        setContentPane(panel);
        pack();

        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get input values
                String title = titleField.getText();
                String description = descriptionArea.getText();
                PriorityEnum priority = (PriorityEnum) priorityComboBox.getSelectedItem();
                GroupEnum group = (GroupEnum) groupComboBox.getSelectedItem();

                // TODO implement corresponding item feature

                /*
                 * Building b = port.createBuilding("Ber03", 3, "Hauptstraße 18, 10369");
                 * Room item;
                 * try {
                 * b.createLevel(3);
                 * Level lvl = b.getLevelByLevelNumber(0);
                 * item = lvl.createRoom(RoomTypesEnum.STUDY);
                 * } catch (Exception exception) {
                 * return;
                 * }
                 * 
                 * // Create ticket object
                 * Ticket ticket = new Ticket(title, description, priority, item, group);
                 * tickets.add(ticket);
                 */

                dispose();

            }
        });
    }

    private JPanel createLabeledComponent(String labelText, JComponent component) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel(labelText);
        panel.add(label, BorderLayout.WEST);
        panel.add(component, BorderLayout.CENTER);
        return panel;
    }
}