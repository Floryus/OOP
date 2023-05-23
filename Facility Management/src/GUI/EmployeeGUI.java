package GUI;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;


import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import classes.Employee;
import ticketSystem.Ticket;
import classes.Todo;
import enums.GroupEnum;
import classes.GlobalData;

public class EmployeeGUI extends JFrame {

    private JComboBox<Employee> employeeDropdown;
    private JComboBox<Ticket> ticketDropdown;
    private JPanel employeeDataPanel;

    public EmployeeGUI() {
        setTitle("Employee Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        initComponents();
        buildEmployeePanel();

        setVisible(true);
    }

    private void initComponents() {
        employeeDropdown = new JComboBox<>();
        employeeDropdown.addActionListener(e -> {
            Employee selectedEmployee = (Employee) employeeDropdown.getSelectedItem();
            updateEmployeeData(selectedEmployee);
        });

        ticketDropdown = new JComboBox<>();
        ticketDropdown.addActionListener(e -> {
            Ticket selectedTicket = (Ticket) ticketDropdown.getSelectedItem();
            System.out.println("Selected Ticket: " + selectedTicket);
        });
    }

    private void buildEmployeePanel() {
        // Employee Panel
        JPanel employeePanel = new JPanel(new GridLayout(3, 2));
        employeePanel.setBorder(BorderFactory.createTitledBorder("Employee Details"));
        employeePanel.add(new JLabel("Name:"));
    
        // Employee Name Label
        JLabel nameLabel = new JLabel();
        employeePanel.add(nameLabel);
    
        employeePanel.add(new JLabel("Group:"));
    
        // Employee Group Label
        JLabel groupLabel = new JLabel();
        employeePanel.add(groupLabel);
    
        employeePanel.add(new JLabel("ID:"));
    
        // Employee ID Label
        JLabel idLabel = new JLabel();
        employeePanel.add(idLabel);
    
        // Employee Dropdown Panel
        JPanel employeeDropdownPanel = new JPanel(new FlowLayout());
        employeeDropdownPanel.add(new JLabel("Select Employee:"));
        employeeDropdownPanel.add(employeeDropdown);
    
        // Main Panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(employeePanel, BorderLayout.NORTH);
    
        // Add components to the main container
        setLayout(new BorderLayout());
        add(employeeDropdownPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
    
        // Update the employee data when a new employee is selected
        employeeDropdown.addActionListener(e -> {
            Employee selectedEmployee = (Employee) employeeDropdown.getSelectedItem();
            if (selectedEmployee != null) {
                nameLabel.setText(selectedEmployee.getName());
                groupLabel.setText(selectedEmployee.getGroup().toString());
                idLabel.setText(selectedEmployee.getId());
            } else {
                nameLabel.setText("");
                groupLabel.setText("");
                idLabel.setText("");
            }
        });
    }
    
    
    
    private void updateEmployeeData(Employee employee) {
        employeeDataPanel.removeAll();
        if (employee != null) {
            employeeDataPanel.add(new JLabel(employee.getName()));
            employeeDataPanel.add(new JLabel(employee.getGroup().toString()));
            employeeDataPanel.add(new JLabel(employee.getId()));
        } else {
            employeeDataPanel.add(new JLabel(""));
            employeeDataPanel.add(new JLabel(""));
            employeeDataPanel.add(new JLabel(""));
        }
        employeeDataPanel.revalidate();
        employeeDataPanel.repaint();
    }
    

    public void updateEmployeeDropdown(ArrayList<Employee> employees) {
        employeeDropdown.removeAllItems();
        for (Employee employee : employees) {
            employeeDropdown.addItem(employee);
        }
    }

    public void updateTicketDropdown(ArrayList<Ticket> todos) {
        ticketDropdown.removeAllItems();
        for (Todo todo : todos) {
            if (todo instanceof Ticket) {
                ticketDropdown.addItem((Ticket) todo);
            }
        }
    }

    public static void main(String[] args) {
        EmployeeGUI employeeGUI = new EmployeeGUI();

        // Employee hinzufügen und Dropdown aktualisieren
        GlobalData.addEmployee("John", GroupEnum.CLEANING, "E001");
        GlobalData.addEmployee("Jane", GroupEnum.CLEANING, "E002");
        employeeGUI.updateEmployeeDropdown(GlobalData.getEmployees());

        // Das GUI anzeigen
        employeeGUI.setVisible(true);
    }

}
