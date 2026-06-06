/**
 * Mesa
 * */

public class Mirror {
    private int position;

    public Mirror(int position){
        this.position = position;
    }
    public void adjust() {
        System.out.println("Mirror adjusted to position " + position);
    }
}
