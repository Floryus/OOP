package ticketSystem;

import java.util.Arrays;
import java.util.GregorianCalendar;

import classes.Todo;
import classes.Maintainable;
import enums.GroupEnum;
import enums.PriorityEnum;
import enums.StatusEnum;

public class Ticket extends Todo implements Comparable<Ticket> {
    // Handling info
    GregorianCalendar dueDate;
    Maintainable item;
    GroupEnum group;
    boolean isArchived;
    StatusEnum status;

    public Ticket(String title, String description, PriorityEnum prio, GregorianCalendar dueDate, Maintainable item,
            GroupEnum group) {
        super(title, description, prio);
        // Fixed
        this.isArchived = false;
        status = StatusEnum.OPEN;

        // Input
        // this.dueDate = dueDate;
        this.item = item;
        this.group = group;
        this.dueDate = dueDate;
    }

    /**
     * @return String
     */
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public GroupEnum getGroup() {
        return group;
    }

    public PriorityEnum getPrio() {
        return prio;
    }

    @Override
    public int compareTo(Ticket other) {
        return this.prio.compareTo(other.prio);
    }

    public String toString() {
        return this.title + " is for " + this.group + " with prio " + this.prio;
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

    public StatusEnum getStatus() {
        return null;
    }
}
