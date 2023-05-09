
import java.util.ArrayList;

import GUI.TicketForm;
import ticketSystem.Ticket;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        TicketForm gui = new TicketForm(tickets);
        gui.setVisible(true);

        System.out.println(tickets.toString());

        int timeout = 5000; // Timeout in Millisekunden (hier 5 Sekunden)

        try {
            Thread.sleep(timeout);
            System.out.println("Timeout ist abgelaufen");
            System.out.println(tickets.toString());
        } catch (InterruptedException e) {
            System.out.println("Der Timeout wurde unterbrochen");
        }

    }
}
