/**
 * Mesa
 * */

public class Headlight {
    private String type;
    private int brightness;

    public Headlight(String type, int brightness) {
        this.type = type;
        this.brightness = brightness;
    }

    public void turnOn() {
        System.out.println(type + " headlight is ON with brightness " + brightness);
    }

    public void turnOff() {
        System.out.println(type + " headlight is OFF");
    }

}
