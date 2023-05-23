package enums;

public enum RoomFlooringEnum {
    CARPET("Teppich"),
    TILE("Fliesen"),
    LINOLEUM("Linoleum");

    private String flooring;

    RoomFlooringEnum(String flooring) {
        this.flooring = flooring;
    }

    public String getFlooring() {
        return flooring;
    }
}
