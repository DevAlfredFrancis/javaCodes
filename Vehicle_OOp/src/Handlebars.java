/**
 * Mesa
 * */

public class Handlebars {
    private int width;
    private int length;

    public Handlebars(int width, int length){
        this.width = width;
        this.length = length;
    }

    public void steer() {
        System.out.println("Handlebars (" + width + "x" + length + " cm) steering is functional!");
    }
}
