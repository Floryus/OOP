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
                if (selectedNode.getUserObject() instanceof AddTreeNode) {
                    System.out.println("New selected");

                    // TODO: Logic to add rooms, levels and buildings

                } else {
                    // Anzeigen des Popups basierend auf dem ausgewählten Knoten
                    showPopup(selectedNode);
                }

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
                LevelTreeNode levelNode = new LevelTreeNode(level);
                DefaultMutableTreeNode levelTreeNode = new DefaultMutableTreeNode(levelNode);
                buildingTreeNode.add(levelTreeNode);

                // Füge Räume hinzu
                ArrayList<Room> rooms = level.getRooms();
                Collections.sort(rooms);
                for (Room room : rooms) {
                    RoomTreeNode roomNode = new RoomTreeNode(room);
                    DefaultMutableTreeNode roomTreeNode = new DefaultMutableTreeNode(roomNode);
                    levelTreeNode.add(roomTreeNode);

                    // TODO: Add Equipment loop
                }
                if (level.getRooms().size() < level.getMaxRooms()) {
                    AddTreeNode addNode = new AddTreeNode();
                    DefaultMutableTreeNode addTreeNode = new DefaultMutableTreeNode(addNode);
                    levelTreeNode.add(addTreeNode);
                }

            }
            if (building.getLevels().size() < building.getMaxLevels()) {
                AddTreeNode addNode = new AddTreeNode();
                DefaultMutableTreeNode addTreeNode = new DefaultMutableTreeNode(addNode);
                buildingTreeNode.add(addTreeNode);
            }
        }
        AddTreeNode addNode = new AddTreeNode();
        DefaultMutableTreeNode addTreeNode = new DefaultMutableTreeNode(addNode);
        root.add(addTreeNode);

        // Erstelle das TreeModel mit dem Wurzelknoten
        treeModel = new DefaultTreeModel(root);
        tree.setModel(treeModel);
    }

    private void showPopup(DefaultMutableTreeNode node) {
        // Erstellen des Popup-Menüs
        JPopupMenu popupMenu = new JPopupMenu();

        // Hinzufügen von Menüelementen
        JMenuItem menuItemInfo = new JMenuItem("Info");
        JMenuItem menuItemEdit = new JMenuItem("Edit");

        menuItemInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aktion ausführen, wenn "Info" ausgewählt wird
                System.out.println("Info selected for: " + node.getUserObject() + node.getUserObject().getClass());

                // Überprüfen, ob der Knoten Building Klasse verwendet
                if (node.getUserObject() instanceof BuildingTreeNode) {
                    // Zugriff auf das Objekt der benutzerdefinierten Klasse erhalten
                    BuildingTreeNode buildingTreeNode = (BuildingTreeNode) node.getUserObject();
                    Building building = buildingTreeNode.getBuilding();
                    System.out.println("Building selected: " + building);
                } else if (node.getUserObject() instanceof LevelTreeNode) {
                    // Zugriff auf das Objekt der benutzerdefinierten Klasse erhalten
                    LevelTreeNode levelTreeNode = (LevelTreeNode) node.getUserObject();
                    Level level = levelTreeNode.getLevel();
                    System.out.println("Level selected: " + level);
                } else if (node.getUserObject() instanceof RoomTreeNode) {
                    // Zugriff auf das Objekt der benutzerdefinierten Klasse erhalten
                    RoomTreeNode roomTreeNode = (RoomTreeNode) node.getUserObject();
                    Room room = roomTreeNode.getRoom();
                    System.out.println("Room selected: " + room);
                }

            }
        });

        // Items hinzufügen
        popupMenu.add(menuItemInfo);
        popupMenu.add(menuItemEdit);

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

    private class LevelTreeNode {
        private Level level;

        public LevelTreeNode(Level level) {
            this.level = level;
        }

        public Level getLevel() {
            return level;
        }

        @Override
        public String toString() {
            return "Level " + String.valueOf(level.getLevelNumber());
        }
    }

    private class RoomTreeNode {
        private Room room;

        public RoomTreeNode(Room room) {
            this.room = room;
        }

        public Room getRoom() {
            return room;
        }

        @Override
        public String toString() {
            return "Room " + String.valueOf(room.getName());
        }
    }

    private class AddTreeNode {

        @Override
        public String toString() {
            return "+ NEW";
        }
    }

}
