package GUI;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import classes.Building;
import classes.Equipment;
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

import java.awt.BorderLayout;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

/*
 * Dieses Panel ist das GUI für das Building Panel.
 * Es bietet eine Baumansicht der Gebäude, Etagen und Räume, sowie deren Equipment.
 * Es erlaubt CRUD Operationen.
 * Es erlaubt das Anzeigen von Informationen zu den selektierten Objekten.
 * Es erlaubt das Erstellen von Tickets.
 * 
 * Autor: Florian Schmidt
 * 
 * Version: 3.4
 */
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

    /**
     * Initialisiert die Komponenten des Panels.
     */
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

                    AddTreeNode treeNode = (AddTreeNode) selectedNode.getUserObject();
                    if (treeNode.building != null) {
                        // createLevel - maxRooms
                        AddLevelPopup addLevelPopup = new AddLevelPopup(this, treeNode.building);
                        addLevelPopup.setVisible(true);
                    } else if (treeNode.level != null) {
                        // createRoom - Room Types Enum
                        AddRoomPopup addRoomPopup = new AddRoomPopup(this, treeNode.level);
                        addRoomPopup.setVisible(true);
                    } else if (treeNode.room != null) {
                        // createEquipment - name, description, price, warranty, purchaseDate
                        AddEquipmentPopup addEquipmentPopup = new AddEquipmentPopup(this,
                                treeNode.room);
                        addEquipmentPopup.setVisible(true);
                    } else {
                        // createBuilding - name, maxLevels, address
                        AddBuildingPopup addBuildingPopup = new AddBuildingPopup(this);
                        addBuildingPopup.setVisible(true);
                    }

                } else {
                    // Anzeigen des Popups basierend auf dem ausgewählten Knoten

                    if (selectedNode.getUserObject() instanceof BuildingTreeNode) {
                        // Zugriff auf das Objekt der benutzerdefinierten Klasse erhalten
                        BuildingTreeNode buildingTreeNode = (BuildingTreeNode) selectedNode.getUserObject();
                        Building building = buildingTreeNode.getBuilding();
                        dataPanel.updateData(building);
                        showPopup(selectedNode);
                    } else if (selectedNode.getUserObject() instanceof LevelTreeNode) {
                        // Zugriff auf das Objekt der benutzerdefinierten Klasse erhalten
                        LevelTreeNode levelTreeNode = (LevelTreeNode) selectedNode.getUserObject();
                        Level level = levelTreeNode.getLevel();
                        dataPanel.updateData(level);
                        showPopup(selectedNode);
                    } else if (selectedNode.getUserObject() instanceof RoomTreeNode) {
                        // Zugriff auf das Objekt der benutzerdefinierten Klasse erhalten
                        RoomTreeNode roomTreeNode = (RoomTreeNode) selectedNode.getUserObject();
                        Room room = roomTreeNode.getRoom();
                        dataPanel.updateData(room);
                        showPopup(selectedNode);
                    } else if (selectedNode.getUserObject() instanceof EquipmentTreeNode) {
                        // Zugriff auf das Objekt der benutzerdefinierten Klasse erhalten
                        EquipmentTreeNode equipmentTreeNode = (EquipmentTreeNode) selectedNode.getUserObject();
                        Equipment equipment = equipmentTreeNode.getEquipment();
                        dataPanel.updateData(equipment);
                        showPopup(selectedNode);
                    }
                }

            }
        });
    }

    /**
     * Erstellt den Baum mit den Gebäuden, Etagen, Räumen und Equipment.
     */
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

                    // Füge Equipment hinzu
                    ArrayList<Equipment> equipments = room.getEquipmentList();
                    Collections.sort(equipments);
                    for (Equipment equip : equipments) {
                        EquipmentTreeNode equipmentNode = new EquipmentTreeNode(equip);
                        DefaultMutableTreeNode equipmentTreeNode = new DefaultMutableTreeNode(equipmentNode);
                        roomTreeNode.add(equipmentTreeNode);
                    }
                    AddTreeNode addNode = new AddTreeNode(room);
                    DefaultMutableTreeNode addTreeNode = new DefaultMutableTreeNode(addNode);
                    roomTreeNode.add(addTreeNode);

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

    /**
     * Aktualisiert den Baum.
     */
    public void reloadTree() {
        buildTree();
    }

    /**
     * Zeigt das Popup-Menü für den ausgewählten Knoten an.
     *
     * @param node Der ausgewählte Knoten
     */
    private void showPopup(DefaultMutableTreeNode node) {
        // Erstellen des Popup-Menüs
        JPopupMenu popupMenu = new JPopupMenu();

        // Hinzufügen von Menüelementen
        JMenuItem menuItemDelete = new JMenuItem("Delete");

        menuItemDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aktion ausführen, wenn "Delete" ausgewählt wird
                System.out.println("Delete selected for: " + node.getUserObject() + node.getUserObject().getClass());

                // Überprüfen, um welche Art von Knoten es sich handelt und die entsprechende
                // Aktion ausführen
                if (node.getUserObject() instanceof BuildingTreeNode) {
                    BuildingTreeNode buildingTreeNode = (BuildingTreeNode) node.getUserObject();
                    Building building = buildingTreeNode.getBuilding();
                    building.delete();
                    reloadTree();
                } else if (node.getUserObject() instanceof LevelTreeNode) {
                    LevelTreeNode levelTreeNode = (LevelTreeNode) node.getUserObject();
                    Level level = levelTreeNode.getLevel();
                    level.delete();
                    reloadTree();
                } else if (node.getUserObject() instanceof RoomTreeNode) {
                    RoomTreeNode roomTreeNode = (RoomTreeNode) node.getUserObject();
                    Room room = roomTreeNode.getRoom();
                    room.delete();
                    reloadTree();
                } else if (node.getUserObject() instanceof EquipmentTreeNode) {
                    EquipmentTreeNode equipmentTreeNode = (EquipmentTreeNode) node.getUserObject();
                    Equipment equipment = equipmentTreeNode.getEquipment();
                    equipment.delete();
                    reloadTree();
                }
            }
        });

        popupMenu.add(menuItemDelete);

        // Anzeigen des Popups an der Position des ausgewählten Elements
        Rectangle bounds = tree.getPathBounds(tree.getSelectionPath());
        popupMenu.show(tree, bounds.x + bounds.width, bounds.y);
    }

    /**
     * Baut das DataBuildingsPanel und fügt es dem Layout hinzu.
     */
    private void buildDataPanel() {
        dataPanel = new DataBuildingsPanel(this);
        add(dataPanel, BorderLayout.EAST);
    }

    /**
     * Klasse, die einen Knoten im Baum für ein Gebäude repräsentiert.
     */
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

    /**
     * Klasse, die einen Knoten im Baum für eine Etage repräsentiert.
     */
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

    /**
     * Klasse, die einen Knoten im Baum für einen Raum repräsentiert.
     */
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
            return "Raum " + String.valueOf(room.getName());
        }
    }

    /**
     * Klasse, die einen Knoten im Baum für ein Equipment repräsentiert.
     */
    private class EquipmentTreeNode {
        private Equipment equipment;

        public EquipmentTreeNode(Equipment equipment) {
            this.equipment = equipment;
        }

        public Equipment getEquipment() {
            return equipment;
        }

        @Override
        public String toString() {
            return "Equipment " + String.valueOf(equipment.getName());
        }
    }

    /**
     * Klasse, die einen Knoten im Baum für das Hinzufügen von Objekten
     * repräsentiert.
     */
    private class AddTreeNode {
        private Building building;
        private Level level;
        private Room room;

        public AddTreeNode() {
        }

        public AddTreeNode(Building building) {
            this.building = building;
        }

        public AddTreeNode(Level level) {
            this.level = level;
        }

        public AddTreeNode(Room room) {
            this.room = room;
        }

        @Override
        public String toString() {
            if (building != null) {
                return "Add Level";
            } else if (level != null) {
                return "Add Room";
            } else if (room != null) {
                return "Add Equipment";
            } else {
                return "Add Building";
            }
        }
    }
}
