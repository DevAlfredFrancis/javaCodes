/**
 * Maderazo
 * */

public class Seats {
    private int seatCapacity;
    private String seatType;

    // constructor
    public Seats(int seatCapacity, String seatType) {
        this.seatCapacity = seatCapacity;
        this.seatType = seatType;
    }

    // getter and setter
    public int getSeatCapacity() {
        return seatCapacity;
    }

    public int setSeatCapacity(int newSeatCapacity) {
        return seatCapacity = newSeatCapacity;
    }

    public String getSeatType() {
        return seatType;
    }

    public String setSeatType(String newSeatType) {
        return seatType = newSeatType;
    }

    // isComfy() method
    public String isComfy() {
        if (seatType.equalsIgnoreCase("Comfortable") || seatType.equalsIgnoreCase("Touring")) {
            return "The seat is comfortable for " + seatCapacity + " person(s).";
        } else {
            return "Seat type not specified, comfort is unknown.";
        }
    }
}
