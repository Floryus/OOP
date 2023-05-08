package ticketSystem;

import java.util.Arrays;
import java.util.Date;

public class Ticket {
    // Basic info
    String title;
    String description;

    // Setup info
    PriorityEnum prio;
    final Date creationDate;

    // Handling info
    Date dueDate;
    Object item;

    // Progress info
    boolean isArchived;
    StatusEnum status;

    public Ticket(String title, String description, PriorityEnum prio, Object item) {

        // Fixed
        this.isArchived = false;
        creationDate = new Date();
        status = StatusEnum.OPEN;

        // Input
        this.title = title;
        this.description = description;
        // this.dueDate = dueDate;
        this.prio = prio;
        this.item = item;

    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getEverything() {
        return this.title + "\n" + this.description + "\n" + this.creationDate + "\n" + this.prio + "\n"
                + this.item.getClass() + "\n" + this.status;
    }

    public void updateStatus() {
        // Only goes to the next Status
        StatusEnum[] arr = StatusEnum.values();
        int curr = Arrays.asList(arr).indexOf(this.status);
        if (curr == 4) {
            this.isArchived = true;
            return;
        }
        this.status = arr[curr + 1];
    }
}
