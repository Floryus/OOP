import java.util.ArrayList;
import java.util.GregorianCalendar;

import GUI.FullScreenMain;
import classes.Address;
import classes.Building;
import classes.Equipment;
import classes.Level;
import classes.GlobalData;
import classes.Room;
import classes.Ticket;
import enums.EquipTypeEnum;
import enums.GroupEnum;
import enums.PriorityEnum;
import test.*;

public class App {

        /**
         * @param args
         * @throws Exception
         */
        public static void main(String[] args) throws Exception {

                Building ber = GlobalData.createBuilding("Berlin", 5, new Address("Straße ", 17, 14532, "Berlin"), 50,
                                2000,
                                20);
                Level bl1 = ber.createLevel(10);
                Room bl1r1 = bl1.createRoom("Schöneberg", null);
                bl1r1.addEquipment(new Equipment("Test", EquipTypeEnum.PROJECTOR, new GregorianCalendar(2004, 9, 5), 2,
                                bl1r1));

                Building wdf = GlobalData.createBuilding("Walldorf", 5, new Address("Straße ", 17, 14532, "Berlin"), 50,
                                2000,
                                20);

                Level wl1 = wdf.createLevel(2);
                Room wl1r1 = wl1.createRoom("Kreuzberg", null);
                Room wl1r2 = wl1.createRoom("Wedding", null);

                Level wl2 = wdf.createLevel(10);
                Room wl2r1 = wl2.createRoom("Marzan", null);
                Room wl2r2 = wl2.createRoom("Spandau", null);

                Building seo = GlobalData.createBuilding("Seoul", 5, new Address("Straße ", 17, 14532, "Berlin"), 50,
                                2000,
                                20);

                Level sl1 = seo.createLevel(10);
                Room sl1r1 = sl1.createRoom("", null);
                Room sl1r2 = sl1.createRoom("", null);
                Room sl1r3 = sl1.createRoom("", null);

                Level sl2 = seo.createLevel(10);
                Room sl2r1 = sl2.createRoom("", null);
                Room sl2r2 = sl2.createRoom("", null);

                Ticket t = GlobalData.addTicket("Titel 1", "Das hier ist der Inhalt", PriorityEnum.HIGH, null,
                                GroupEnum.CLEANING);
                GlobalData.addTicket("Titel 1", "Das hier ist der Inhalt", PriorityEnum.LOW, null, GroupEnum.IT);
                GlobalData.addTicket("Titel 2", "Das hier ist der Inhalt", PriorityEnum.MEDIUM, null,
                                GroupEnum.FACILITY);
                GlobalData.addTicket("Titel 3", "Das hier ist der Inhalt", PriorityEnum.HIGH, null, GroupEnum.CLEANING);
                GlobalData.addTicket("Titel 4", "Das hier ist der Inhalt", PriorityEnum.URGENT, null, GroupEnum.IT);
                GlobalData.addTicket("Titel 5", "Das hier ist der Inhalt", PriorityEnum.LOW, null, GroupEnum.FACILITY);
                GlobalData.addTicket("Titel 6", "Das hier ist der Inhalt", PriorityEnum.MEDIUM, null,
                                GroupEnum.CLEANING);
                GlobalData.addTicket("Titel 7", "Das hier ist der Inhalt", PriorityEnum.HIGH, null, GroupEnum.IT);
                GlobalData.addTicket("Titel 8", "Das hier ist der Inhalt", PriorityEnum.URGENT, null,
                                GroupEnum.FACILITY);
                GlobalData.addTicket("Titel 9", "Das hier ist der Inhalt", PriorityEnum.LOW, null, GroupEnum.CLEANING);

                GlobalData.addEmployee("Horst", GroupEnum.CLEANING);
                GlobalData.addEmployee("Tim", GroupEnum.IT);
                GlobalData.addEmployee("Manfred", GroupEnum.CLEANING);
                GlobalData.addEmployee("Thiele", GroupEnum.CLEANING);
                GlobalData.addEmployee("Siegfried", GroupEnum.IT);
                GlobalData.addEmployee("Thomas", GroupEnum.FACILITY);
                GlobalData.addEmployee("Meer", GroupEnum.FACILITY);
                System.out.println(GlobalData.getEmployees().size());

                FullScreenMain gui = new FullScreenMain(GlobalData.getTickets());
                gui.setVisible(true);

                ArrayList<Ticket> arl = GlobalData.getTickets();
                int i = arl.indexOf(t);
                arl.set(i, t);

                // testing
                TestManager.testMethods();

        }
}
