package GUI;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import classes.Building;
import classes.Level;
import classes.Portfolio;
import classes.Room;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BuildingsPanel extends JPanel {

    private JTree tree;
    private DefaultTreeModel treeModel;

    public BuildingsPanel() {
        setLayout(new BorderLayout());
        add(new JLabel("Buildings panel"), BorderLayout.CENTER);
        initComponents();
        buildTree();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        tree = new JTree();
        JScrollPane scrollPane = new JScrollPane(tree);

        add(scrollPane, BorderLayout.CENTER);

        // Hinzufügen des TreeSelectionListeners zum JTree
        tree.addTreeSelectionListener(e -> {
            // Erhalten des ausgewählten TreePath
            TreePath selectedPath = tree.getSelectionPath();
            if (selectedPath != null) {
                // Erhalten des ausgewählten Knotens
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) selectedPath.getLastPathComponent();

                // Anzeigen des Popups basierend auf dem ausgewählten Knoten
                showPopup(selectedNode);
            }
        });
    }

    private void buildTree() {
        // Erstelle den Wurzelknoten des Baums
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Building Portfolio");

        // Füge Gebäude hinzu
        ArrayList<Building> buildings = Portfolio.getBuildings();
        Collections.sort(buildings);
        for (Building building : buildings) {
            BuildingTreeNode buildingNode = new BuildingTreeNode(building);
            DefaultMutableTreeNode buildingTreeNode = new DefaultMutableTreeNode(buildingNode);
            root.add(buildingTreeNode);

            // Füge Etage hinzu
            ArrayList<Level> levels = building.getLevels();
            Collections.sort(levels);
            for (Level level : levels) {
                DefaultMutableTreeNode levelNode = new DefaultMutableTreeNode("Level " + level.getLevelNumber());
                buildingTreeNode.add(levelNode);

                // Füge Räume hinzu
                ArrayList<Room> rooms = level.getRooms();
                Collections.sort(rooms);
                for (Room room : rooms) {
                    DefaultMutableTreeNode roomNode = new DefaultMutableTreeNode(room.getName());
                    levelNode.add(roomNode);

                    // TODO: Add Equipment loop
                }
            }
        }

        // Erstelle das TreeModel mit dem Wurzelknoten
        treeModel = new DefaultTreeModel(root);
        tree.setModel(treeModel);
    }

    private void showPopup(DefaultMutableTreeNode node) {
        // Erstellen des Popup-Menüs
        JPopupMenu popupMenu = new JPopupMenu();

        // Hinzufügen von Menüelementen
        JMenuItem menuItem = new JMenuItem("Info");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aktion ausführen, wenn "Info" ausgewählt wird
                // Hier kannst du entsprechende Logik für das ausgewählte Element ausführen
                System.out.println("Info selected for: " + node.getUserObject());

                // Überprüfen, ob der Knoten Building Klasse verwendet
                if (node.getUserObject() instanceof BuildingTreeNode) {
                    // Zugriff auf das Objekt der benutzerdefinierten Klasse erhalten
                    BuildingTreeNode buildingTreeNode = (BuildingTreeNode) node.getUserObject();
                    Building building = buildingTreeNode.getBuilding();
                    System.out.println("Building selected: " + building.getAddress());
                }

            }
        });
        popupMenu.add(menuItem);

        // Anzeigen des Popups an der Position des ausgewählten Elements
        Rectangle bounds = tree.getPathBounds(tree.getSelectionPath());
        popupMenu.show(tree, bounds.x + bounds.width, bounds.y);
    }

    private class BuildingTreeNode {
        private Building building;

        public BuildingTreeNode(Building building) {
            this.building = building;
        }

        public Building getBuilding() {
            return building;
        }

        @Override
        public String toString() {
            return building.getName();
        }
    }
}
