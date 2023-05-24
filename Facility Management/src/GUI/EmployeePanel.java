package GUI;

import javax.swing.*;

import classes.Employee;
import classes.GlobalData;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EmployeePanel extends JPanel {
    private JComboBox<Employee> employeeComboBox;
    private JLabel dropdownLabel;
    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel groupLabel;

    public EmployeePanel() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        // Dropdown-Menü mit den Employee-Objekten erstellen
        ArrayList<Employee> employees = GlobalData.getEmployees();
        Employee[] employeeArray = employees.toArray(new Employee[0]);
        employeeComboBox = new JComboBox<>(employeeArray);
        employeeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aktualisiere die angezeigten Informationen, wenn ein Employee ausgewählt wird
                Employee selectedEmployee = (Employee) employeeComboBox.getSelectedItem();
                if (selectedEmployee != null) {
                    idLabel.setText("ID: " + selectedEmployee.getId());
                    nameLabel.setText("Name: " + selectedEmployee.getName());
                    groupLabel.setText("Gruppe: " + selectedEmployee.getGroup());
                }
            }
        });

        // Panel für die Labels erstellen
        JPanel labelsPanel = new JPanel(new GridLayout(4, 1, 1, 1));
        dropdownLabel = new JLabel("Mitarbeiter: ");
        idLabel = new JLabel("ID:");
        nameLabel = new JLabel("Name:");
        groupLabel = new JLabel("Gruppe:");
        labelsPanel.add(dropdownLabel);
        labelsPanel.add(employeeComboBox);
        labelsPanel.add(idLabel);
        labelsPanel.add(nameLabel);
        labelsPanel.add(groupLabel);
        add(labelsPanel, BorderLayout.NORTH);
    }
}
