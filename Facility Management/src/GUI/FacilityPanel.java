package GUI;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class FacilityPanel extends JPanel {
    public FacilityPanel() {
        setLayout(new BorderLayout());
        add(new JLabel("Facility panel"), BorderLayout.CENTER);
    }
}