
public class Vehicle {
    private int year;
    private String model;

    public Vehicle() {
        start();
        move();
    }

    public void start() {
        System.out.println("Engine start");
    }

    public void stop() {
        System.out.println("Engine stop");
    }

    public void move() {
        System.out.println("Vehicle move");
    }

}
