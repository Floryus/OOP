import javax.swing.SwingUtilities;

import GUI.TicketForm;
import classes.Building;
import classes.Equipment;
import classes.GroupEnum;
import classes.Room;
import ticketSystem.PriorityEnum;
import ticketSystem.Ticket;

public class App {
    public static void main(String[] args) throws Exception {
        /*
         * System.out.println("I create a ticket for a room!");
         * 
         * Building rc = new Building("Ritz Carlton");
         * Room lobbyRoom = new Room(rc, 2);
         * System.out.println(lobbyRoom.getName());
         * 
         * Ticket cleaningProblem = new Ticket("Dreckiger Teppich",
         * "Jemand hat Orangensaft verschüttet. ",
         * PriorityEnum.HIGH, lobbyRoom, GroupEnum.CLEANING);
         * 
         * System.out.println(cleaningProblem.getEverything());
         * cleaningProblem.updateStatus();
         * System.out.println("\n");
         * System.out.println(cleaningProblem.getEverything());
         * 
         * Equipment tv = new Equipment("Fernseher 13");
         * Ticket tvProblemTicket = new Ticket("Screen kaputt", "Loch drin",
         * PriorityEnum.URGENT, tv, GroupEnum.IT);
         * 
         * System.out.println(tvProblemTicket.getEverything());
         * tvProblemTicket.updateStatus();
         * System.out.println("\n");
         * System.out.println(tvProblemTicket.getEverything());
         * 
         */

        TicketForm gui = new TicketForm();
        gui.setVisible(true);

    }
}
