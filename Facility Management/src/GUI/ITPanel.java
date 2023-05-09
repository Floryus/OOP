package GUI;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ITPanel extends JPanel {
    public ITPanel() {
        setLayout(new BorderLayout());
        add(new JLabel("IT panel"), BorderLayout.CENTER);
    }
}
