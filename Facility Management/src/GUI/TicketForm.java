package GUI;

import javax.swing.*;

import classes.Building;
import classes.GroupEnum;
import classes.Room;
import ticketSystem.PriorityEnum;
import ticketSystem.Ticket;

import java.awt.*;
import java.awt.event.*;

public class TicketForm extends JFrame {

    private JTextField titleField;
    private JButton printButton;
    private JTextArea descriptionArea;
    private JComboBox<PriorityEnum> priorityComboBox;
    private JComboBox<GroupEnum> groupComboBox;

    public TicketForm() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Simple GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        titleField = new JTextField(20);
        descriptionArea = new JTextArea(5, 20);
        priorityComboBox = new JComboBox<>(PriorityEnum.values());
        groupComboBox = new JComboBox<>(GroupEnum.values());
        printButton = new JButton("Ticket erstellen");

        JPanel panel = new JPanel();
        panel.add(titleField);
        panel.add(descriptionArea);
        panel.add(priorityComboBox);
        panel.add(groupComboBox);
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

                Building b = new Building("Ber03");
                Room item = new Room(b, 0);

                // Create ticket object
                Ticket ticket = new Ticket(title, description, priority, item, group);
                System.out.println(ticket.getEverything());
            }
        });
    }
}