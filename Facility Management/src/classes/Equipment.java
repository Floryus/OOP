package classes;

public class Equipment extends maintainable implements Comparable<Equipment> {
    String name;
    boolean hasTicket;

    public Equipment(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public int compareTo(Equipment other) {
        return this.name.compareTo(other.name);
    }
}
