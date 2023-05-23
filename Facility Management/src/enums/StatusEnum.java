package enums;

public enum StatusEnum {
    OPEN, ASSIGNED, INPROGRESS, FINISHED, ARCHIVED;

    public StatusEnum getNextStatus() {
        return null;
    }
}
