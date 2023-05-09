
import java.util.ArrayList;

import GUI.FullScreenMain;
import classes.GroupEnum;
import ticketSystem.PriorityEnum;
import ticketSystem.Ticket;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        tickets.add(0, new Ticket("Titel 1", "Das hier ist der Inhalt", PriorityEnum.HIGH, null, GroupEnum.CLEANING));

        FullScreenMain gui = new FullScreenMain(tickets);
        gui.setVisible(true);

    }
}
