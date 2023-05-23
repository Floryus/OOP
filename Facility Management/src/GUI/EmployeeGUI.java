package GUI;

import java.awt.BorderLayout;
import javax.swing.JComboBox;

import javax.swing.JLabel;
import javax.swing.JPanel;
import ticketSystem.Ticket;
import classes.Employee;

import classes.GlobalData;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import enums.GroupEnum;

public class EmployeeGUI extends JPanel {

    private JComboBox<Employee> employeeDropdown;
    private JComboBox<Ticket> ticketDropdown;

    private ArrayList<Ticket> allTickets;

    public EmployeeGUI(ArrayList<Ticket> tickets) {
        this.allTickets = tickets;
        initComponents();
        buildEmployeePanel();
    }

    private void initComponents() {
        employeeDropdown = new JComboBox<>();
        employeeDropdown.addActionListener(e -> {
            Employee selectedEmployee = (Employee) employeeDropdown.getSelectedItem();
            updateTicketDropdown(selectedEmployee);
        });

        ticketDropdown = new JComboBox<>();
        ticketDropdown.addActionListener(e -> {
            Ticket selectedTicket = (Ticket) ticketDropdown.getSelectedItem();
            System.out.println("Selected Ticket: " + selectedTicket);
        });
    }

    private void buildEmployeePanel() {
        JPanel employeePanel = new JPanel(new GridLayout(3, 2));
        employeePanel.setBorder(BorderFactory.createTitledBorder("Employee Details"));
        employeePanel.add(new JLabel("Name:"));
        employeePanel.add(new JLabel("Group:"));
        employeePanel.add(new JLabel("ID:"));

        JPanel employeeDataPanel = new JPanel(new GridLayout(3, 2));
        employeeDataPanel.add(new JLabel());
        employeeDataPanel.add(new JLabel());
        employeeDataPanel.add(new JLabel());

        JPanel employeeDropdownPanel = new JPanel(new FlowLayout());
        employeeDropdownPanel.add(new JLabel("Select Employee:"));
        employeeDropdownPanel.add(employeeDropdown);

        JPanel ticketPanel = new JPanel(new BorderLayout());
        ticketPanel.setBorder(BorderFactory.createTitledBorder("Assigned Tickets"));
        ticketPanel.add(ticketDropdown, BorderLayout.CENTER);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(employeePanel, BorderLayout.NORTH);
        mainPanel.add(ticketPanel, BorderLayout.CENTER);

        setLayout(new BorderLayout());
        add(employeeDropdownPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
    }

    public void updateEmployeeDropdown(ArrayList<Employee> employees) {
        DefaultComboBoxModel<Employee> model = new DefaultComboBoxModel<>();
        for (Employee employee : employees) {
            model.addElement(employee);
        }
        employeeDropdown.setModel(model);
    }
    

    public void updateTicketDropdown(Employee selectedEmployee) {
        ticketDropdown.removeAllItems();
        for (Ticket ticket : allTickets) {
            if (ticket.getResp().equals(selectedEmployee)) {
                ticketDropdown.addItem(ticket);
            }
        }
    }

    public static void main(String[] args) {
        // Create an instance of EmployeeGUI

        // Add the employees to the GlobalData
        GlobalData.addEmployee("John", GroupEnum.CLEANING, "ID001");
        GlobalData.addEmployee("Jane",GroupEnum.CLEANING, "ID002");
        GlobalData.addEmployee("Mark",GroupEnum.CLEANING, "ID003");
        
        EmployeeGUI employeeGUI = new EmployeeGUI(GlobalData.getTickets());
    }
}
