/**
 * Maderazo
 * */

public class Wheels {
    private int numOfWheels;
    private String wheelType;

    // constructor
    public Wheels(int numOfWheels, String wheelType) {
        this.numOfWheels = numOfWheels;
        this.wheelType = wheelType;
    }

    // getter and setter
    public int getNumOfWheels() {
        return numOfWheels;
    }

    public int setNumOfWheels(int newNumOfWheels) {
        return numOfWheels = newNumOfWheels;
    }

    public String getWheelType() {
        return wheelType;
    }

    public String setWheelType(String newWheelType) {
        return wheelType = newWheelType;
    }

    // rotate() method
    public String rotate() {
        return "The " + wheelType + " wheel is rotating.";
    }

    // stop() method
    public String stop() {
        return "The " + wheelType + " wheel has stopped.";
    }
}
