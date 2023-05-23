package GUI;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import classes.Building;
import classes.Level;
import classes.GlobalData;
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
    private DataBuildingsPanel dataPanel;
    private DefaultTreeModel treeModel;

    public BuildingsPanel() {

        setLayout(new BorderLayout());
        add(new JLabel("Buildings panel"), BorderLayout.CENTER);
        initComponents();
        buildTree();
        buildDataPanel();
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

                // Logik falls "New"-Knoten ausgewählt ist
                if (selectedNode.getUserObject() instanceof AddTreeNode) {
                    System.out.println("New selected" + selectedNode.getUserObject().toString());

                    AddTreeNode roomTreeNode = (AddTreeNode) selectedNode.getUserObject();
                    if (roomTreeNode.building != null) {
                        // createLevel - maxRooms
                        AddLevelPopup addLevelPopup = new AddLevelPopup(this, roomTreeNode.building);
                        addLevelPopup.setVisible(true);
                    } else if (roomTreeNode.level != null) {
                        // createRoom - Room Types Enum
                        AddRoomPopup addRoomPopup = new AddRoomPopup(this, roomTreeNode.level);
                        addRoomPopup.setVisible(true);
                    } else {
                        // createBuilding - name, maxLevels, address
                        AddBuildingPopup addBuildingPopup = new AddBuildingPopup(this);
                        addBuildingPopup.setVisible(true);
                    }

                } else {
                    // Anzeigen des Popups basierend auf dem ausgewählten Knoten
                    // TODO: exchange Popup with Panel
                    showPopup(selectedNode);
                }

            }
        });
    }

    private void buildTree() {
        // Erstelle den Wurzelknoten des Baums
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("All buildings");

        // Füge Gebäude hinzu
        ArrayList<Building> buildings = GlobalData.getBuildings();
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
                    AddTreeNode addNode = new AddTreeNode(level);
                    DefaultMutableTreeNode addTreeNode = new DefaultMutableTreeNode(addNode);
                    levelTreeNode.add(addTreeNode);
                }

            }
            if (building.getLevels().size() < building.getMaxLevels()) {
                AddTreeNode addNode = new AddTreeNode(building);
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

    public void reloadTree() {
        buildTree();
    }

    private void showPopup(DefaultMutableTreeNode node) {
        // Erstellen des Popup-Menüs
        JPopupMenu popupMenu = new JPopupMenu();

        // Hinzufügen von Menüelementen
        JMenuItem menuItemInfo = new JMenuItem("Info");
        JMenuItem menuItemDelete = new JMenuItem("Delete");

        menuItemDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aktion ausführen, wenn "Info" ausgewählt wird
                System.out.println("Info selected for: " + node.getUserObject() + node.getUserObject().getClass());

                // Überprüfen, ob der Knoten Building Klasse verwendet
                if (node.getUserObject() instanceof BuildingTreeNode) {
                    // Zugriff auf das Objekt der benutzerdefinierten Klasse erhalten
                    BuildingTreeNode buildingTreeNode = (BuildingTreeNode) node.getUserObject();
                    Building building = buildingTreeNode.getBuilding();
                    building.delete();
                    reloadTree();
                } else if (node.getUserObject() instanceof LevelTreeNode) {
                    // Zugriff auf das Objekt der benutzerdefinierten Klasse erhalten
                    LevelTreeNode levelTreeNode = (LevelTreeNode) node.getUserObject();
                    Level level = levelTreeNode.getLevel();
                    level.delete();
                    reloadTree();
                } else if (node.getUserObject() instanceof RoomTreeNode) {
                    // Zugriff auf das Objekt der benutzerdefinierten Klasse erhalten
                    RoomTreeNode roomTreeNode = (RoomTreeNode) node.getUserObject();
                    Room room = roomTreeNode.getRoom();
                    room.delete();
                    reloadTree();
                }
                // TODO: Equipment case

            }
        });

        menuItemInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Überprüfen, ob der Knoten Building Klasse verwendet
                if (node.getUserObject() instanceof BuildingTreeNode) {
                    // Zugriff auf das Objekt der benutzerdefinierten Klasse erhalten
                    BuildingTreeNode buildingTreeNode = (BuildingTreeNode) node.getUserObject();
                    Building building = buildingTreeNode.getBuilding();
                    dataPanel.updateData(building);
                } else if (node.getUserObject() instanceof LevelTreeNode) {
                    // Zugriff auf das Objekt der benutzerdefinierten Klasse erhalten
                    LevelTreeNode levelTreeNode = (LevelTreeNode) node.getUserObject();
                    Level level = levelTreeNode.getLevel();
                    dataPanel.updateData(level);
                } else if (node.getUserObject() instanceof RoomTreeNode) {
                    // Zugriff auf das Objekt der benutzerdefinierten Klasse erhalten
                    RoomTreeNode roomTreeNode = (RoomTreeNode) node.getUserObject();
                    Room room = roomTreeNode.getRoom();
                    dataPanel.updateData(room);
                }

                // TODO: Equipment case
            }
        });

        // Items hinzufügen
        popupMenu.add(menuItemInfo);
        popupMenu.add(menuItemDelete);

        // Anzeigen des Popups an der Position des ausgewählten Elements
        Rectangle bounds = tree.getPathBounds(tree.getSelectionPath());
        popupMenu.show(tree, bounds.x + bounds.width, bounds.y);
    }

    private void buildDataPanel() {
        dataPanel = new DataBuildingsPanel(this);

        add(dataPanel, BorderLayout.EAST);
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

        private Building building;
        private Level level;

        // For create Building
        public AddTreeNode() {
        }

        // For create level
        public AddTreeNode(Building building) {
            this.building = building;
        }

        // For create room
        public AddTreeNode(Level level) {
            this.level = level;
        }

        @Override
        public String toString() {
            return "+ NEW";
        }
    }

}
