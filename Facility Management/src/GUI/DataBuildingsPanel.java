package GUI;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import classes.Building;

public class DataBuildingsPanel extends JPanel {

    private JLabel dataLabel;
    private JButton buttonTicket;
    private JButton buttonSave;

    public DataBuildingsPanel() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        dataLabel = new JLabel("Hier werden Daten angezeigt");
        add(dataLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        buttonTicket = new JButton("Ticket erstellen");
        buttonPanel.add(buttonTicket);

        buttonSave = new JButton("Speichern");
        buttonPanel.add(buttonSave);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void updateData(String data) {
        dataLabel.setText(data);
    }

    public void updateData(Building building) {
        dataLabel.setText("Es klappt: " + building.getAddress());
    }
}
