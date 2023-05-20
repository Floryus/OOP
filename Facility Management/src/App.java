
import java.util.ArrayList;

import GUI.FullScreenMain;
import classes.Building;
import classes.Level;
import classes.Portfolio;
import classes.Room;
import enums.GroupEnum;
import enums.PriorityEnum;
import ticketSystem.Ticket;

public class App {
    public static void main(String[] args) throws Exception {

        Portfolio port = new Portfolio("Test portfolio");
        Building ber = new Building("ber", 3, "bla");
        Level bl1 = ber.createLevel(10);
        Room bl1r1 = bl1.createRoom(null);

        Building wdf = new Building("wdf", 3, "bla");
        Level wl1 = wdf.createLevel(10);
        Room wl1r1 = wl1.createRoom(null);
        Room wl1r2 = wl1.createRoom(null);

        Level wl2 = wdf.createLevel(10);
        Room wl2r1 = wl2.createRoom(null);
        Room wl2r2 = wl2.createRoom(null);

        Building seo = new Building("seo", 3, "bla");
        Level sl1 = seo.createLevel(10);
        Room sl1r1 = sl1.createRoom(null);
        Room sl1r2 = sl1.createRoom(null);
        Room sl1r3 = sl1.createRoom(null);

        Level sl2 = seo.createLevel(10);
        Room sl2r1 = sl2.createRoom(null);
        Room sl2r2 = sl2.createRoom(null);

        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        tickets.add(0, new Ticket("Titel 1", "Das hier ist der Inhalt", PriorityEnum.HIGH, null, GroupEnum.CLEANING));
        tickets.add(0, new Ticket("Titel 1", "Das hier ist der Inhalt", PriorityEnum.LOW, null, GroupEnum.IT));
        tickets.add(0, new Ticket("Titel 2", "Das hier ist der Inhalt", PriorityEnum.MEDIUM, null, GroupEnum.FACILITY));
        tickets.add(0, new Ticket("Titel 3", "Das hier ist der Inhalt", PriorityEnum.HIGH, null, GroupEnum.CLEANING));
        tickets.add(0, new Ticket("Titel 4", "Das hier ist der Inhalt", PriorityEnum.URGENT, null, GroupEnum.IT));
        tickets.add(0, new Ticket("Titel 5", "Das hier ist der Inhalt", PriorityEnum.LOW, null, GroupEnum.FACILITY));
        tickets.add(0, new Ticket("Titel 6", "Das hier ist der Inhalt", PriorityEnum.MEDIUM, null, GroupEnum.CLEANING));
        tickets.add(0, new Ticket("Titel 7", "Das hier ist der Inhalt", PriorityEnum.HIGH, null, GroupEnum.IT));
        tickets.add(0, new Ticket("Titel 8", "Das hier ist der Inhalt", PriorityEnum.URGENT, null, GroupEnum.FACILITY));
        tickets.add(0, new Ticket("Titel 9", "Das hier ist der Inhalt", PriorityEnum.LOW, null, GroupEnum.CLEANING));
        FullScreenMain gui = new FullScreenMain(tickets);
        gui.setVisible(true);
    }
}
