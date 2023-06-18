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
    private JTextField idTextField;
    private JTextField nameTextField;
    private JTextField groupTextField;

    public EmployeePanel() {
        setLayout(new BorderLayout());
        initComponents();
    }

    private void initComponents() {
        initInfoPanel();

    }

    private void initInfoPanel() {
        setLayout(new GridBagLayout());
        setPreferredSize(getPreferredSize());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Dropdown-Menü mit den Employee-Objekten erstellen
        Employee[] employeeArray = GlobalData.getEmployees().toArray(new Employee[0]);
        employeeComboBox = new JComboBox<>(employeeArray);
        employeeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aktualisiere die angezeigten Informationen, wenn ein Employee ausgewählt wird
                Employee selectedEmployee = (Employee) employeeComboBox.getSelectedItem();
                if (selectedEmployee != null) {
                    idTextField.setText(String.valueOf(selectedEmployee.getId()));
                    nameTextField.setText(selectedEmployee.getName());
                    groupTextField.setText(selectedEmployee.getGroup().toString());
                    revalidate();
                    repaint();
                }
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Mitarbeiter:"), gbc);

        gbc.gridx++;
        add(employeeComboBox, gbc);

        // Leerer Platzhalter für Button "Mitarbeiter erstellen"
        gbc.gridy++;
        add(new JLabel(), gbc);

        // Labels und Textfelder für ID, Name und Gruppe
        gbc.gridy++;
        idLabel = new JLabel("ID:");
        gbc.gridx = 0;
        add(idLabel, gbc);

        idTextField = new JTextField();
        idTextField.setEditable(false);
        gbc.gridx = 1;
        add(idTextField, gbc);

        gbc.gridy++;
        nameLabel = new JLabel("Name:");
        gbc.gridx = 0;
        add(nameLabel, gbc);

        nameTextField = new JTextField();
        nameTextField.setEditable(false);
        gbc.gridx = 1;
        add(nameTextField, gbc);

        gbc.gridy++;
        groupLabel = new JLabel("Gruppe:");
        gbc.gridx = 0;
        add(groupLabel, gbc);

        groupTextField = new JTextField();
        groupTextField.setEditable(false);
        gbc.gridx = 1;
        add(groupTextField, gbc);
    }
}
